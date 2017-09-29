
package com.tabeldata.controller;

import com.tabeldata.dao.PasienDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/pasien/delete"})
public class PasienDeleteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
        Integer idPasien = Integer.valueOf(req.getParameter("pasienId"));
        PasienDao pasienDao = new PasienDao();
        pasienDao.hapusDataById(idPasien);
        resp.sendRedirect(req.getServletContext().getContextPath() + "/pasien/list");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        Integer idPasien = Integer.valueOf(req.getParameter("pasienId"));
        PasienDao pasienDao = new PasienDao();
        pasienDao.hapusDataById(idPasien);
        resp.sendRedirect(req.getServletContext().getContextPath() + "/pasien/list");

    }

}
