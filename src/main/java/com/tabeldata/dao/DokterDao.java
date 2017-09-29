
package com.tabeldata.dao;



import com.tabeldata.configs.KonfigDB;
import com.tabeldata.model.Dokter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DokterDao {

    public List<Dokter> semuaDataDokter() {
        List<Dokter> listDokter = new ArrayList<>();
        try {
            Connection koneksiDB = KonfigDB.getDatasource().getConnection();
            String sql = "select id, nama, spesialis from latihan_1.dokter";
            Statement s = koneksiDB.createStatement();
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                Dokter dokter = new Dokter();
                dokter.setId(r.getInt("id"));
                dokter.setNama(r.getString("nama"));
                dokter.setSpesialis(r.getString("spesialis"));
                listDokter.add(dokter);

            }
            r.close();
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(DokterDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDokter;
    }

    public void save(Dokter objDokter) {
        try {
            Connection koneksiDB = KonfigDB.getDatasource().getConnection();
            String sql = "insert into latihan_1.dokter(nama, spesialis) values (?,?)";
            PreparedStatement ps = koneksiDB.prepareStatement(sql);
            ps.setString(1, objDokter.getNama());
           
            ps.executeUpdate();

            ps.close();
            koneksiDB.close();
        } catch (SQLException ex) {
            Logger.getLogger(DokterDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public Dokter cariDokterDenganId(Integer id) {
        try {
            Connection koneksi = KonfigDB.getDatasource().getConnection();
        String sql = "select id, nama, spesialis from latihan_1.dokter where id=?";
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Dokter dokter = new Dokter();
            if(rs.next()){
                dokter.setId(rs.getInt("id"));
                dokter.setNama(rs.getString("nama"));
                dokter.setSpesialis(rs.getString("spesialis"));
        
            
            }
            return dokter;
        
        } catch (SQLException ex) {
            Logger.getLogger(DokterDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public void update(Dokter objDokter) {
        try {
            Connection koneksiDB = KonfigDB.getDatasource().getConnection();
            String sql = "update latihan_1.dokter set nama = ? where id=?";
            PreparedStatement ps = koneksiDB.prepareStatement(sql);
            ps.setString(1, objDokter.getNama());
            ps.setInt(2, objDokter.getId());
            ps.setString(3, objDokter.getSpesialis());
            ps.executeUpdate();

            ps.close();
            koneksiDB.close();
        } catch (SQLException ex) {
            Logger.getLogger(DokterDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
 public void hapusDataById(Integer id){
   String sql ="delete from latihan_1.dokter where id =?";  
 
        try {
            Connection conection = KonfigDB.getDatasource().getConnection();
        PreparedStatement ps = conection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        conection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DokterDao.class.getName()).log(Level.SEVERE, null, ex);
        }
 } 
}
