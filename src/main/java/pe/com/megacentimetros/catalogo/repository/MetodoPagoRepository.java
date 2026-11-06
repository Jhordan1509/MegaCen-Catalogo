package pe.com.megacentimetros.catalogo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.catalogo.entity.MetodoPagoEntity;

public interface MetodoPagoRepository extends JpaRepository<MetodoPagoEntity, Long> {

	@Query("select d from MetodoPagoEntity d where d.estado = true")
	List<MetodoPagoEntity> findAllCustom();
}
