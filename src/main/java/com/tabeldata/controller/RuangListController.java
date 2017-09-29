
package com.tabeldata.controller;

import com.tabeldata.dao.RuangDao;
import com.tabeldata.model.Dokter;
import com.tabeldata.model.Ruang;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ruang/list"})
public class RuangListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.

        RuangDao ruangDao = new RuangDao();
        List<Ruang> dataRuang = ruangDao.semuaDataRuang();

        req.setAttribute("listRuang", dataRuang);
        req.getRequestDispatcher("/pages/ruang/index.jsp").forward(req, resp);
    }

}