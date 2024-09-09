package exercicio06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cinema cinema = new Cinema();
        cinema.adicionarFilme(new Filme("Homem Aranha", 20.0, 12));
        cinema.adicionarFilme(new Filme("Vingadores", 25.0, 12));
        cinema.adicionarFilme(new Filme("O Exorcista", 30.0, 18));
        cinema.adicionarFilme(new Filme("Toy Story", 15.0, 0));
        cinema.adicionarFilme(new Filme("Matrix", 22.0, 16));

        while (true) {
            try {
                cinema.listarFilmesDisponiveis();

                System.out.println("Qual filme você deseja assistir?");
                String nomeFilme = scanner.nextLine();
                Filme filme = cinema.encontrarFilme(nomeFilme);

                if (filme == null) {
                    throw new Exception("Não encontramos o filme desejado!");
                }

                List<String> assentos = cinema.listarAssentosDisponiveis(4);
                System.out.println("Assentos disponíveis (sugestão): " + assentos);

                System.out.println("Qual assento você deseja?");
                String assento = scanner.nextLine();

                if (!cinema.assentoDisponivel(assento)) {
                    throw new Exception("O assento não está disponível no momento!");
                }

                System.out.println("Qual o seu nome?");
                String nomeCliente = scanner.nextLine();
                System.out.println("Qual a sua idade?");
                int idade = scanner.nextInt();
                scanner.nextLine();

                Cliente cliente = new Cliente(nomeCliente, idade);

                if (cliente.getIdade() < filme.getIdadeMinima()) {
                    throw new Exception("Sua idade não permite assistir este filme!");
                }

                Ingresso ingresso = new Ingresso(cliente, filme, assento);
                cinema.venderIngresso(ingresso);
                System.out.println(ingresso);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Deseja continuar comprando ingressos? (s/n)");
            String continuar = scanner.nextLine();
            if (!continuar.equalsIgnoreCase("s")) {
                break;
            }
        }

        scanner.close();
    }
}
