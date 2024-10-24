package entities;

import java.util.List;
import java.util.Scanner;

public class Reserva {
    public Scanner sc;
    private List<Hóspede.CadastroHospede> listaHospede;

    public Reserva(Scanner sc, List<Hóspede.CadastroHospede> listaHospede) {
        this.sc = sc;
        this.listaHospede = listaHospede;
    }

    public void historicoReserva() {
        if (listaHospede.isEmpty()) {
            System.out.println("Não há reservas para mostrar.");
            return;
        }

        System.out.println("Histórico de Reservas:");
        for (Hóspede.CadastroHospede hospede : listaHospede) {
            System.out.println("Nome do Hóspede: " + hospede.nome);
            System.out.println("Data de Check-in: " + hospede.checkIn);
            System.out.println("Data de Check-out: " + hospede.checkOut);
            System.out.println("Número do Quarto Reservado: " + hospede.num);
            System.out.println("Tipo de Quarto Reservado: " + hospede.tipo);
            System.out.println("---------------------------------------");
        }
    }
}
