package com.service;

import java.util.List;

import com.dto.PrestazioneDTO;
import com.entity.Prestazione;

public interface PrestazioneService {

	public List<Prestazione> findAll();

	public Prestazione postPrestazione(PrestazioneDTO prestazioneDTO);

	public Prestazione patchPrestazione(Prestazione prestazione);

	public void delete(Integer id);

}
