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
import pe.com.megacentimetros.catalogo.entity.MarcaProductoEntity;
import pe.com.megacentimetros.catalogo.service.MarcaProductoService;

@RestController
@RequestMapping("/api/marcaproducto")
public class MarcaProductoRestController {

	@Autowired
	private MarcaProductoService servicio;

	@GetMapping
	public List<MarcaProductoEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<MarcaProductoEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public MarcaProductoEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public MarcaProductoEntity add(@RequestBody MarcaProductoEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public MarcaProductoEntity update(@RequestBody MarcaProductoEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public MarcaProductoEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public MarcaProductoEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
