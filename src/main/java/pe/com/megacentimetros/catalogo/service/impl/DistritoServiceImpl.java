package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.catalogo.exception.ResourceNotFoundException;
import pe.com.megacentimetros.catalogo.entity.DistritoEntity;
import pe.com.megacentimetros.catalogo.repository.DistritoRepository;
import pe.com.megacentimetros.catalogo.service.DistritoService;

@Service
public class DistritoServiceImpl implements DistritoService {

	private DistritoRepository repositorio;

	public DistritoServiceImpl(DistritoRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<DistritoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<DistritoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public DistritoEntity findById(Long id) {
		DistritoEntity distrito = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Distrito con id " + id + " no existe"));
		return distrito;
	}
	@Override
	public DistritoEntity add(DistritoEntity obj) {
		obj.setEstado(true);
		return repositorio.save(obj);
	}
	@Override
	public DistritoEntity update(DistritoEntity obj, Long id) {
		DistritoEntity objdis = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Distrito con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objdis, "codigo");
		return repositorio.save(objdis);
	}
	@Override
	public DistritoEntity delete(Long id) {
		DistritoEntity objdis = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Distrito con id " + id + " no existe"));
		objdis.setEstado(false);
		return repositorio.save(objdis);
	}
	@Override
	public DistritoEntity enable(Long id) {
		DistritoEntity objdis = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Distrito con id " + id + " no existe"));
		objdis.setEstado(true);
		return repositorio.save(objdis);
	}
}
