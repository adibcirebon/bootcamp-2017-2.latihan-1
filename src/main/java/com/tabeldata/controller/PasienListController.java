package com.tabeldata.controller;

import com.tabeldata.dao.PasienDao;
import com.tabeldata.model.Pasien;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/pasien/list"})
public class PasienListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.

        PasienDao pasienDao = new PasienDao();
        List<Pasien> dataPasien = pasienDao.semuaDataPasien();

        req.setAttribute("listPasien", dataPasien);
        req.getRequestDispatcher("/pages/pasien/index.jsp").forward(req, resp);
    }

}
