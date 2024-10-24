package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hóspede {
    public Scanner sc;
    public List<CadastroHospede> listaHospede = new ArrayList<>();
    private Quarto quarto; 

    public Hóspede(Scanner sc, Quarto quarto) {
        this.sc = sc;
        this.quarto = quarto; 
    }

    public void cadastroHospede() {
        System.out.print("Digite o número de quartos reservados: ");
        int qtd = sc.nextInt();

        for (int i = 0; i < qtd; ++i) {
            System.out.print("Digite o nome do hóspede: ");
            String nome = sc.next();
            System.out.print("Digite a data de check-in: ");
            int checkIn = sc.nextInt();
            System.out.print("Digite a data de check-out: ");
            int checkOut = sc.nextInt();
            System.out.println("Digite o número do quarto reservado: ");
            int num = sc.nextInt();
            sc.nextLine();

            if (quarto.isQuartoDisponivel(num)) {
                System.out.print("Digite o tipo de quarto reservado: " +
                        "1- Solteiro\n" +
                        "2- Casal\n" +
                        "3- Suíte");
                String tipo = sc.next();

                do {
                    if (tipo.equals("1")) {
                        tipo = "Solteiro";
                    } else if (tipo.equals("2")) {
                        tipo = "Casal";
                    } else if (tipo.equals("3")) {
                        tipo = "Suíte";
                    } else {
                        System.out.println("Opção inválida! Tente novamente!");
                    }
                } while (!tipo.equals("Solteiro") && !tipo.equals("Casal") && !tipo.equals("Suíte"));

                CadastroHospede hospede = new CadastroHospede(nome, checkIn, checkOut, num, tipo);
                listaHospede.add(hospede);
                System.out.println("Hóspede cadastrado com sucesso!");
            } else {
                System.out.println("Quarto número " + num + " não está disponível para reserva.");
            }
        }
    }

    public void checkOut() {
        System.out.print("Digite o número do quarto para check-out: ");
        int num = sc.nextInt();
        sc.nextLine();

        
        boolean encontrado = false;
        for (CadastroHospede hospede : listaHospede) {
            if (hospede.num == num) {
                encontrado = true;
                System.out.println("Hóspede " + hospede.nome + " fez check-out com sucesso!");
                listaHospede.remove(hospede);
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Quarto não encontrado ou não está ocupado por um hóspede.");
        } else {
            
            quarto.atualizarDisponibilidade(num, true); 
        }
    }
    
    public List<CadastroHospede> getListaHospede() {
        return listaHospede;
    }

    class CadastroHospede {
        public String nome;
        public int checkIn;
        public int checkOut;
        public int num;
        public String tipo;

        public CadastroHospede(String nome, int checkIn, int checkOut, int num, String tipo) {
            this.nome = nome;
            this.checkIn = checkIn;
            this.checkOut = checkOut;
            this.num = num;
            this.tipo = tipo;
        }

        @Override
        public String toString() {
            return "Cadastro Hóspede [Nome = " + nome + ", Check-in = " + checkIn + ", Check-out = " + checkOut + ", Quarto = " + num + ", Tipo = " + tipo + "]\n";
        }
    }
}
