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

import com.entity.Paziente;
import com.service.PazienteService;

@CrossOrigin
@RequestMapping("/ospedale/v1")
@RestController
public class PazienteController {

	@Autowired
	private PazienteService ps;

	@GetMapping("/getPazienti")
	public List<Paziente> getAll() {
		return ps.findAll();
	}

	@GetMapping("/getPazienteById/{id}")
	public Paziente findById(@PathVariable Integer id) {
		return ps.findById(id);
	}

	@PostMapping("/postPaziente")
	public Paziente postPaziente(@RequestBody Paziente paziente) {
		return ps.upsert(paziente);
	}

	@PutMapping("/updatePaziente")
	public Paziente updatePaziente(@RequestBody Paziente paziente) {
		return ps.upsert(paziente);
	}

	@PatchMapping("/patchPaziente")
	public Paziente patchPaziente(@RequestBody Paziente paziente) {
		return ps.patchPaziente(paziente);

	}

	@DeleteMapping("/deletePaziente{id}")
	public void Delete(@PathVariable Integer id) {
		ps.delete(id);
	}
}
