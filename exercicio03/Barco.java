package exercicio03;

class Barco {
    String nome;
    int tamanho;

    public Barco(String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return nome;
    }
}