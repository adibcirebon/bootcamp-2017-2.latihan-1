package com.tabeldata.controller;

import com.tabeldata.dao.DokterDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/dokter/delete"})
public class DokterDeleteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
        Integer idDokter = Integer.valueOf((req.getParameter("dokterId")));
        DokterDao dokterDao = new DokterDao();
        dokterDao.hapusDokterById(idDokter);
        resp.sendRedirect(req.getServletContext().getContextPath() + "/dokter/list");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        Integer idDokter = Integer.valueOf((req.getParameter("dokterId")));
        DokterDao dokterDao = new DokterDao();
        dokterDao.hapusDokterById(idDokter);
        resp.sendRedirect(req.getServletContext().getContextPath() + "/dokter/list");
    }

}
