package com.jornada.service;

import java.util.List;

import com.jornada.model.Passageiro;

public interface PassageiroService {
    Passageiro salvarPassageiro(Passageiro passageiro);
    List<Passageiro> listarPassageiros();
    Passageiro obterPassageiroPorId(Long id);
    void excluirPassageiro(Long id);
    Passageiro login(String usuario, String senha);
}
