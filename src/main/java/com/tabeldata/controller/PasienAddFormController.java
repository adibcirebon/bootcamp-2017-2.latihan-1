
package com.tabeldata.controller;



import com.tabeldata.dao.PasienDao;
import com.tabeldata.model.Pasien;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
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
    
    pasienBaru.setNama(req.getParameter("pasienName"));
    pasienBaru.setAlamat(req.getParameter("pasienAlamat"));
    pasienBaru.setTanggalLahir(Date.valueOf("tanggal_lahir"));
    
    PasienDao pasienDao = new PasienDao();
    pasienDao.save(pasienBaru);
       
    resp.sendRedirect(req.getServletContext().getContextPath()+"/pasien/list");
    }
   
}
