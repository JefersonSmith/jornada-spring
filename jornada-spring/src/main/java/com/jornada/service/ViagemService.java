package com.jornada.service;

import com.jornada.model.Viagem;

import java.util.List;

public interface ViagemService {
    Viagem salvarViagem(Viagem viagem);
    List<Viagem> listarViagens();
    Viagem obterViagemPorId(Long id);
    void excluirViagem(Long id);
}
