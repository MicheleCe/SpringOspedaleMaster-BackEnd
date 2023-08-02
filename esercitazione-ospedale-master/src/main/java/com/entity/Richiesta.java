package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Richiesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "richiesta_id")
	private Integer richiestaId;

	@Column(name = "nuova_data")
	private String nuovaData;

	@Column(name = "nuovo_orario")
	private String nuovoOrario;

	private Boolean status;

	@OneToOne
	@JoinColumn(name = "appuntamento_id", nullable = false)
	private Appuntamento appuntamento;

}
