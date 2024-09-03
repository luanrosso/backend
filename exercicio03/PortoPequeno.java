package exercicio03;

class PortoPequeno extends BasePorto {
    public PortoPequeno(String nome) {
        super(nome);
    }

    @Override
    public boolean atracarBarco(Barco barco) {
        if (barco.tamanho <= 10) {
            return super.atracarBarco(barco);
        }
        return false;
    }
}