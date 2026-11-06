package pe.com.megacentimetros.catalogo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "TipoEmpaqueEntity")
@Table(name = "tipoempaque")
public class TipoEmpaqueEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codtipemp")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomemp", length = 80, nullable = false, unique = true)
    private String nombre;

    @Column(name = "descrip", length = 250)
    private String descripcion;

    @Column(name = "esttipemp", nullable = false)
    private Boolean estado;
}
