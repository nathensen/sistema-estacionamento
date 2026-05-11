package com.tecdes.sistema_estacionamento.repository;

import java.util.ArrayList;
import java.util.List;

import com.tecdes.sistema_estacionamento.model.Ticket;

public class TicketRepository {

    private List<Ticket> tickets = new ArrayList<>();

    public void salvar(Ticket ticket) {
        tickets.add(ticket);
    }

    public Ticket buscarPorId(Long id) {

        for (Ticket ticket : tickets) {

            if (ticket.getId().equals(id)) {
                return ticket;
            }
        }

        return null;
    }

    public List<Ticket> listarTodos() {
        return tickets;
    }
}