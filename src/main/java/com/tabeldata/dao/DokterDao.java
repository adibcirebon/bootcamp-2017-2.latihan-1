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

/**
 *
 * @author Diani
 */
public class DokterDao {

    public List<Dokter> semuaDataDokter() {
        List<Dokter> listDokter = new ArrayList<>();
        try {
            //Connection koneksiDB = KonfigDB.getDataSource().getConnection();
            Connection koneksiDB = KonfigDB.getDatasource().getConnection();
            String sql = "select id, nama, spesialis from latihan_1.dokter order by id";
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
            koneksiDB.close();
        } catch (SQLException ex) {
            Logger.getLogger(DokterDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDokter;

    }

    public void save(Dokter objDokter) {
        try {
            Connection koneksiDB = KonfigDB.getDatasource().getConnection();
            String sql = "insert into latihan_1.dokter(id, nama, spesialis) values (nextval('latihan_1.dokter_id_seq'), ?, ?)";
            PreparedStatement ps = koneksiDB.prepareStatement(sql);
            ps.setString(1, objDokter.getNama());
            ps.setString(2, objDokter.getSpesialis());
            ps.executeUpdate();

            ps.close();
            koneksiDB.close();
        } catch (SQLException ex) {
            Logger.getLogger(DokterDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Dokter cariDokterDenganId(Integer id) {

        try {
            Connection koneksiDB = KonfigDB.getDatasource().getConnection();
            String sql = "select * from latihan_1.dokter where id = ?";
            //PreparedStatement ps = koneksi.prepareStatement(sql);
            PreparedStatement ps = koneksiDB.prepareStatement (sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Dokter dokter = new Dokter();
            if (rs.next()) {
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
            String sql = "update latihan_1.dokter set nama = ?, spesialis = ? where id = ?";
            PreparedStatement ps = koneksiDB.prepareStatement(sql);
            ps.setString(1, objDokter.getNama());
            ps.setString(2, objDokter.getSpesialis());
            ps.setInt(3, objDokter.getId());
            
            ps.executeUpdate();

            ps.close();
            koneksiDB.close();
        } catch (SQLException ex) {
            Logger.getLogger(DokterDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void hapusDokterById(Integer id) {
        String sql = "delete from latihan_1.dokter where id = ?";

        try {
            Connection koneksiDB = KonfigDB.getDatasource().getConnection();
            PreparedStatement ps = koneksiDB.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            ps.close();
            koneksiDB.close();

        } catch (SQLException ex) {
            Logger.getLogger(DokterDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
