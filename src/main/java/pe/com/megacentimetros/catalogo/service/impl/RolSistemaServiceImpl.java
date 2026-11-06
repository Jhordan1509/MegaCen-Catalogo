package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.catalogo.exception.ResourceNotFoundException;
import pe.com.megacentimetros.catalogo.entity.RolSistemaEntity;
import pe.com.megacentimetros.catalogo.repository.RolSistemaRepository;
import pe.com.megacentimetros.catalogo.service.RolSistemaService;

@Service
public class RolSistemaServiceImpl implements RolSistemaService {

	private RolSistemaRepository repositorio;

	public RolSistemaServiceImpl(RolSistemaRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<RolSistemaEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<RolSistemaEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public RolSistemaEntity findById(Long id) {
		RolSistemaEntity rolSistema = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("RolSistema con id " + id + " no existe"));
		return rolSistema;
	}
	@Override
	public RolSistemaEntity add(RolSistemaEntity obj) {
		obj.setEstado(true);
		return repositorio.save(obj);
	}
	@Override
	public RolSistemaEntity update(RolSistemaEntity obj, Long id) {
		RolSistemaEntity objrol = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("RolSistema con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objrol, "codigo");
		return repositorio.save(objrol);
	}
	@Override
	public RolSistemaEntity delete(Long id) {
		RolSistemaEntity objrol = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("RolSistema con id " + id + " no existe"));
		objrol.setEstado(false);
		return repositorio.save(objrol);
	}
	@Override
	public RolSistemaEntity enable(Long id) {
		RolSistemaEntity objrol = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("RolSistema con id " + id + " no existe"));
		objrol.setEstado(true);
		return repositorio.save(objrol);
	}
}
