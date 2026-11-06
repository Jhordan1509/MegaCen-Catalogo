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
import pe.com.megacentimetros.catalogo.entity.TipoEmpaqueEntity;
import pe.com.megacentimetros.catalogo.service.TipoEmpaqueService;

@RestController
@RequestMapping("/api/tipoempaque")
public class TipoEmpaqueRestController {

	@Autowired
	private TipoEmpaqueService servicio;

	@GetMapping
	public List<TipoEmpaqueEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<TipoEmpaqueEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public TipoEmpaqueEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public TipoEmpaqueEntity add(@RequestBody TipoEmpaqueEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public TipoEmpaqueEntity update(@RequestBody TipoEmpaqueEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public TipoEmpaqueEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public TipoEmpaqueEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
