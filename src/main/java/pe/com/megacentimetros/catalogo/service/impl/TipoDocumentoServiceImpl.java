package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.catalogo.exception.ResourceNotFoundException;
import pe.com.megacentimetros.catalogo.entity.TipoDocumentoEntity;
import pe.com.megacentimetros.catalogo.repository.TipoDocumentoRepository;
import pe.com.megacentimetros.catalogo.service.TipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

	private TipoDocumentoRepository repositorio;

	public TipoDocumentoServiceImpl(TipoDocumentoRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<TipoDocumentoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<TipoDocumentoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public TipoDocumentoEntity findById(Long id) {
		TipoDocumentoEntity tipoDocumento = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("TipoDocumento con id " + id + " no existe"));
		return tipoDocumento;
	}
	@Override
	public TipoDocumentoEntity add(TipoDocumentoEntity obj) {
		obj.setEstado(true);
		return repositorio.save(obj);
	}
	@Override
	public TipoDocumentoEntity update(TipoDocumentoEntity obj, Long id) {
		TipoDocumentoEntity objtip = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("TipoDocumento con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objtip, "codigo");
		return repositorio.save(objtip);
	}
	@Override
	public TipoDocumentoEntity delete(Long id) {
		TipoDocumentoEntity objtip = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("TipoDocumento con id " + id + " no existe"));
		objtip.setEstado(false);
		return repositorio.save(objtip);
	}
	@Override
	public TipoDocumentoEntity enable(Long id) {
		TipoDocumentoEntity objtip = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("TipoDocumento con id " + id + " no existe"));
		objtip.setEstado(true);
		return repositorio.save(objtip);
	}
}
