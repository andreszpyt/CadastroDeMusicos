package com.CadastroDeMusicos.Orquestra.Instrumentos;

import com.CadastroDeMusicos.Orquestra.Musicos.MusicoDTO;
import com.CadastroDeMusicos.Orquestra.Musicos.MusicoModel;
import org.springframework.stereotype.Component;

@Component
public class InstrumentoMapper {
    public InstrumentoModel map(InstrumentoDTO instrumentoDTO){
        InstrumentoModel instrumentoModel = new InstrumentoModel();

        instrumentoModel.setId(instrumentoDTO.getId());
        instrumentoModel.setNome(instrumentoDTO.getNome());

        return instrumentoModel;
    }

    public InstrumentoDTO map(InstrumentoModel instrumentoModel){
        InstrumentoDTO instrumentoDTO = new InstrumentoDTO();

        instrumentoDTO.setId(instrumentoModel.getId());
        instrumentoDTO.setNome(instrumentoModel.getNome());

        return instrumentoDTO;
    }
}
