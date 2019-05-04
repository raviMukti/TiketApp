/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author raviMukti at Aftwork
 */
public class TiketViewModel {
    String noKtp, nama_penumpang, st_asal, st_tujuan, kelas_kereta, nama_kereta;
    LocalDate jadwal_berangkat;

    public TiketViewModel(String noKtp, String nama_penumpang, LocalDate jadwal_berangkat, String st_asal, String st_tujuan, String kelas_kereta, String nama_kereta) {
        this.noKtp = noKtp;
        this.nama_penumpang = nama_penumpang;
        this.st_asal = st_asal;
        this.st_tujuan = st_tujuan;
        this.kelas_kereta = kelas_kereta;
        this.nama_kereta = nama_kereta;
        this.jadwal_berangkat = jadwal_berangkat;
    }

    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
        this.noKtp = noKtp;
    }

    public String getNama_penumpang() {
        return nama_penumpang;
    }

    public void setNama_penumpang(String nama_penumpang) {
        this.nama_penumpang = nama_penumpang;
    }

    public String getSt_asal() {
        return st_asal;
    }

    public void setSt_asal(String st_asal) {
        this.st_asal = st_asal;
    }

    public String getSt_tujuan() {
        return st_tujuan;
    }

    public void setSt_tujuan(String st_tujuan) {
        this.st_tujuan = st_tujuan;
    }

    public String getKelas_kereta() {
        return kelas_kereta;
    }

    public void setKelas_kereta(String kelas_kereta) {
        this.kelas_kereta = kelas_kereta;
    }

    public String getNama_kereta() {
        return nama_kereta;
    }

    public void setNama_kereta(String nama_kereta) {
        this.nama_kereta = nama_kereta;
    }

    public LocalDate getJadwal_berangkat() {
        return jadwal_berangkat;
    }

    public void setJadwal_berangkat(LocalDate jadwal_berangkat) {
        this.jadwal_berangkat = jadwal_berangkat;
    }
    
}
