package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.PrestazioneDTO;
import com.entity.Prestazione;
import com.service.PrestazioneService;

@CrossOrigin
@RequestMapping("/ospedale/v1")
@RestController
public class PrestazioneController {

	@Autowired
	private PrestazioneService ps;

	@GetMapping("/getPrestazioni")
	public List<Prestazione> getAll() {
		return ps.findAll();
	}

	@PostMapping("/postPrestazione")
	public Prestazione postPrestazione(@RequestBody PrestazioneDTO prestazione) {
		return ps.postPrestazione(prestazione);

	}

	@PatchMapping("/patchPrestazione")
	public Prestazione patchPrestazione(@RequestBody Prestazione prestazione) {
		return ps.patchPrestazione(prestazione);
	}

	@DeleteMapping("/deletePrestazione{id}")
	public void Delete(@PathVariable Integer id) {
		ps.delete(id);
	}
}
