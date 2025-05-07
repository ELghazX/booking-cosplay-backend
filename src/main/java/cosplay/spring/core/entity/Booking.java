package cosplay.spring.core.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "booking")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Booking {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private Kostum kostum;
    private String namaPenyewa;
    private String kontak;
    private LocalDate tanggalMulai;
    private String durasiSewa;
    private String status;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Kostum getKostum() {
        return kostum;
    }
    public void setKostum(Kostum kostum) {
        this.kostum = kostum;
    }
    public String getNamaPenyewa() {
        return namaPenyewa;
    }
    public void setNamaPenyewa(String namaPenyewa) {
        this.namaPenyewa = namaPenyewa;
    }
    public String getKontak() {
        return kontak;
    }
    public void setKontak(String kontak) {
        this.kontak = kontak;
    }
    public LocalDate getTanggalMulai() {
        return tanggalMulai;
    }
    public void setTanggalMulai(LocalDate tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }
    public String getDurasiSewa() {
        return durasiSewa;
    }
    public void setDurasiSewa(String durasiSewa) {
        this.durasiSewa = durasiSewa;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
}