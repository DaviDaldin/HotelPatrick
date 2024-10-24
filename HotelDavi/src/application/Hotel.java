package application;

import java.util.Scanner;
import entities.Quarto;
import entities.Hóspede;
import entities.Reserva;

public class Hotel {
    public static void main(String[] args) {
    	//De Davi Henrique da T04N
        Scanner sc = new Scanner(System.in);
        Quarto cadastroQuarto = new Quarto(sc); 
        Hóspede cadastroHospede = new Hóspede(sc, cadastroQuarto);
        Reserva reserva = new Reserva(sc, cadastroHospede.getListaHospede());
        
        int opc;
        do {
            System.out.println("Escolha o que deseja fazer:\n" +
                    "1- Cadastrar quarto\n" +
                    "2- Excluir quarto\n" +
                    "3- Listar quartos\n" +
                    "4- Realizar Check-in\n" +
                    "5- Realizar Check-out\n" +
                    "6- Histórico de reservas\n" +
                    "7- Sair\n");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    cadastroQuarto.cadastroQuarto();
                    break;
                case 2:
                    cadastroQuarto.excluirQuarto();
                    break;
                case 3:
                    cadastroQuarto.listarQuarto();
                    break;
                case 4:
                    cadastroHospede.cadastroHospede();
                    break;
                case 5:
                    cadastroHospede.checkOut(); 
                    break;
                case 6:
                    reserva.historicoReserva(); 
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opc != 7);
        
        sc.close();
    }
}
