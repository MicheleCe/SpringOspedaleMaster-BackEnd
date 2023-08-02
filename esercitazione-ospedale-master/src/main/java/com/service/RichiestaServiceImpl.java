package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.dto.RichiestaDTO;
import com.entity.Richiesta;
import com.repository.AppuntamentoRepository;
import com.repository.RichiestaRepository;

@Service
public class RichiestaServiceImpl implements RichiestaService {

	@Autowired
	private RichiestaRepository rr;

	@Autowired
	private AppuntamentoRepository ar;

	@Autowired
	private EmailServiceImpl es;

	@Override
	public List<Richiesta> findAll() {
		return rr.findAll();
	}

	@Override
	public Richiesta post(RichiestaDTO richiestaDTO) {
		try {
			Richiesta r = toEntity(richiestaDTO);
			r.setAppuntamento(ar.findById(richiestaDTO.getAppuntamentoId()).get());
			return rr.save(r);
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Richiesta update(Richiesta richiesta) {
		try {
			return rr.save(richiesta);
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Integer id) {
		try {
			rr.deleteById(id);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Richiesta patchRichiesta(Richiesta richiesta) {
		try {
			if (richiesta.getStatus()) {
				richiesta.getAppuntamento().setOrario(richiesta.getNuovoOrario());
				richiesta.getAppuntamento().setData(richiesta.getNuovaData());
				String pazienteEmail = richiesta.getAppuntamento().getPaziente().getEmail();
				String dottoreEmail = richiesta.getAppuntamento().getPrestazione().getMedico().getEmail();
				es.sendPositiveEmail(pazienteEmail);
				es.sendPositiveEmail(dottoreEmail);
				System.out.println("email inviata sulcesso");

			} else {
				String pazienteEmail = richiesta.getAppuntamento().getPaziente().getEmail();
				String dottoreEmail = richiesta.getAppuntamento().getPrestazione().getMedico().getEmail();
				es.sendPositiveEmail(dottoreEmail);
				es.sendNegaviteEmail(pazienteEmail);
				System.out.println("email non inviata federico cojone");

			}

			return rr.save(richiesta);
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Richiesta toEntity(RichiestaDTO richiestaDTO) {
		Richiesta r = new Richiesta();
		r.setNuovaData(richiestaDTO.getNuovaData());
		r.setNuovoOrario(richiestaDTO.getNuovoOrario());
		r.setStatus(richiestaDTO.getStatus());
		return r;
	}

}
