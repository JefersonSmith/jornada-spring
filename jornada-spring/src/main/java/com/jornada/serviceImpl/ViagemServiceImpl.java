package com.jornada.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jornada.model.Viagem;
import com.jornada.repository.ViagemRepository;
import com.jornada.service.ViagemService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ViagemServiceImpl implements ViagemService {

    @Autowired
    private ViagemRepository viagemRepository;

    @Override
    public Viagem salvarViagem(Viagem viagem) {
        return viagemRepository.save(viagem);
    }

    @Override
    public List<Viagem> listarViagens() {
        return viagemRepository.findAll();
    }

    @Override
    public Viagem obterViagemPorId(Long id) {
        return viagemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Viagem não encontrada com o ID: " + id));
    }

    @Override
    public void excluirViagem(Long id) {
        viagemRepository.deleteById(id);
    }
}
