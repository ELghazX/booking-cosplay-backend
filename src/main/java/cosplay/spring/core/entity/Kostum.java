package cosplay.spring.core.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "kostum")
@Getter
@Setter
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
}
