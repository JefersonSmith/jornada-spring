package com.jornada.repository;

import com.jornada.model.Passageiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {
    Passageiro findByUsuarioAndSenha(String usuario, String senha);
}
