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
import pe.com.megacentimetros.catalogo.entity.RolSistemaEntity;
import pe.com.megacentimetros.catalogo.service.RolSistemaService;

@RestController
@RequestMapping("/api/rolsistema")
public class RolSistemaRestController {

	@Autowired
	private RolSistemaService servicio;

	@GetMapping
	public List<RolSistemaEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<RolSistemaEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public RolSistemaEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public RolSistemaEntity add(@RequestBody RolSistemaEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public RolSistemaEntity update(@RequestBody RolSistemaEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public RolSistemaEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public RolSistemaEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
