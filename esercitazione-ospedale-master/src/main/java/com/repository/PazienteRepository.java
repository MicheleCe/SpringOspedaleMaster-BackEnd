package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Paziente;

public interface PazienteRepository extends JpaRepository<Paziente, Integer> {

}
