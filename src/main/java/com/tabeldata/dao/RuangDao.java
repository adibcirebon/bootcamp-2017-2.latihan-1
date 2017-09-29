
package com.tabeldata.dao;




import com.tabeldata.configs.KonfigDB;
import com.tabeldata.model.Ruang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RuangDao {

    public List<Ruang> semuaDataRuang() {
        List<Ruang> listRuang = new ArrayList<>();
        try {
            Connection koneksiDB = KonfigDB.getDatasource().getConnection();
            String sql = "select id, no_ruang, kosong from latihan_1.ruang";
            Statement s = koneksiDB.createStatement();
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                Ruang ruang = new Ruang();
                ruang.setId(r.getInt("id"));
                ruang.setNoRuangan(r.getString("no_ruangan"));
                ruang.setKosong(r.getBoolean("kosong"));
                listRuang.add(ruang);

            }
            r.close();
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(RuangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRuang;
    }

    public void save(Ruang objRuang) {
        try {
            Connection koneksiDB = KonfigDB.getDatasource().getConnection();
            String sql = "insert into latihan_1.ruang(no_ruangan, kosong) values (?,?)";
            PreparedStatement ps = koneksiDB.prepareStatement(sql);
            ps.setString(1, objRuang.getNoRuangan());
           
            ps.executeUpdate();

            ps.close();
            koneksiDB.close();
        } catch (SQLException ex) {
            Logger.getLogger(RuangDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public Ruang cariRuangDenganId(Integer id) {
        try {
            Connection koneksi = KonfigDB.getDatasource().getConnection();
        String sql = "select id, no_ruangan, kosong from latihan_1.ruang where id=?";
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Ruang ruang = new Ruang();
            if(rs.next()){
                ruang.setId(rs.getInt("id"));
                ruang.setNoRuangan(rs.getString("no_ruangan"));
                ruang.setKosong(rs.getBoolean("kosong"));
        
            
            }
            return ruang;
        
        } catch (SQLException ex) {
            Logger.getLogger(RuangDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public void update(Ruang objRuang) {
        try {
            Connection koneksiDB = KonfigDB.getDatasource().getConnection();
            String sql = "update latihan_1.ruang set no_ruangan = ? where id=?";
            PreparedStatement ps = koneksiDB.prepareStatement(sql);
            ps.setString(1, objRuang.getNoRuangan());
            ps.setInt(2, objRuang.getId());
            ps.setBoolean(3, objRuang.getKosong());
            ps.executeUpdate();

            ps.close();
            koneksiDB.close();
        } catch (SQLException ex) {
            Logger.getLogger(RuangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
 public void hapusDataById(Integer id){
   String sql ="delete from latihan_1.ruang where id =?";  
 
        try {
            Connection conection = KonfigDB.getDatasource().getConnection();
        PreparedStatement ps = conection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        conection.close();
        } catch (SQLException ex) {
            Logger.getLogger(RuangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
 } 
}