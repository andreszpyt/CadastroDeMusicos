package com.CadastroDeMusicos.Orquestra.Instrumentos;

import com.CadastroDeMusicos.Orquestra.Musicos.MusicoModel;
import com.CadastroDeMusicos.Orquestra.Musicos.MusicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class InstrumentoService {
    private InstrumentoRepository instrumentoRepository;

    public InstrumentoService(InstrumentoRepository instrumentoRepository) {
        this.instrumentoRepository = instrumentoRepository;
    }

    //GetAll
    public List<InstrumentoModel> listar() {
        return instrumentoRepository.findAll();
    }

    //GetByID
    public InstrumentoModel listarPorID(Long id){
        Optional<InstrumentoModel> instrumentoID = instrumentoRepository.findById(id);
        return instrumentoID.orElse(null);
    }

    //SaveInstrumento
    public void save(InstrumentoModel instrumento){
        instrumentoRepository.save(instrumento);
    }

    //delete
    public void delete(Long id){
        instrumentoRepository.deleteById(id);

    }

    //Atualizar
    public InstrumentoModel atualizarInstrumento(Long id, InstrumentoModel instrumento){
        if(instrumentoRepository.findById(id)){
            instrumento.setId(id);
            return instrumentoRepository.save(instrumento);
        }
        return null;
    }


}