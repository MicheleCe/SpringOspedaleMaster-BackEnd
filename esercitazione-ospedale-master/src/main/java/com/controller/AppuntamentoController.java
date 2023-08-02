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

import com.dto.AppuntamentoDTO;
import com.entity.Appuntamento;
import com.service.AppuntamentoService;

@CrossOrigin
@RequestMapping("/ospedale/v1")
@RestController
public class AppuntamentoController {

	@Autowired
	private AppuntamentoService as;

	@GetMapping("/getAppuntamento")
	public List<Appuntamento> getAppuntamenti() {
		return as.findAll();
	}

	@GetMapping("/getAppuntamentoByData/{data}")
	public List<Appuntamento> getAppuntamentoByData(@PathVariable String data) {
		return as.findByData(data);
	}

	@GetMapping("/getAppuntamentoByPazienteId/{id}")
	public List<Appuntamento> getAppuntamentoByPazienteId(@PathVariable Integer id) {
		return as.findByPaziente(id);
	}

	@GetMapping("/getAppuntamentoByMedicoId/{id}")
	public List<Appuntamento> getAppuntamentoByMedicoId(@PathVariable Integer id) {
		return as.findByMedico(id);
	}

	@PostMapping("/postAppuntamento")
	public Appuntamento postAppuntamento(@RequestBody AppuntamentoDTO appuntamento) {
		System.out.println(appuntamento);
		return as.post(appuntamento);
	}

	@PatchMapping("/patchAppuntamento")
	public Appuntamento patchAppuntamento(@RequestBody Appuntamento appuntamento) {
		return as.patch(appuntamento);
	}

	@DeleteMapping("/deleteAppuntamento/{id}")
	public void Delete(@PathVariable Integer id) {
		as.delete(id);
	}

}
