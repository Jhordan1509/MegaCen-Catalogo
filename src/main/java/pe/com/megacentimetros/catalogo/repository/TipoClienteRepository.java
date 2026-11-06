package pe.com.megacentimetros.catalogo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.catalogo.entity.TipoClienteEntity;

public interface TipoClienteRepository extends JpaRepository<TipoClienteEntity, Long> {

	@Query("select d from TipoClienteEntity d where d.estado = true")
	List<TipoClienteEntity> findAllCustom();
}
