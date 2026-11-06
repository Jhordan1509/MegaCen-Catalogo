package pe.com.megacentimetros.catalogo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.catalogo.entity.DistritoEntity;

public interface DistritoRepository extends JpaRepository<DistritoEntity, Long> {

	@Query("select d from DistritoEntity d where d.estado = true")
	List<DistritoEntity> findAllCustom();
}
