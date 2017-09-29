
package com.tabeldata.controller;

import com.tabeldata.dao.RuangDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ruang/delete"})
public class RuangDeleteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
        Integer idRuang = Integer.valueOf(req.getParameter("ruangId"));
        RuangDao ruangDao = new RuangDao();
        ruangDao.hapusDataById(idRuang);
        resp.sendRedirect(req.getServletContext().getContextPath() + "/ruang/list");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        Integer idRuang = Integer.valueOf(req.getParameter("ruangId"));
        RuangDao ruangDao = new RuangDao();
        ruangDao.hapusDataById(idRuang);
        resp.sendRedirect(req.getServletContext().getContextPath() + "/ruang/list");

    }

}
