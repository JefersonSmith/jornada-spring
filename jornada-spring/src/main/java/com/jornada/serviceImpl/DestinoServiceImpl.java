package com.jornada.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jornada.model.Destino;
import com.jornada.repository.DestinoRepository;
import com.jornada.service.DestinoService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class DestinoServiceImpl implements DestinoService {

    @Autowired
    private DestinoRepository destinoRepository;

    @Override
    public Destino salvarDestino(Destino destino) {
        return destinoRepository.save(destino);
    }

    @Override
    public List<Destino> listarDestinos() {
        return destinoRepository.findAll();
    }

    @Override
    public Destino obterDestinoPorId(Long id) {
        return destinoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Destino não encontrado com o ID: " + id));
    }

    @Override
    public void excluirDestino(Long id) {
        destinoRepository.deleteById(id);
    }
}
