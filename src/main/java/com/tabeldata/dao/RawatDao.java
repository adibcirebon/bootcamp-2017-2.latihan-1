package com.tabeldata.dao;


import com.tabeldata.configs.KonfigDB;
import com.tabeldata.model.Dokter;
import com.tabeldata.model.Pasien;
import com.tabeldata.model.Rawat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RawatDao {

    public List<Rawat> semuaDataRawat() throws SQLException {
        List<Rawat> listRawat = new ArrayList<>();

        String sql = "select rwt.id as id_rawat,\n"
                + "rwt.waktu_register as waktu_register,\n"
                + "rwt.waktu_checkout as waktu_checkout,\n"
                + "pasien.id as id_pasien,\n"
                + "pasien.nama as nama_pasien,\n"
                + "pasien.alamat as alamat_pasien,\n"
                + "pasien.tanggal_lahir as tanggal_lahir_pasien,\n"
                + "dokter.id as id_dokter,\n"
                + "dokter.nama as nama_dokter,\n"
                + "dokter.spesialisasi as spesialisasi_dokter,\n"
                + "ruang.id as id_ruang,\n"
                + "ruang.no_ruangan as no_ruangan,\n"
                + "ruang.kosong as ruang_kosong\n"
                + "from latihan-1.rawat rwt join latihan-1.pasien on (rwt.pasien = pasien.id) "
                + "join .dokter dokter on (dokter.id = rwt.dokter)";
        try {
            Connection connection = KonfigDB.getDatasource().getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Rawat rwt = new Rawat();
                rwt.setId(rs.getInt("id_rawat"));
                //rwt.setWaktuRegister(rs.getDate(java.sql.Date()));
                //rwt.setWaktuCheckout(rs.getDate("tanggal_checkout"));

                Pasien pasien = new Pasien();
                pasien.setId(rs.getInt("id_pasien"));
                pasien.setNama(rs.getString("nama_pasien"));
                pasien.setAlamat(rs.getString("alamat_pasien"));
                rwt.setPasien(pasien);

                Dokter dokter = new Dokter();
                dokter.setId(rs.getInt("id_dokter"));
                dokter.setNama(rs.getString("nama_dokter"));
                dokter.setSpesialis(rs.getString("spesialis"));
                rwt.setDokter(dokter);

                listRawat.add(rwt);

            }

            rs.close();
            st.close();
            connection.close();
            
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return listRawat;
    }

    public void simpanRawat(Rawat rwt){
    String sql = "insert into latihan-1.rawat (pasien, dokter, ruang) values (?,?,?)";
    
    Connection connection;
        try {
            connection = KonfigDB.getDatasource().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        //ps.setInt(1,Integer.valueOf(rwt.getId()));
        //ps.setInt(3, rwt.getKela().getId());
        //ps.setInt(4, mhs.getJurusan().getId());
        ps.executeUpdate();
        
        ps.close();
        connection.close();
        } catch (SQLException error) {
            error.printStackTrace();
        }
        
    
}


}
