package pe.com.megacentimetros.catalogo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.catalogo.exception.ResourceNotFoundException;
import pe.com.megacentimetros.catalogo.entity.CategoriaProductoEntity;
import pe.com.megacentimetros.catalogo.repository.CategoriaProductoRepository;
import pe.com.megacentimetros.catalogo.service.CategoriaProductoService;

@Service
public class CategoriaProductoServiceImpl implements CategoriaProductoService {

	private CategoriaProductoRepository repositorio;

	public CategoriaProductoServiceImpl(CategoriaProductoRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<CategoriaProductoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<CategoriaProductoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public CategoriaProductoEntity findById(Long id) {
		CategoriaProductoEntity categoriaProducto = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("CategoriaProducto con id " + id + " no existe"));
		return categoriaProducto;
	}
	@Override
	public CategoriaProductoEntity add(CategoriaProductoEntity obj) {
		obj.setEstado(true);
		return repositorio.save(obj);
	}
	@Override
	public CategoriaProductoEntity update(CategoriaProductoEntity obj, Long id) {
		CategoriaProductoEntity objcat = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("CategoriaProducto con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objcat, "codigo");
		return repositorio.save(objcat);
	}
	@Override
	public CategoriaProductoEntity delete(Long id) {
		CategoriaProductoEntity objcat = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("CategoriaProducto con id " + id + " no existe"));
		objcat.setEstado(false);
		return repositorio.save(objcat);
	}
	@Override
	public CategoriaProductoEntity enable(Long id) {
		CategoriaProductoEntity objcat = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("CategoriaProducto con id " + id + " no existe"));
		objcat.setEstado(true);
		return repositorio.save(objcat);
	}
}
