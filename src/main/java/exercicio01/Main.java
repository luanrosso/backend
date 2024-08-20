package exercicio01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Qual ambientação você prefere?");
        System.out.println("1 - Sci fi");
        System.out.println("2 - Medieval");
        Integer opcaoAmbientacao = leitor.nextInt();


        System.out.println("Qual gênero você prefere?");
        System.out.println("1 - Comédia");
        System.out.println("2 - Drama");
        Integer opcaoGenero = leitor.nextInt();


        if (opcaoAmbientacao == 1 && opcaoGenero == 1) System.out.println("Homens De Preto");
        if (opcaoAmbientacao == 1 && opcaoGenero == 2) System.out.println("Arrival");
        if (opcaoAmbientacao == 2 && opcaoGenero == 1) System.out.println("Shrek");
        if (opcaoAmbientacao == 2 && opcaoGenero == 2) System.out.println("Gladiador");
    }
}