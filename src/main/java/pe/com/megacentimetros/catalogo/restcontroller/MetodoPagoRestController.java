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
import pe.com.megacentimetros.catalogo.entity.MetodoPagoEntity;
import pe.com.megacentimetros.catalogo.service.MetodoPagoService;

@RestController
@RequestMapping("/api/metodopago")
public class MetodoPagoRestController {

	@Autowired
	private MetodoPagoService servicio;

	@GetMapping
	public List<MetodoPagoEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<MetodoPagoEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public MetodoPagoEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public MetodoPagoEntity add(@RequestBody MetodoPagoEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public MetodoPagoEntity update(@RequestBody MetodoPagoEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public MetodoPagoEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public MetodoPagoEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
