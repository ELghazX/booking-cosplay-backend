package cosplay.spring.core.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "kostum")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Kostum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama;

    private String ukuran;

    private String deskripsi;

    private String foto;

    private Double hargaSewaHarian;

    private Double hargaSewaMingguan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Double getHargaSewaHarian() {
        return hargaSewaHarian;
    }

    public void setHargaSewaHarian(Double hargaSewaHarian) {
        this.hargaSewaHarian = hargaSewaHarian;
    }

    public Double getHargaSewaMingguan() {
        return hargaSewaMingguan;
    }

    public void setHargaSewaMingguan(Double hargaSewaMingguan) {
        this.hargaSewaMingguan = hargaSewaMingguan;
    }

}
