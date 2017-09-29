package com.tabeldata.controller;

import com.tabeldata.dao.RuangDao;
import com.tabeldata.model.Ruang;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADIB PC
 */
@WebServlet(urlPatterns = {"/ruang/new"})
public class RuangAddFormController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //   super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
        Ruang ruangBaru = new Ruang();

        ruangBaru.setNoRuangan(req.getParameter("ruangNoRuangan"));
        ruangBaru.setKosong(false);

        RuangDao ruangDao = new RuangDao();
        ruangDao.save(ruangBaru);

        resp.sendRedirect(req.getServletContext().getContextPath() + "/ruang/list");
    }

}
