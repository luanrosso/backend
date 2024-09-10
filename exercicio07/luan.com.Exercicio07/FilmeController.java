package luan.com.Exercicio07;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmeController {

    @GetMapping("/recomendar")
    public String recomendar(
            @RequestParam String genero,
            @RequestParam String ambiente) {

        if ("acao".equalsIgnoreCase(genero) && "futurista".equalsIgnoreCase(ambiente)) {
            return "Homens de Preto";
        } else {
            return "";
        }
    }
}

