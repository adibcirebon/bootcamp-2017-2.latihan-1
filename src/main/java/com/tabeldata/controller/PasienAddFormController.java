
package com.tabeldata.controller;



import com.tabeldata.dao.PasienDao;
import com.tabeldata.model.Pasien;
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
@WebServlet (urlPatterns={"/pasien/new"})
public class PasienAddFormController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //   super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    Pasien pasienBaru= new Pasien();
    
    pasienBaru.setNama(req.getParameter("pasienNama"));
    pasienBaru.setAlamat(req.getParameter("pasienAlamat"));
    //pasienBaru.setTanggalLahir(java.sql.Date.valueOf(req.getParameter("pasienTanggalLahir")));
    pasienBaru.setTanggalLahir(java.sql.Date.valueOf(req.getParameter("pasienTanggalLahir")));
    
    PasienDao pasienDao = new PasienDao();
    pasienDao.save(pasienBaru);
       
    resp.sendRedirect(req.getServletContext().getContextPath()+"/pasien/list");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/pasien/addPasien.jsp").forward(req, resp);
        
    }
    
    
   
}
