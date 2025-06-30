package com.CadastroDeMusicos.Orquestra.Musicos;

import org.springframework.stereotype.Component;

@Component
public class MusicoMapper {
    public MusicoModel map(MusicoDTO musicoDTO){
        MusicoModel musicoModel = new MusicoModel();

        musicoModel.setId(musicoDTO.getId());
        musicoModel.setNome(musicoDTO.getNome());
        musicoModel.setComum(musicoDTO.getComum());
        musicoModel.setIdade(musicoDTO.getIdade());
        musicoModel.setInstrumento(musicoDTO.getInstrumento());

        return musicoModel;
    }

    public MusicoDTO map(MusicoModel musicoModel){
        MusicoDTO musicoDTO = new MusicoDTO();

        musicoDTO.setId(musicoModel.getId());
        musicoDTO.setNome(musicoModel.getNome());
        musicoDTO.setComum(musicoModel.getComum());
        musicoDTO.setIdade(musicoModel.getIdade());
        musicoDTO.setInstrumento(musicoModel.getInstrumento());

        return musicoDTO;
    }
}
