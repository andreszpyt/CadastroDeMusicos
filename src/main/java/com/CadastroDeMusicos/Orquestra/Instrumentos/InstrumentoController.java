package com.CadastroDeMusicos.Orquestra.Instrumentos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrumentos")
public class InstrumentoController {

    public InstrumentoService instrumentoService;

    public InstrumentoController(InstrumentoService instrumentoService) {
        this.instrumentoService = instrumentoService;
    }

    // Listar todos
    @GetMapping("/listar")
    public List<InstrumentoDTO> listarTodos(){
        return instrumentoService.listar();
    }

    // Listar por ID
    @GetMapping("/id/{id}")
        public InstrumentoDTO listarById(@PathVariable Long id){
        return instrumentoService.listarPorID(id);
    }

    @PostMapping("/save")
    public String saveInstrumento(@RequestBody InstrumentoDTO instrumento){
        instrumentoService.save((instrumento));
        return "Instrumento Salvo com Sucesso";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInstrumento(@PathVariable Long id){
        instrumentoService.delete(id);
        return "Instrumento deletado";
    }

    // Atualizar Instrumento
    @PutMapping("/atualizar/{id}")
    public String atualizarInstrumento(@PathVariable Long id, @RequestBody InstrumentoDTO instrumento){
        instrumentoService.atualizarInstrumento(id, instrumento);
        return "Instrumento Atualizado";
    }
}
