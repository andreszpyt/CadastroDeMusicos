package com.CadastroDeMusicos.Orquestra.Musicos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicos")
public class MusicoController {

    private MusicoService musicoService;

    public MusicoController(MusicoService musicoService) {
        this.musicoService = musicoService;
    }

    // criar músico
    @PostMapping("/save")
    public MusicoModel create(@RequestBody MusicoModel musico){
        return musicoService.saveNinja(musico);
    }

    // Listar músico
    @GetMapping("/read")
    public List<MusicoModel> read(){
        return musicoService.listarMusicos();
    }

    // Listar Musico por ID
    @GetMapping("/{id}")
    public MusicoModel readByID(@PathVariable Long id){
        return musicoService.listarPorId(id);
    }


    // deletar músico
    @PutMapping("/remove")
    public String remove(){
        return "Deletar Músico";
    }

}