package com.CadastroDeMusicos.Orquestra.Instrumentos;

import com.CadastroDeMusicos.Orquestra.Musicos.MusicoModel;
import com.CadastroDeMusicos.Orquestra.Musicos.MusicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InstrumentoService {
    private final InstrumentoRepository instrumentoRepository;
    private final InstrumentoMapper instrumentoMapper;

    public InstrumentoService(InstrumentoRepository instrumentoRepository, InstrumentoMapper instrumentoMapper) {
        this.instrumentoRepository = instrumentoRepository;
        this.instrumentoMapper = instrumentoMapper;
    }

    //GetAll
    public List<InstrumentoDTO> listar() {
        List<InstrumentoModel> instrumentos = instrumentoRepository.findAll();
        return instrumentos.stream()
                .map(instrumentoMapper::map)
                .collect(Collectors.toList());
    }

    //GetByID
    public InstrumentoDTO listarPorID(Long id){
        return instrumentoRepository.findById(id)
                .map(instrumentoMapper::map)
                .orElse(null);
    }

    //SaveInstrumento
    public InstrumentoDTO save(InstrumentoDTO instrumentoDTO){
        InstrumentoModel instrumento = instrumentoMapper.map(instrumentoDTO);
        instrumento = instrumentoRepository.save(instrumento);
        return instrumentoMapper.map(instrumento);
    }

    //delete
    public void delete(Long id){
        instrumentoRepository.deleteById(id);

    }

    //Atualizar
    public InstrumentoDTO atualizarInstrumento(Long id, InstrumentoDTO instrumentoDTO){
        Optional<InstrumentoModel> instrumentoExistente = instrumentoRepository.findById(id);
        if(instrumentoExistente.isPresent()){
            InstrumentoModel instrumentoModel = instrumentoMapper.map(instrumentoDTO);
            instrumentoModel.setId(id);
            instrumentoModel = instrumentoRepository.save(instrumentoModel);
            return instrumentoMapper.map(instrumentoModel);
        }
        return null;
    }


}