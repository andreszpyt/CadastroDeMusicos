package com.CadastroDeMusicos.Orquestra.Instrumentos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class InstrumentoService {

    // criar músico
    @PostMapping("/create")
    public String create(){
        return "Cadastrar Músico";
    }

    // Listar músico
    @GetMapping("/read")
    public String read(){
        return "Mostrar Músicos";
    }

    // Listar Musico por ID
    @GetMapping("/readbyid")
    public String readByID(){
        return "Mostrar Musicos por ID";
    }

    // deletar músico
    @PutMapping("/remove")
    public String remove(){
        return "Deletar Músico";
    }

}
