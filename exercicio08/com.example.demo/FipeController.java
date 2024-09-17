package com.example.demo;

import com.example.demo.Ano;
import com.example.demo.CarroRequest;
import com.example.demo.FipeResponse;
import com.example.demo.Marca;
import com.example.demo.ModeloResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/fipe")
public class FipeController {

    @PostMapping("/valor")
    public ResponseEntity<FipeResponse> getValorFipe(@RequestBody CarroRequest carroRequest) {
        RestTemplate restTemplate = new RestTemplate();

        // URL para obter marcas
        String marcaUrl = "https://parallelum.com.br/fipe/api/v1/carros/marcas";
        Marca[] marcas = restTemplate.getForObject(marcaUrl, Marca[].class);

        Marca marcaSelecionada = null;
        for (Marca marca : marcas) {
            if (marca.getNome().equalsIgnoreCase(carroRequest.getMarca())) {
                marcaSelecionada = marca;
                break;
            }
        }

        if (marcaSelecionada == null) {
            return ResponseEntity.badRequest().body(null);
        }

        // URL para obter modelos da marca selecionada
        String modeloUrl = String.format("https://parallelum.com.br/fipe/api/v1/carros/marcas/%d/modelos",
                marcaSelecionada.getCodigo());
        ModeloResponse modeloResponse = restTemplate.getForObject(modeloUrl, ModeloResponse.class);

        ModeloResponse.Modelo modeloSelecionado = null;
        for (ModeloResponse.Modelo modelo : modeloResponse.getModelos()) {
            if (modelo.getNome().equalsIgnoreCase(carroRequest.getModelo())) {
                modeloSelecionado = modelo;
                break;
            }
        }

        if (modeloSelecionado == null) {
            return ResponseEntity.badRequest().body(null);
        }

        // URL para obter anos do modelo selecionado
        String anoUrl = String.format("https://parallelum.com.br/fipe/api/v1/carros/marcas/%d/modelos/%d/anos",
                marcaSelecionada.getCodigo(), modeloSelecionado.getCodigo());
        Ano[] anos = restTemplate.getForObject(anoUrl, Ano[].class);

        Ano anoSelecionado = null;
        for (Ano ano : anos) {
            if (ano.getNome().contains(String.valueOf(carroRequest.getAno()))) {
                anoSelecionado = ano;
                break;
            }
        }

        if (anoSelecionado == null) {
            return ResponseEntity.badRequest().body(null);
        }

        // URL final para obter o valor FIPE
        String valorUrl = String.format("https://parallelum.com.br/fipe/api/v1/carros/marcas/%d/modelos/%d/anos/%s",
                marcaSelecionada.getCodigo(), modeloSelecionado.getCodigo(), anoSelecionado.getCodigo());
        FipeResponse fipeResponse = restTemplate.getForObject(valorUrl, FipeResponse.class);

        return ResponseEntity.ok(fipeResponse);
    }
}
