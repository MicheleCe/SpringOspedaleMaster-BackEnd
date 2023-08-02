package com.service;

import java.util.List;

import com.dto.RichiestaDTO;
import com.entity.Richiesta;

public interface RichiestaService {

	public List<Richiesta> findAll();

	public Richiesta post(RichiestaDTO richiestaDTO);

	public Richiesta update(Richiesta richiesta);

	public void delete(Integer id);

	public Richiesta patchRichiesta(Richiesta richiesta);

}
