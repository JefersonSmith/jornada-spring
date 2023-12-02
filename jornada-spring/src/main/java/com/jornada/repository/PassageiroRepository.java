package com.jornada.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jornada.model.Passageiro;

public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {

}
