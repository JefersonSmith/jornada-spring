package com.jornada.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jornada.model.Passageiro;
import com.jornada.repository.PassageiroRepository;
import com.jornada.service.PassageiroService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class PassageiroServiceImpl implements PassageiroService {

    @Autowired
    private PassageiroRepository passageiroRepository;

    @Override
    public Passageiro salvarPassageiro(Passageiro passageiro) {
        return passageiroRepository.save(passageiro);
    }

    @Override
    public List<Passageiro> listarPassageiros() {
        return passageiroRepository.findAll();
    }

    @Override
    public Passageiro obterPassageiroPorId(Long id) {
        return passageiroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Passageiro não encontrado com o ID: " + id));
    }

    @Override
    public void excluirPassageiro(Long id) {
        passageiroRepository.deleteById(id);
    }

    @Override
    public Passageiro login(String usuario, String senha) {
        return passageiroRepository.findByUsuarioAndSenha(usuario, senha);
    }
}
