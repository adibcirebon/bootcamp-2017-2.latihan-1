package com.tabeldata.model;

import java.lang.Object;
import java.util.Date;
import java.sql.Timestamp;

public class Rawat {

    private Integer id;
    private Pasien pasien;
    private Dokter dokter;
    private Ruang ruang;
    private Timestamp waktu_register;
    private Timestamp waktu_checkout;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }

    public Ruang getRuang() {
        return ruang;
    }

    public void setRuang(Ruang ruang) {
        this.ruang = ruang;
    }
    
    public Date getWaktuRegister() {
        return waktu_register;
    }

    public void setWaktuRegister(Timestamp waktu_register) {
        this.waktu_register = waktu_register;
    }
    
    public Date getWaktuCheckout() {
        return waktu_checkout;
    }

    public void setWaktuCheckout(Timestamp waktu_checkout) {
        this.waktu_checkout = waktu_checkout;
    }

}
