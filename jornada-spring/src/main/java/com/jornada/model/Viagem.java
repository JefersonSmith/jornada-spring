package com.jornada.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "viagem")
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_destino", nullable = false)
    private Destino destino;

    @ManyToOne
    @JoinColumn(name = "id_passageiro", nullable = false)
    private Passageiro passageiro;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataHoraIda;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataHoraVolta;

    public Viagem() {
    }

    public Viagem(Destino destino, Passageiro passageiro, LocalDateTime dataHoraIda, LocalDateTime dataHoraVolta) {
        this.destino = destino;
        this.passageiro = passageiro;
        this.dataHoraIda = dataHoraIda;
        this.dataHoraVolta = dataHoraVolta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public LocalDateTime getDataHoraIda() {
        return dataHoraIda;
    }

    public void setDataHoraIda(LocalDateTime dataHoraIda) {
        this.dataHoraIda = dataHoraIda;
    }

    public LocalDateTime getDataHoraVolta() {
        return dataHoraVolta;
    }

    public void setDataHoraVolta(LocalDateTime dataHoraVolta) {
        this.dataHoraVolta = dataHoraVolta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, destino, passageiro, dataHoraIda, dataHoraVolta);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Viagem viagem = (Viagem) obj;
        return Objects.equals(id, viagem.id) &&
                Objects.equals(destino, viagem.destino) &&
                Objects.equals(passageiro, viagem.passageiro) &&
                Objects.equals(dataHoraIda, viagem.dataHoraIda) &&
                Objects.equals(dataHoraVolta, viagem.dataHoraVolta);
    }

    @Override
    public String toString() {
        return "Viagem{" +
                "id=" + id +
                ", destino=" + destino +
                ", passageiro=" + passageiro +
                ", dataHoraIda=" + dataHoraIda +
                ", dataHoraVolta=" + dataHoraVolta +
                '}';
    }
}
