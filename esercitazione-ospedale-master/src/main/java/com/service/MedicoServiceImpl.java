package com.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Medico;
import com.repository.MedicoRepository;

@Service
public class MedicoServiceImpl implements MedicoService {

	@Autowired
	private MedicoRepository mr;

	@Override
	public List<Medico> findAll() {
		return mr.findAll();
	}

	@Override
	public Medico findById(Integer id) {
		return mr.findById(id).get();
	}

	@Override
	public Medico save(Medico medico) {
		return mr.save(medico);
	}

	@Override
	public void delete(Integer id) {
		mr.deleteById(id);

	}

	@Override
	public Medico patch(Medico medico) {
		Optional<Medico> m = mr.findById(medico.getMedicoId());
		try {
			m.get().setActive(medico.getActive());
			mr.save(m.get());
			return m.get();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return null;
		}
	}

}
