package com.tabeldata.dao;

import com.tabeldata.configs.DatabaseKonfigurasi;
import com.tabeldata.model.Dokter;
import com.tabeldata.model.Pasien;
import com.tabeldata.model.Rawat;
import com.tabeldata.model.Ruang;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class RawatDao {

    public List<Rawat> semuaData() throws SQLException {
        List<Rawat> listData = new ArrayList<>();

        String sql = "select\n"
                + " rwt.id as rawat_id,\n"
                + " rwt.pasien_id as pasien_id,\n"
                + " psn.nama as pasien_nama,\n"
                + " rwt.dokter_id,\n"
                + " dkr.nama as dokter_nama,\n"
                + " rwt.ruang_id,\n"
                + " rng.no_ruangan ruang_no,\n"
                + " rng.kosong as ruang_kosong,\n"
                + " rwt.waktu_register as rawat_register,\n"
                + " rwt.waktu_checkout as rawat_checkout\n"
                + " FROM latihan_1.rawat rwt\n"
                + " JOIN latihan_1.pasien psn ON rwt.pasien_id = psn.id\n"
                + " JOIN latihan_1.dokter dkr ON rwt.dokter_id = dkr.id\n"
                + " JOIN latihan_1.ruang rng ON rwt.ruang_id = rng.id\n";

        Connection connection = new DatabaseKonfigurasi().getDatasource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
      
        while (resultSet.next()){
         //tampung nilai dari database ke object java dengan tipe rawat
        Rawat rwt = new Rawat();
        rwt.setId(resultSet.getInt("rawat_id"));
        Dokter dokter = new Dokter();
        dokter.setId(resultSet.getInt("dokter_id"));
        dokter.setNama(resultSet.getString("dokter_nama"));
        rwt.setDokter(dokter);
        
        Pasien pasien = new Pasien();
        pasien.setId(resultSet.getInt("pasien_id"));
        pasien.setNama(resultSet.getString("dokter_nama"));
        rwt.setPasien(pasien);
        
        Ruang ruang = new Ruang();
        ruang.setId(resultSet.getInt("ruang_id"));
        ruang.setNoRuangan("ruang_no");
        rwt.setRuang(ruang);
        
        rwt.setTanggalRegister(resultSet.getDate("rawat_register"));
        rwt.setTanggalCheckout(resultSet.getDate("rawat_checkout"));
            
        }  
        resultSet.close();
        statement.clearBatch();
        connection.close();
        return listData;
    }
}