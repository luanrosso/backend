package exercicio06;

import java.util.List;
import java.util.ArrayList;

class Cinema {
    private ArrayList<Filme> filmesDisponiveis = new ArrayList<>();
    private ArrayList<Ingresso> ingressosVendidos = new ArrayList<>();
    private ArrayList<String> assentosDisponiveis = new ArrayList<>();

    public Cinema() {
        // Inicializando os assentos de A1 a F5
        for (char fileira = 'A'; fileira <= 'F'; fileira++) {
            for (int numero = 1; numero <= 5; numero++) {
                assentosDisponiveis.add(fileira + Integer.toString(numero));
            }
        }
    }

    public void adicionarFilme(Filme filme) {
        filmesDisponiveis.add(filme);
    }

    public Filme encontrarFilme(String nome) {
        for (Filme filme : filmesDisponiveis) {
            if (filme.getNome().equalsIgnoreCase(nome)) {
                return filme;
            }
        }
        return null;
    }

    public boolean assentoDisponivel(String assento) {
        return assentosDisponiveis.contains(assento);
    }

    public void venderIngresso(Ingresso ingresso) {
        ingressosVendidos.add(ingresso);
        assentosDisponiveis.remove(ingresso.getAssento());
    }

    public void listarFilmesDisponiveis() {
        System.out.println("Filmes disponíveis no momento:");
        for (Filme filme : filmesDisponiveis) {
            System.out.println("- " + filme);
        }
    }

    public List<String> listarAssentosDisponiveis(int quantidade) {
        List<String> assentos = new ArrayList<>();
        for (int i = 0; i < quantidade && i < assentosDisponiveis.size(); i++) {
            assentos.add(assentosDisponiveis.get(i));
        }
        return assentos;
    }
}