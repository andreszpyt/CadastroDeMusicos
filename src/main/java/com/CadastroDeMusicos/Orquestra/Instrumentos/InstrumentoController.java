package com.CadastroDeMusicos.Orquestra.Instrumentos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrumentos")
public class InstrumentoController {

    public InstrumentoService instrumentoService;

    public InstrumentoController(InstrumentoService instrumentoService) {
        this.instrumentoService = instrumentoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<InstrumentoDTO>> listarTodos(){
        List<InstrumentoDTO> instrumentos = instrumentoService.listar();
        return ResponseEntity.ok(instrumentos);
    }

    @GetMapping("/id/{id}")
        public ResponseEntity<?> listarById(@PathVariable Long id){
        InstrumentoDTO instrumento = instrumentoService.listarPorID(id);
        if(instrumento != null){
            return ResponseEntity.ok(instrumento);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Instrumento não encontrado");
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveInstrumento(@RequestBody InstrumentoDTO instrumento){
        instrumentoService.save((instrumento));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Instrumento Cadastrado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInstrumento(@PathVariable Long id){
        if(instrumentoService.listarPorID(id) != null){
            return ResponseEntity.ok("Instrumento removido");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Instrumento não encontrado");
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarInstrumento(@PathVariable Long id, @RequestBody InstrumentoDTO instrumento){
        if(instrumentoService.listarPorID(id) != null){
            instrumentoService.atualizarInstrumento(id, instrumento);
            return ResponseEntity.ok("Instrumento atualizado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Instrumento não encontrado");
    }
}
