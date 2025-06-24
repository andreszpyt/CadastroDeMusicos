package com.CadastroDeMusicos.Orquestra.Musicos;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicoService {
    private MusicoRepository musicoRepository;

    public MusicoService(MusicoRepository musicoRepository) {
        this.musicoRepository = musicoRepository;
    }

        public List<MusicoModel> listarMusicos(){
            return musicoRepository.findAll();
        }

}
