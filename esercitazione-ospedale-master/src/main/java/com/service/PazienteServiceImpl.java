package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.entity.Paziente;
import com.repository.PazienteRepository;

@Service
public class PazienteServiceImpl implements PazienteService {

	@Autowired
	private PazienteRepository pr;

	@Override
	public List<Paziente> findAll() {
		return pr.findAll();
	}

	public ResponseEntity<Paziente> findByEmail(String email) {
		try {
			Paziente p = pr.findByEmail(email); // Chiamata al metodo del repository per trovare il paziente
			if (p != null) {
				return new ResponseEntity<>(p, HttpStatus.OK); // Restituisci il paziente trovato con stato 200 OK
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Restituisci 404 Not Found se il paziente non viene
																	// trovato
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Restituisci 500 Internal Server Error in
																			// caso di eccezione
		}
	}

	@Override
	public Paziente findById(Integer Id) {
		return pr.findById(Id).get();
	}

	@Override
	public Paziente upsert(Paziente paziente) {
		try {
			return pr.save(paziente);
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Integer id) {
		try {
			pr.deleteById(id);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Paziente patchPaziente(Paziente paziente) {
		try {
			return pr.save(paziente);
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			e.printStackTrace();
		}
		return null;
	}

}
