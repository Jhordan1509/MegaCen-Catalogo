package pe.com.megacentimetros.catalogo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.catalogo.entity.RolSistemaEntity;

public interface RolSistemaRepository extends JpaRepository<RolSistemaEntity, Long> {

	@Query("select d from RolSistemaEntity d where d.estado = true")
	List<RolSistemaEntity> findAllCustom();
}
