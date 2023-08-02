package com.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Prestazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prestazione_id")
	private Integer prestazioneId;

	private String tipologia;

	@ManyToOne
	@JoinColumn(name = "medico_id")
	private Medico medico;

	@JsonIgnore
	@OneToMany(mappedBy = "prestazione")
	private List<Appuntamento> appuntamenti = new ArrayList<>();

	@Override
	public String toString() {
		return "Prestazione [prestazioneId=" + prestazioneId + ", tipologia=" + tipologia + ", medico=" + medico + "]";
	}

}
