package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.catalogo.exception.ResourceNotFoundException;
import pe.com.megacentimetros.catalogo.entity.TipoEmpaqueEntity;
import pe.com.megacentimetros.catalogo.repository.TipoEmpaqueRepository;
import pe.com.megacentimetros.catalogo.service.TipoEmpaqueService;

@Service
public class TipoEmpaqueServiceImpl implements TipoEmpaqueService {

	private TipoEmpaqueRepository repositorio;

	public TipoEmpaqueServiceImpl(TipoEmpaqueRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<TipoEmpaqueEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<TipoEmpaqueEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public TipoEmpaqueEntity findById(Long id) {
		TipoEmpaqueEntity tipoEmpaque = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("TipoEmpaque con id " + id + " no existe"));
		return tipoEmpaque;
	}
	@Override
	public TipoEmpaqueEntity add(TipoEmpaqueEntity obj) {
		obj.setEstado(true);
		return repositorio.save(obj);
	}
	@Override
	public TipoEmpaqueEntity update(TipoEmpaqueEntity obj, Long id) {
		TipoEmpaqueEntity objtip = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("TipoEmpaque con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objtip, "codigo");
		return repositorio.save(objtip);
	}
	@Override
	public TipoEmpaqueEntity delete(Long id) {
		TipoEmpaqueEntity objtip = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("TipoEmpaque con id " + id + " no existe"));
		objtip.setEstado(false);
		return repositorio.save(objtip);
	}
	@Override
	public TipoEmpaqueEntity enable(Long id) {
		TipoEmpaqueEntity objtip = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("TipoEmpaque con id " + id + " no existe"));
		objtip.setEstado(true);
		return repositorio.save(objtip);
	}
}
