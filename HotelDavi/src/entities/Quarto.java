package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quarto {
    public Scanner sc;
    public List<CadastroQuarto> listaQuarto = new ArrayList<>();

    public Quarto(Scanner sc) {
        this.sc = sc;
    }

    public void cadastroQuarto() {
        System.out.println("Digite quantos quartos deseja cadastrar: ");
        int qtd = sc.nextInt();

        for (int i = 0; i < qtd; ++i) {
            System.out.print("Digite o número do quarto: ");
            int num = sc.nextInt();
            sc.nextLine();

            System.out.print("Digite o tipo de quarto:\n" +
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

            System.out.print("Digite o preço do quarto: ");
            double preco = sc.nextDouble();
            sc.nextLine();

            System.out.print("Digite a disponibilidade do quarto:\n" +
                    "1- Disponível\n" +
                    "2- Ocupado");
            String disponivel = sc.next();

            do {
                if (disponivel.equals("1")) {
                    disponivel = "Disponível";
                } else if (disponivel.equals("2")) {
                    disponivel = "Ocupado";
                } else {
                    System.out.println("Opção inválida! Tente novamente!");
                }
            } while (!disponivel.equals("Disponível") && !disponivel.equals("Ocupado"));

            CadastroQuarto quarto = new CadastroQuarto(num, tipo, preco, disponivel);
            listaQuarto.add(quarto);
        }
    }

    public boolean isQuartoDisponivel(int num) {
        for (CadastroQuarto quarto : listaQuarto) {
            if (quarto.num == num && quarto.disponivel.equals("Disponível")) {
                return true;
            }
        }
        return false; 
    }
    
    public void atualizarDisponibilidade(int num, boolean disponivel) {
        for (CadastroQuarto quarto : listaQuarto) {
            if (quarto.num == num) {
                if (disponivel) {
                    quarto.disponivel = "Disponível"; 
                } else {
                    quarto.disponivel = "Ocupado"; 
                }
                break;
            }
        }
    }

    public void excluirQuarto() {
        System.out.print("Digite o número do quarto que deseja excluir: ");
        int num = sc.nextInt();

        CadastroQuarto quartoParaRemover = null;

        for (CadastroQuarto quarto : listaQuarto) {
            if (quarto.num == num) {
                quartoParaRemover = quarto;
                break;
            }
        }

        if (quartoParaRemover != null) {
            listaQuarto.remove(quartoParaRemover);
            System.out.println("Quarto número " + num + " excluído com sucesso!");
        } else {
            System.out.println("Quarto não encontrado!");
        }
    }

    public void listarQuarto() {
        for (CadastroQuarto quarto : listaQuarto) {
            System.out.println(quarto.toString());
        }
    }

    class CadastroQuarto {
        public int num;
        public String tipo;
        public double preco;
        public String disponivel;

        public CadastroQuarto(int num, String tipo, double preco, String disponivel) {
            this.num = num;
            this.tipo = tipo;
            this.preco = preco;
            this.disponivel = disponivel;
        }

        public String toString() {
            return "Quarto número: " + num +
                    ", tipo: " + tipo +
                    ", com o preço de: " + preco +
                    ", está: " + disponivel + "\n";
        }
    }
}
