package com.jornada.service;

import java.util.List;

import com.jornada.model.Destino;

public interface DestinoService {
    Destino salvarDestino(Destino destino);
    List<Destino> listarDestinos();
    Destino obterDestinoPorId(Long id);
    void excluirDestino(Long id);
}
