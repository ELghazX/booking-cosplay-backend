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
    private Long kostumId;
    private Kostum kostum;
    private String namaPenyewa;
    private String kontak;
    private LocalDate tanggalMulai;
    private LocalDate tanggalSelesai;
    private String tipeSewa;
    private String status;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getKostumId() {
        return kostumId;
    }
    public void setKostumId(Long kostumId) {
        this.kostumId = kostumId;
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
    public LocalDate getTanggalSelesai() {
        return tanggalSelesai;
    }
    public void setTanggalSelesai(LocalDate tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }
    public String getTipeSewa() {
        return tipeSewa;
    }
    public void setTipeSewa(String tipeSewa) {
        this.tipeSewa = tipeSewa;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
}