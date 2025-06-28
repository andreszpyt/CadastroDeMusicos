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
    public MusicoDTO create(@RequestBody MusicoDTO musico){
        return musicoService.saveMusico(musico);
    }

    // Listar músico
    @GetMapping("/read")
    public List<MusicoModel> read(){
        return musicoService.listarMusicos();
    }

    // Listar Musico por ID
    @GetMapping("/id/{id}")
    public MusicoModel readByID(@PathVariable Long id){
        return musicoService.listarPorId(id);
    }

    // deletar músico por id
    @DeleteMapping("/remover/{id}")
    public String remove(@PathVariable Long id){
        musicoService.removerMusico(id);
        return "Músico removido";
    }

    // Atualizar músico
    @PutMapping("/atualizar/{id}")
    public String atualizar(@PathVariable Long id, @RequestBody MusicoDTO musico){
        musicoService.atualizarMusico(id, musico);
        return "Músico Atualizado";
    }
}