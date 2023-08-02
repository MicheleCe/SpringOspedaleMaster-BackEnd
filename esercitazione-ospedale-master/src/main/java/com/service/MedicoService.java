package com.service;

import java.util.List;

import com.entity.Medico;

public interface MedicoService {

	public List<Medico> findAll();

	public Medico findById(Integer id);

	public Medico save(Medico medico);

	public void delete(Integer id);

	public Medico patch(Medico medico);

}
