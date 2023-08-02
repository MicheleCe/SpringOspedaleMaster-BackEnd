package com.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AppuntamentoDTO {

	private Integer appuntamentoId;
	private String ricetta;
	private Boolean completato;
	private String data;
	private String orario;
	private Integer prestazioneId;
	private Integer pazienteId;
}