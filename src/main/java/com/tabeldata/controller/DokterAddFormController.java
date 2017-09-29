
package com.tabeldata.controller;


import com.tabeldata.dao.DokterDao;
import com.tabeldata.model.Dokter;
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
@WebServlet(urlPatterns={"/dokter/new"})
public class DokterAddFormController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //   super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    Dokter dokterBaru= new Dokter();
    
    dokterBaru.setNama(req.getParameter("dokterName"));
    dokterBaru.setSpesialis(req.getParameter("dokterSpesialis"));
    
    DokterDao dokterDao = new DokterDao();
    dokterDao.save(dokterBaru);
       
    resp.sendRedirect(req.getServletContext().getContextPath()+"/dokter/list");
    }
   
}
