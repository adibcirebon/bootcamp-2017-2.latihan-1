
package com.tabeldata.dao;

import java.util.Date;
import com.tabeldata.configs.KonfigDB;
import com.tabeldata.model.Pasien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasienDao {

    public List<Pasien> semuaDataPasien() {
        List<Pasien> listPasien = new ArrayList<>();
        try {
            Connection koneksiDB = KonfigDB.getDatasource().getConnection();
            String sql = "select id, nama, alamat, tanggal_lahir from latihan_1.pasien";
            Statement s = koneksiDB.createStatement();
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                Pasien pasien = new Pasien();
                pasien.setId(r.getInt("id"));
                pasien.setNama(r.getString("nama"));
                pasien.setTanggalLahir(r.getDate("tanggal_lahir"));
                listPasien.add(pasien);

            }
            r.close();
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(PasienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPasien;
    }

    public void save(Pasien objPasien) {
        try {
            Connection koneksiDB = KonfigDB.getDatasource().getConnection();
            String sql = "insert into latihan_1.pasien(nama, alamat, tanggal_lahir) values (?,?,?)";
            PreparedStatement ps = koneksiDB.prepareStatement(sql);
            ps.setString(1, objPasien.getNama());
           
            ps.executeUpdate();

            ps.close();
            koneksiDB.close();
        } catch (SQLException ex) {
            Logger.getLogger(PasienDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public Pasien cariPasienDenganId(Integer id) {
        try {
            Connection koneksi = KonfigDB.getDatasource().getConnection();
        String sql = "select id, nama, alamat, tanggal_lahir from latihan_1.pasien where id=?";
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Pasien pasien = new Pasien();
            if(rs.next()){
                pasien.setId(rs.getInt("id"));
                pasien.setNama(rs.getString("nama"));
                pasien.setAlamat(rs.getString("alamat"));
                pasien.setTanggalLahir(rs.getDate("tanggal_lahir"));
            
            }
            return pasien;
        
        } catch (SQLException ex) {
            Logger.getLogger(PasienDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public void update(Pasien objPasien) {
        try {
            Connection koneksiDB = KonfigDB.getDatasource().getConnection();
            String sql = "update latihan_1.pasien set nama = ? where id=?";
            PreparedStatement ps = koneksiDB.prepareStatement(sql);
            ps.setString(1, objPasien.getNama());
            ps.setInt(2, objPasien.getId());
            ps.executeUpdate();

            ps.close();
            koneksiDB.close();
        } catch (SQLException ex) {
            Logger.getLogger(PasienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
 public void hapusDataById(Integer id){
   String sql ="delete from latihan_1.pasien where id =?";  
 
        try {
            Connection conection = KonfigDB.getDatasource().getConnection();
        PreparedStatement ps = conection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        conection.close();
        } catch (SQLException ex) {
            Logger.getLogger(PasienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
}
