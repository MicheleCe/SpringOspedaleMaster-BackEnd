package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
