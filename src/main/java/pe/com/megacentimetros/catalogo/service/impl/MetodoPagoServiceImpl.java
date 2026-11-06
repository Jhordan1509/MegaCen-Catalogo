package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.catalogo.exception.ResourceNotFoundException;
import pe.com.megacentimetros.catalogo.entity.MetodoPagoEntity;
import pe.com.megacentimetros.catalogo.repository.MetodoPagoRepository;
import pe.com.megacentimetros.catalogo.service.MetodoPagoService;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {

	private MetodoPagoRepository repositorio;

	public MetodoPagoServiceImpl(MetodoPagoRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<MetodoPagoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<MetodoPagoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public MetodoPagoEntity findById(Long id) {
		MetodoPagoEntity metodoPago = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("MetodoPago con id " + id + " no existe"));
		return metodoPago;
	}
	@Override
	public MetodoPagoEntity add(MetodoPagoEntity obj) {
		obj.setEstado(true);
		return repositorio.save(obj);
	}
	@Override
	public MetodoPagoEntity update(MetodoPagoEntity obj, Long id) {
		MetodoPagoEntity objmet = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("MetodoPago con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objmet, "codigo");
		return repositorio.save(objmet);
	}
	@Override
	public MetodoPagoEntity delete(Long id) {
		MetodoPagoEntity objmet = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("MetodoPago con id " + id + " no existe"));
		objmet.setEstado(false);
		return repositorio.save(objmet);
	}
	@Override
	public MetodoPagoEntity enable(Long id) {
		MetodoPagoEntity objmet = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("MetodoPago con id " + id + " no existe"));
		objmet.setEstado(true);
		return repositorio.save(objmet);
	}
}
