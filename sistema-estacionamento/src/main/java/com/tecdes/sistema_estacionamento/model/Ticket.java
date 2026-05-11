package com.tecdes.sistema_estacionamento.model;

import java.time.LocalDateTime;

public class Ticket {

    private Long id;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;
    private double valor;

    private Veiculo veiculo;
    private Vaga vaga;

    public Ticket() {
    }

    public Ticket(Long id, LocalDateTime horaEntrada,
                  LocalDateTime horaSaida, double valor,
                  Veiculo veiculo, Vaga vaga) {

        this.id = id;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.valor = valor;
        this.veiculo = veiculo;
        this.vaga = vaga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalDateTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }
}