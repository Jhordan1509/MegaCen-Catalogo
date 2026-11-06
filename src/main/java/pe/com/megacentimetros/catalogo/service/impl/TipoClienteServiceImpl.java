package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.catalogo.exception.ResourceNotFoundException;
import pe.com.megacentimetros.catalogo.entity.TipoClienteEntity;
import pe.com.megacentimetros.catalogo.repository.TipoClienteRepository;
import pe.com.megacentimetros.catalogo.service.TipoClienteService;

@Service
public class TipoClienteServiceImpl implements TipoClienteService {

	private TipoClienteRepository repositorio;

	public TipoClienteServiceImpl(TipoClienteRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<TipoClienteEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<TipoClienteEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public TipoClienteEntity findById(Long id) {
		TipoClienteEntity tipoCliente = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("TipoCliente con id " + id + " no existe"));
		return tipoCliente;
	}
	@Override
	public TipoClienteEntity add(TipoClienteEntity obj) {
		obj.setEstado(true);
		return repositorio.save(obj);
	}
	@Override
	public TipoClienteEntity update(TipoClienteEntity obj, Long id) {
		TipoClienteEntity objtip = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("TipoCliente con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objtip, "codigo");
		return repositorio.save(objtip);
	}
	@Override
	public TipoClienteEntity delete(Long id) {
		TipoClienteEntity objtip = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("TipoCliente con id " + id + " no existe"));
		objtip.setEstado(false);
		return repositorio.save(objtip);
	}
	@Override
	public TipoClienteEntity enable(Long id) {
		TipoClienteEntity objtip = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("TipoCliente con id " + id + " no existe"));
		objtip.setEstado(true);
		return repositorio.save(objtip);
	}
}
