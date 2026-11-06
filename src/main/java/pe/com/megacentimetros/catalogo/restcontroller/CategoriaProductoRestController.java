package pe.com.megacentimetros.catalogo.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.megacentimetros.catalogo.entity.CategoriaProductoEntity;
import pe.com.megacentimetros.catalogo.service.CategoriaProductoService;

@RestController
@RequestMapping("/api/categoriaproducto")
public class CategoriaProductoRestController {

	@Autowired
	private CategoriaProductoService servicio;

	@GetMapping
	public List<CategoriaProductoEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<CategoriaProductoEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public CategoriaProductoEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public CategoriaProductoEntity add(@RequestBody CategoriaProductoEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public CategoriaProductoEntity update(@RequestBody CategoriaProductoEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public CategoriaProductoEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public CategoriaProductoEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
