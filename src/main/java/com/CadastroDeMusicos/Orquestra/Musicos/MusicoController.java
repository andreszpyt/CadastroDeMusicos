package com.CadastroDeMusicos.Orquestra.Musicos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicos")
public class MusicoController {

    private MusicoService musicoService;
    // criar músico
    @PostMapping("/create")
    public String create(){
        return "Cadastrar Músico";
    }

    // Listar músico
    @GetMapping("/read")
    public List<MusicoModel> read(){
        return musicoService.listarMusicos();
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