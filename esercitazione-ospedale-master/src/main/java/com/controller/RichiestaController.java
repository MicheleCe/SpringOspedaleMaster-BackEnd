package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.RichiestaDTO;
import com.entity.Richiesta;
import com.service.RichiestaService;

@CrossOrigin
@RequestMapping("/ospedale/v1")
@RestController
public class RichiestaController {

	@Autowired
	private RichiestaService rs;

	@GetMapping("/getRichieste")
	public List<Richiesta> getAll() {
		return rs.findAll();
	}

	@PostMapping("/postRichiesta")
	public Richiesta postRichiesta(@RequestBody RichiestaDTO richiesta) {
		return rs.post(richiesta);
	}

	@PutMapping("/updateRichiesta")
	public Richiesta updateRichiesta(@RequestBody Richiesta richiesta) {
		return rs.update(richiesta);
	}

	@PatchMapping("/patchRichiesta")
	public Richiesta patchRichiesta(@RequestBody Richiesta richiesta) {
		return rs.patchRichiesta(richiesta);

	}

	@DeleteMapping("/deleteRichiesta/{id}")
	public void Delete(@PathVariable Integer id) {
		rs.delete(id);
	}

}
