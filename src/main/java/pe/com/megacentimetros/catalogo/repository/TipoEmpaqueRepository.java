package pe.com.megacentimetros.catalogo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.catalogo.entity.TipoEmpaqueEntity;

public interface TipoEmpaqueRepository extends JpaRepository<TipoEmpaqueEntity, Long> {

	@Query("select d from TipoEmpaqueEntity d where d.estado = true")
	List<TipoEmpaqueEntity> findAllCustom();
}
