package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.catalogo.exception.ResourceNotFoundException;
import pe.com.megacentimetros.catalogo.entity.SexoEntity;
import pe.com.megacentimetros.catalogo.repository.SexoRepository;
import pe.com.megacentimetros.catalogo.service.SexoService;

@Service
public class SexoServiceImpl implements SexoService {

	private SexoRepository repositorio;

	public SexoServiceImpl(SexoRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<SexoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<SexoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public SexoEntity findById(Long id) {
		SexoEntity sexo = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sexo con id " + id + " no existe"));
		return sexo;
	}
	@Override
	public SexoEntity add(SexoEntity obj) {
		obj.setEstado(true);
		return repositorio.save(obj);
	}
	@Override
	public SexoEntity update(SexoEntity obj, Long id) {
		SexoEntity objsex = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sexo con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objsex, "codigo");
		return repositorio.save(objsex);
	}
	@Override
	public SexoEntity delete(Long id) {
		SexoEntity objsex = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sexo con id " + id + " no existe"));
		objsex.setEstado(false);
		return repositorio.save(objsex);
	}
	@Override
	public SexoEntity enable(Long id) {
		SexoEntity objsex = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sexo con id " + id + " no existe"));
		objsex.setEstado(true);
		return repositorio.save(objsex);
	}
}
