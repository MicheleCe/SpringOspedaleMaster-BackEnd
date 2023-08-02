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
public class RichiestaDTO {

	private Integer richiestaId;

	private Boolean status;

	private String nuovaData;

	private String nuovoOrario;

	private Integer appuntamentoId;

}
