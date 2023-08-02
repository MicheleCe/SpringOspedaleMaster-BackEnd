package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.entity.Medico;
import com.service.MedicoService;

@CrossOrigin
@RequestMapping("/ospedale/v1")
@RestController
public class MedicoController {

	@Autowired
	private MedicoService ms;

	@GetMapping("/getMedico")
	public List<Medico> findAll() {
		return ms.findAll();
	}

	@GetMapping("/getMedico/{id}")
	public Medico findById(@PathVariable Integer id) {
		return ms.findById(id);
	}

	@GetMapping("/getMedicoByEmail/{email}")
	public ResponseEntity<Medico> findMedicoByEmail(@PathVariable String email) {
		return ms.findByEmail(email);
	}

	@PostMapping("/postMedico")
	public Medico post(@RequestBody Medico medico) {
		return ms.save(medico);
	}

	@PutMapping("/postMedico")
	public Medico put(@RequestBody Medico medico) {
		return ms.save(medico);
	}

	@PatchMapping("/patchMedico")
	public Medico patch(@RequestBody Medico medico) {
		return ms.patch(medico);
	}

	@DeleteMapping("/medico/{medicoId}")
	public void Delete(@PathVariable Integer medicoId) {
		ms.delete(medicoId);
	}
}
