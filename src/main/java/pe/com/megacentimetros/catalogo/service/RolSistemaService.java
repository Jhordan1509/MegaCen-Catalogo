package pe.com.megacentimetros.catalogo.service;

import java.util.List;
import pe.com.megacentimetros.catalogo.entity.RolSistemaEntity;

public interface RolSistemaService {

	List<RolSistemaEntity> findAll();

	List<RolSistemaEntity> findAllCustom();

	RolSistemaEntity findById(Long id);

	RolSistemaEntity add(RolSistemaEntity obj);

	RolSistemaEntity update(RolSistemaEntity obj, Long id);

	RolSistemaEntity delete(Long id);

	RolSistemaEntity enable(Long id);
}
