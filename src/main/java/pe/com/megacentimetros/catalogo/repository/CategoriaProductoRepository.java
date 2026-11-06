package pe.com.megacentimetros.catalogo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.catalogo.entity.CategoriaProductoEntity;

public interface CategoriaProductoRepository extends JpaRepository<CategoriaProductoEntity, Long> {

	@Query("select d from CategoriaProductoEntity d where d.estado = true")
	List<CategoriaProductoEntity> findAllCustom();
}
