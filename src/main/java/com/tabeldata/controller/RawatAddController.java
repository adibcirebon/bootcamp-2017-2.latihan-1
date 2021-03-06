package com.tabeldata.controller;

import com.tabeldata.dao.PasienDao;
import com.tabeldata.dao.DokterDao;
import com.tabeldata.dao.RuangDao;
import com.tabeldata.model.Pasien;
import com.tabeldata.model.Dokter;
import com.tabeldata.model.Rawat;
import com.tabeldata.model.Ruang;
import com.tabeldata.dao.RawatDao;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns = {"/rawat/new", "/rawat/update-proses"})
public class RawatAddController extends HttpServlet {

    private final Logger console = LoggerFactory.getLogger(RawatAddController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        PasienDao pasienDao = new PasienDao();
        DokterDao dokterDao = new DokterDao();
        RuangDao ruangDao = new RuangDao();

        List<Pasien> listPasien = pasienDao.semuaDataPasien();
        List<Dokter> listDokter = dokterDao.semuaDataDokter();
        List<Ruang> listRuang = ruangDao.semuaDataRuang(Boolean.TRUE);

        req.setAttribute("listPasien", listPasien);
        req.setAttribute("listDokter", listDokter);
        req.setAttribute("listRuang", listRuang);

        req.getRequestDispatcher("/pages/rawat/addRawat.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
        Rawat rawatBaru = new Rawat();
        Pasien pasien = new Pasien();
        Dokter dokter = new Dokter();
        Ruang ruang = new Ruang();

        rawatBaru.setTanggalRegister(Timestamp.valueOf(LocalDateTime.now()));
        rawatBaru.setTanggalCheckout(Timestamp.valueOf(LocalDateTime.now()));

        pasien.setId(Integer.valueOf(req.getParameter("rawatPasienId")));
        dokter.setId(Integer.valueOf(req.getParameter("rawatDokterId")));
        ruang.setId(Integer.valueOf(req.getParameter("rawatRuangId")));

        //rawatBaru.setPasienId(pasien);
        rawatBaru.setPasienId(pasien);
        rawatBaru.setDokterId(dokter);
        rawatBaru.setRuangId(ruang);

        RawatDao rawatDao = new RawatDao();
        try {
            rawatDao.simpanRawat(rawatBaru);
            console.info("pasienId: {}, dokterId: {}, ruangId: {}, waktuRegister: {}",
                    rawatBaru.getPasienId().getId(),
                    rawatBaru.getDokterId().getId(),
                    rawatBaru.getRuangId().getId(),
                    rawatBaru.getTanggalRegister());
            resp.sendRedirect(req.getServletContext().getContextPath() + "/rawat/list");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(RawatAddController.class.getName()).log(Level.SEVERE, null, ex);
            console.error("tidak dapat menyimpan data Rawat", ex);
        }

    }

}
