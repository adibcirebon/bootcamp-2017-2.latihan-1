package com.tabeldata.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Rawat {

    private Integer id;
    private Pasien pasienId;
    private Dokter dokterId;
    private Ruang ruangId;
    private Timestamp tanggalRegister;
    private Timestamp tanggalCheckout;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pasien getPasienId() {
        return pasienId;
    }

    public void setPasienId(Pasien pasienId) {
        this.pasienId = pasienId;
    }

    public Dokter getDokterId() {
        return dokterId;
    }

    public void setDokterId(Dokter dokterId) {
        this.dokterId = dokterId;
    }

    public Ruang getRuangId() {
        return ruangId;
    }

    public void setRuangId(Ruang ruangId) {
        this.ruangId = ruangId;
    }

    public Timestamp getTanggalRegister() {
        return tanggalRegister;
    }

    public void setTanggalRegister(Timestamp tanggalRegister) {
        this.tanggalRegister = tanggalRegister;
    }

    public Timestamp getTanggalCheckout() {
        return tanggalCheckout;
    }

    public void setTanggalCheckout(Timestamp tanggalCheckout) {
        this.tanggalCheckout = tanggalCheckout;
    }

}
