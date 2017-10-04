package com.tabeldata.controller;

import com.tabeldata.model.Dokter;
import com.tabeldata.model.Pasien;
import com.tabeldata.model.Rawat;
import com.tabeldata.model.Ruang;
import com.tabeldata.dao.DokterDao;
import com.tabeldata.dao.PasienDao;
import com.tabeldata.dao.RawatDao;
import com.tabeldata.dao.RuangDao;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diani
 */
@WebServlet(urlPatterns = {"/rawat/update"})
public class RawatUpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        String kodeRawat = req.getParameter("id");
        Rawat rawat = new Rawat();
        PasienDao pasienDao = new PasienDao();
        DokterDao dokterDao = new DokterDao();
        RuangDao ruangDao = new RuangDao();
        RawatDao rawatDao = new RawatDao();

        List<Pasien> listPasien = pasienDao.semuaDataPasien();
        List<Dokter> listDokter = dokterDao.semuaDataDokter();
        List<Ruang> listRuang = ruangDao.semuaDataRuang(Boolean.TRUE);
        rawat = rawatDao.cariRawatDenganId(Integer.valueOf(kodeRawat));

        req.setAttribute("listPasien", listPasien);
        req.setAttribute("listDokter", listDokter);
        req.setAttribute("listRuang", listRuang);
        req.setAttribute("rwt", rawat);
        req.getRequestDispatcher("/pages/rawat/updateRawat.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.

        Rawat rawatBaru = new Rawat();
        String rawatId = req.getParameter("id");
        rawatBaru.setId(Integer.valueOf(rawatId));

        String rawatPasienId = req.getParameter("rawatPasienId");
        Pasien pasien = new Pasien();
        pasien.setId(Integer.valueOf(rawatPasienId));
        rawatBaru.setPasienId(pasien);

        String rawatDokterId = req.getParameter("rawatDokterId");
        Dokter dokter = new Dokter();
        dokter.setId(Integer.valueOf(rawatDokterId));
        rawatBaru.setDokterId(dokter);

        String rawatRuangId = req.getParameter("rawatRuangId");
        Ruang ruang = new Ruang();
        ruang.setId(Integer.valueOf(rawatRuangId));
        rawatBaru.setRuangId(ruang);
        
        rawatBaru.setTanggalRegister(Timestamp.valueOf(LocalDateTime.now()));
        rawatBaru.setTanggalCheckout(Timestamp.valueOf(LocalDateTime.now()));
        
        RawatDao rawatDao = new RawatDao();
        
        rawatDao.update(rawatBaru.getId(), rawatBaru.getPasienId().getId(),rawatBaru.getDokterId().getId(), rawatBaru.getRuangId().getId(),rawatBaru.getTanggalRegister(), rawatBaru.getTanggalCheckout());
        
        resp.sendRedirect(req.getServletContext().getContextPath() + "/rawat/list");
    }
}
