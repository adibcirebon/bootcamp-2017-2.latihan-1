package com.tabeldata.model;

import java.util.Date;

public class Pasien {

    private Integer id;
    private String nama;
    private String alamat;
    private Date tanggal_lahir;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public Date getTanggalLahir() {
        return this.tanggal_lahir;
    }

    public void setTanggalLahir(Date x) {
        this.tanggal_lahir = x;
    }

}
