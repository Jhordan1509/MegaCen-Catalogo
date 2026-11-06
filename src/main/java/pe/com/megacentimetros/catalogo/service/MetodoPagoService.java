package pe.com.megacentimetros.catalogo.service;

import java.util.List;
import pe.com.megacentimetros.catalogo.entity.MetodoPagoEntity;

public interface MetodoPagoService {

	List<MetodoPagoEntity> findAll();

	List<MetodoPagoEntity> findAllCustom();

	MetodoPagoEntity findById(Long id);

	MetodoPagoEntity add(MetodoPagoEntity obj);

	MetodoPagoEntity update(MetodoPagoEntity obj, Long id);

	MetodoPagoEntity delete(Long id);

	MetodoPagoEntity enable(Long id);
}
