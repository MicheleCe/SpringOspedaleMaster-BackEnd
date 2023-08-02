package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Richiesta;

public interface RichiestaRepository extends JpaRepository<Richiesta, Integer> {

}
