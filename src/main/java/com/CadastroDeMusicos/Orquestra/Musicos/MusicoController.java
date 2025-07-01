package com.CadastroDeMusicos.Orquestra.Musicos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicos")
public class MusicoController {

    private final MusicoService musicoService;

    public MusicoController(MusicoService musicoService) {
        this.musicoService = musicoService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> create(@RequestBody MusicoDTO musico){
        musicoService.saveMusico(musico);
        return ResponseEntity.status(HttpStatus.CREATED).body("Músico cadastrado");
    }

    @GetMapping("/read")
    public ResponseEntity<List<MusicoDTO>> read(){
        List<MusicoDTO> musicos = musicoService.listarMusicos();
        return ResponseEntity.ok(musicos);
    }

    // Listar Musico por ID
    @GetMapping("/id/{id}")
    public ResponseEntity<?> readByID(@PathVariable Long id){
        MusicoDTO musico = musicoService.listarPorId(id);
        if(musico != null){
            return ResponseEntity.ok(musico);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Músico não encontrado");
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<String> remove(@PathVariable Long id){
        if(musicoService.listarPorId(id) != null){
            musicoService.removerMusico(id);
            return ResponseEntity.ok("Músico removido");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Músico não encontrado");
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody MusicoDTO musico){
        if(musicoService.listarPorId(id) != null){
            musicoService.atualizarMusico(id, musico);
            return ResponseEntity.ok("Músico atualizado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Músico não encontrado");
    }
}