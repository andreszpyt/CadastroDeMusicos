package com.CadastroDeMusicos.Orquestra.Musicos;

import com.CadastroDeMusicos.Orquestra.Instrumentos.InstrumentoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("musicos/ui")
public class MusicoControllerUI {

    private final MusicoService musicoService;
    private final InstrumentoService instrumentoService;

    public MusicoControllerUI(MusicoService musicoService, InstrumentoService instrumentoService) {
        this.musicoService = musicoService;
        this.instrumentoService = instrumentoService;
    }

    @GetMapping("/read")
    public String read(Model model){
        List<MusicoDTO> musicos = musicoService.listarMusicos();
        model.addAttribute("musicos", musicos);
        return "listarMusicos";
    }

    @GetMapping("/remover/{id}")
    public String remove(@PathVariable Long id) {
            musicoService.removerMusico(id);
            return ("redirect:/musicos/ui/read");
    }

    @GetMapping("detalhes/{id}")
    public String readByID(@PathVariable Long id, Model model){
        MusicoDTO musico = musicoService.listarPorId(id);
        if(musico != null){
            model.addAttribute("musico", musico);
            return ("detalhesMusico");
        }
        model.addAttribute("mensagem", "Músico não encontrado");
        return ("redirect:/musicos/ui/read");
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        MusicoDTO musico = musicoService.listarPorId(id);
        if (musico != null) {
            model.addAttribute("musico", musico);
            model.addAttribute("instrumentos", instrumentoService.listar());
            return "editarMusico";
        }
        return "redirect:/musicos/ui/read";
    }

    @PostMapping("/atualizar")
    public String atualizar(@ModelAttribute MusicoDTO musico) {
        musicoService.atualizarMusico(musico.getId(), musico); // passa o ID separadamente
        return "redirect:/musicos/ui/read";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Model model) {
        model.addAttribute("musico", new MusicoDTO());
        model.addAttribute("instrumentos", instrumentoService.listar());
        return "cadastrarMusico";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute MusicoDTO musico) {
        musicoService.saveMusico(musico);
        return "redirect:/musicos/ui/read";
    }
}
