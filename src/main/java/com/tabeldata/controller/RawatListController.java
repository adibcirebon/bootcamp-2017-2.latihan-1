
package com.tabeldata.controller;

import com.tabeldata.dao.RawatDao;
import com.tabeldata.model.Rawat;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADIB PC
 */

@WebServlet (urlPatterns = {"/rawat/list", "/rawat/"})
public class RawatListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        RawatDao dao = new RawatDao();
        //List<Rawat> listData = dao.semuaData();
        List<Rawat> listData = dao.semuaDataRawat();
        req.setAttribute("listRawat", listData);
        req.getRequestDispatcher("/pages/rawat/index.jsp").forward(req, resp);
            
    }
 
    
    
}
