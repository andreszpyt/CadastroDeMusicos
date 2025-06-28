package com.CadastroDeMusicos.Orquestra.Musicos;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicoService {
    private final MusicoRepository musicoRepository;

    public MusicoService(MusicoRepository musicoRepository) {
        this.musicoRepository = musicoRepository;
    }

        public List<MusicoModel> listarMusicos(){
            return musicoRepository.findAll();
        }

        public MusicoModel listarPorId(Long id){
            Optional<MusicoModel> musicoId = musicoRepository.findById(id);
            return musicoId.orElse(null);
        }

        public MusicoModel saveMusico(MusicoModel musico){
           return musicoRepository.save(musico);
        }

        public void removerMusico(Long id){
            musicoRepository.deleteById(id);
        }

        public MusicoModel atualizarMusico(Long id, MusicoModel musico){
            if(musicoRepository.existsById(id)){
                musico.setId(id);
                return musicoRepository.save(musico);
            }
            return null;
        }

}
