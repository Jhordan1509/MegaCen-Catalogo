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
import pe.com.megacentimetros.catalogo.entity.SexoEntity;
import pe.com.megacentimetros.catalogo.service.SexoService;

@RestController
@RequestMapping("/api/sexo")
public class SexoRestController {

	@Autowired
	private SexoService servicio;

	@GetMapping
	public List<SexoEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<SexoEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public SexoEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public SexoEntity add(@RequestBody SexoEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public SexoEntity update(@RequestBody SexoEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public SexoEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public SexoEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
