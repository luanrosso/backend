package exercicio03;

class PortoGrande extends BasePorto {
    public PortoGrande(String nome) {
        super(nome);
    }

    @Override
    public boolean atracarBarco(Barco barco) {
        if (barco.tamanho >= 10) {
            return super.atracarBarco(barco);
        }
        return false;
    }
}

