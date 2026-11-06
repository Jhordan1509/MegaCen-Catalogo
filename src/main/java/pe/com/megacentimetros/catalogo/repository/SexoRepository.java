package pe.com.megacentimetros.catalogo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.catalogo.entity.SexoEntity;

public interface SexoRepository extends JpaRepository<SexoEntity, Long> {

	@Query("select d from SexoEntity d where d.estado = true")
	List<SexoEntity> findAllCustom();
}
