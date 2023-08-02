package com.service;

import java.util.List;

import com.dto.AppuntamentoDTO;
import com.entity.Appuntamento;

public interface AppuntamentoService {

	public List<Appuntamento> findAll();

	public List<Appuntamento> findByData(String data);

	public List<Appuntamento> findByPaziente(Integer id);

	public List<Appuntamento> findByMedico(Integer id);

	public Appuntamento patch(Appuntamento appuntamento);

	public Appuntamento post(AppuntamentoDTO appuntamentoDTO);

	public void delete(Integer id);

}
