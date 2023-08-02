package com.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.PrestazioneDTO;
import com.entity.Prestazione;
import com.repository.MedicoRepository;
import com.repository.PrestazioneRepository;

@Service
public class PrestazioneServiceImpl implements PrestazioneService {

	@Autowired
	private PrestazioneRepository pr;

	@Autowired
	private MedicoRepository mr;

	@Override
	public List<Prestazione> findAll() {
		return pr.findAll();
	}

	@Override
	public Prestazione postPrestazione(PrestazioneDTO prestazioneDTO) {
		try {
			Prestazione prestazione = toEntity(prestazioneDTO);
			prestazione.setMedico(mr.findById(prestazioneDTO.getMedicoId()).get());
			return pr.save(prestazione);
		} catch (NoSuchElementException e) {

		}
		return null;

	}

	@Override
	public Prestazione patchPrestazione(Prestazione prestazione) {
		return pr.save(prestazione);
	}

	@Override
	public void delete(Integer id) {
		pr.deleteById(id);

	}

	private Prestazione toEntity(PrestazioneDTO prestazioneDTO) {
		Prestazione p = new Prestazione();
		p.setTipologia(prestazioneDTO.getTipologia());
		return p;
	}

}
