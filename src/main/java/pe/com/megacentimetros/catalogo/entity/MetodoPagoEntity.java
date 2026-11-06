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
@Entity(name = "MetodoPagoEntity")
@Table(name = "metodopago")
public class MetodoPagoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codmetpag")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nommetpag", length = 60, nullable = false, unique = true)
    private String nombre;

    @Column(name = "descrip", length = 200)
    private String descripcion;

    @Column(name = "estmetpag", nullable = false)
    private Boolean estado;
}
