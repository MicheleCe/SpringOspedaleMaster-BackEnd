package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Appuntamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appuntamento_id")
	private Integer appuntamentoId;

	private String data;

	private String orario;

	@Column(nullable = false)
	private String ricetta;

	private Boolean completato;

	@ManyToOne
	@JoinColumn(name = "paziente_id", nullable = false)
	private Paziente paziente;

	@ManyToOne
	@JoinColumn(name = "prestazione_id", nullable = false)
	private Prestazione prestazione;

	@JsonIgnore
	@OneToOne(mappedBy = "appuntamento")
	private Richiesta richiesta;

}
