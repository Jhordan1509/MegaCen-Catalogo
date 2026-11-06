package pe.com.megacentimetros.catalogo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.catalogo.entity.MarcaProductoEntity;

public interface MarcaProductoRepository extends JpaRepository<MarcaProductoEntity, Long> {

	@Query("select d from MarcaProductoEntity d where d.estado = true")
	List<MarcaProductoEntity> findAllCustom();
}
