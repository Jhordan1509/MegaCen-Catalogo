package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.catalogo.exception.ResourceNotFoundException;
import pe.com.megacentimetros.catalogo.entity.MarcaProductoEntity;
import pe.com.megacentimetros.catalogo.repository.MarcaProductoRepository;
import pe.com.megacentimetros.catalogo.service.MarcaProductoService;

@Service
public class MarcaProductoServiceImpl implements MarcaProductoService {

	private MarcaProductoRepository repositorio;

	public MarcaProductoServiceImpl(MarcaProductoRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<MarcaProductoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<MarcaProductoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public MarcaProductoEntity findById(Long id) {
		MarcaProductoEntity marcaProducto = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("MarcaProducto con id " + id + " no existe"));
		return marcaProducto;
	}
	@Override
	public MarcaProductoEntity add(MarcaProductoEntity obj) {
		obj.setEstado(true);
		return repositorio.save(obj);
	}
	@Override
	public MarcaProductoEntity update(MarcaProductoEntity obj, Long id) {
		MarcaProductoEntity objmar = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("MarcaProducto con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objmar, "codigo");
		return repositorio.save(objmar);
	}
	@Override
	public MarcaProductoEntity delete(Long id) {
		MarcaProductoEntity objmar = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("MarcaProducto con id " + id + " no existe"));
		objmar.setEstado(false);
		return repositorio.save(objmar);
	}
	@Override
	public MarcaProductoEntity enable(Long id) {
		MarcaProductoEntity objmar = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("MarcaProducto con id " + id + " no existe"));
		objmar.setEstado(true);
		return repositorio.save(objmar);
	}
}
