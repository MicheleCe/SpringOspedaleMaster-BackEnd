package com.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

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

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PrestazioneDTO implements Serializable {

	private static final long serialVersionUID = 6009312112611650189L;

	private String tipologia;

	private Integer medicoId;

}
