package com.example.demo;

import java.util.List;

public class ModeloResponse {
    private List<Modelo> modelos;

    // Getters e Setters
    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public static class Modelo {
        private int codigo;
        private String nome;

        // Getters e Setters
        public int getCodigo() {
            return codigo;
        }

        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }
}
