
package com.tabeldata.controller;

import com.tabeldata.model.Rawat;
import com.tabeldata.dao.RawatDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diani
 */
@WebServlet(urlPatterns = {"/rawat/delete"})
public class RawatDeleteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.

        Rawat rwt = new Rawat();
        rwt.setId(Integer.valueOf(req.getParameter("rawatId")));

        rwt = new RawatDao().cariRawatDenganId(rwt.getId());

        RawatDao rawatDao = new RawatDao();
        rawatDao.hapusRawatById(rwt);
        resp.sendRedirect(req.getServletContext().getContextPath() + "/rawat/list");

    }

}