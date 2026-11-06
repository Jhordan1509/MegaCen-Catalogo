package pe.com.megacentimetros.catalogo.service;

import java.util.List;
import pe.com.megacentimetros.catalogo.entity.TipoClienteEntity;

public interface TipoClienteService {

	List<TipoClienteEntity> findAll();

	List<TipoClienteEntity> findAllCustom();

	TipoClienteEntity findById(Long id);

	TipoClienteEntity add(TipoClienteEntity obj);

	TipoClienteEntity update(TipoClienteEntity obj, Long id);

	TipoClienteEntity delete(Long id);

	TipoClienteEntity enable(Long id);
}
