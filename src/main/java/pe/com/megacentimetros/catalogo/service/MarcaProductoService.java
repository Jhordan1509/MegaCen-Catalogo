package pe.com.megacentimetros.catalogo.service;

import java.util.List;
import pe.com.megacentimetros.catalogo.entity.MarcaProductoEntity;

public interface MarcaProductoService {

	List<MarcaProductoEntity> findAll();

	List<MarcaProductoEntity> findAllCustom();

	MarcaProductoEntity findById(Long id);

	MarcaProductoEntity add(MarcaProductoEntity obj);

	MarcaProductoEntity update(MarcaProductoEntity obj, Long id);

	MarcaProductoEntity delete(Long id);

	MarcaProductoEntity enable(Long id);
}
