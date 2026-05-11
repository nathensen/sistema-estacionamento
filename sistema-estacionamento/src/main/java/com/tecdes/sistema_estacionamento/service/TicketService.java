package com.tecdes.sistema_estacionamento.service;

import java.time.Duration;
import java.time.LocalDateTime;

import com.tecdes.sistema_estacionamento.model.Ticket;
import com.tecdes.sistema_estacionamento.repository.TicketRepository;

public class TicketService {

    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void registrarEntrada() {

        Ticket ticket = new Ticket();

        ticket.setId(System.currentTimeMillis());
        ticket.setHoraEntrada(LocalDateTime.now());

        ticketRepository.salvar(ticket);

        System.out.println("Entrada registrada com sucesso!");
    }

    public void registrarSaida(Long id) {

        Ticket ticket = ticketRepository.buscarPorId(id);

        if (ticket == null) {
            System.out.println("Ticket não encontrado!");
            return;
        }

        ticket.setHoraSaida(LocalDateTime.now());

        double valor = calcularValor(ticket);

        ticket.setValor(valor);

        System.out.println("Saída registrada!");
        System.out.println("Valor total: R$ " + valor);
    }

    public void consultarTicket(Long id) {

        Ticket ticket = ticketRepository.buscarPorId(id);

        if (ticket == null) {
            System.out.println("Ticket não encontrado!");
            return;
        }

        System.out.println("ID: " + ticket.getId());
        System.out.println("Entrada: " + ticket.getHoraEntrada());
        System.out.println("Saída: " + ticket.getHoraSaida());
        System.out.println("Valor: R$ " + ticket.getValor());
    }

    public double calcularValor(Ticket ticket) {

        Duration duracao = Duration.between(
                ticket.getHoraEntrada(),
                ticket.getHoraSaida());

        long horas = duracao.toHours();

        if (horas <= 0) {
            horas = 1;
        }

        return horas * 5.0;
    }
}