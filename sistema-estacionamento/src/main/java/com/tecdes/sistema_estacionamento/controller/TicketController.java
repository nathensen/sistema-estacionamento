package com.tecdes.sistema_estacionamento.controller;

import java.util.Scanner;

import com.tecdes.sistema_estacionamento.service.TicketService;

public class TicketController {

    private final Scanner sc = new Scanner(System.in);

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public void iniciarMenu() {

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n===== SISTEMA ESTACIONAMENTO =====");
            System.out.println("1 - Registrar entrada");
            System.out.println("2 - Registrar saída");
            System.out.println("3 - Consultar ticket");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    registrarEntrada();
                    break;

                case 2:
                    registrarSaida();
                    break;

                case 3:
                    consultarTicket();
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void registrarEntrada() {

        System.out.println("Registrar entrada do veículo");

    
        ticketService.registrarEntrada();
    }

    private void registrarSaida() {

        System.out.println("Registrar saída do veículo");

        System.out.print("Digite o ID do ticket: ");
        Long id = sc.nextLong();

        ticketService.registrarSaida(id);
    }

    private void consultarTicket() {

        System.out.print("Digite o ID do ticket: ");
        Long id = sc.nextLong();

        ticketService.consultarTicket(id);
    }
}