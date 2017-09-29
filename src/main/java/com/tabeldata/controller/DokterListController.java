
package com.tabeldata.controller;

import com.tabeldata.dao.DokterDao;
import com.tabeldata.model.Dokter;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/dokter/list"})
public class DokterListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.

        DokterDao dokterDao = new DokterDao();
        List<Dokter> dataDokter = dokterDao.semuaDataDokter();

        req.setAttribute("listDokter", dataDokter);
        req.getRequestDispatcher("/pages/dokter/index.jsp").forward(req, resp);
    }

}
