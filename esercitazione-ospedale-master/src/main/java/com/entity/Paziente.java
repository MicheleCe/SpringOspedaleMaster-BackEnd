package com.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Paziente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paziente_id")
	private Integer pazienteId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "codice_fiscale", nullable = false, unique = true)
	private String codiceFiscale;

	@NotEmpty(message = "Email cannot be empty")
	@Email(message = "Invalid email format")
	private String email;

	@JsonIgnore
	@OneToMany(mappedBy = "paziente")
	private List<Appuntamento> appuntamenti = new ArrayList<>();

	@Override
	public String toString() {
		return "Paziente [pazienteId=" + pazienteId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", codiceFiscale=" + codiceFiscale + ", email=" + email + "]";
	}

}
