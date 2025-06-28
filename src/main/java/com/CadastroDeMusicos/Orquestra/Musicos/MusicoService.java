package com.CadastroDeMusicos.Orquestra.Musicos;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicoService {
    private final MusicoRepository musicoRepository;
    private final MusicoMapper musicoMapper;

    public MusicoService(MusicoRepository musicoRepository, MusicoMapper musicoMapper) {
        this.musicoRepository = musicoRepository;
        this.musicoMapper = musicoMapper;
    }

    public List<MusicoModel> listarMusicos(){
            return musicoRepository.findAll();
        }

        public MusicoModel listarPorId(Long id){
            Optional<MusicoModel> musicoId = musicoRepository.findById(id);
            return musicoId.orElse(null);
        }

        public MusicoDTO saveMusico(MusicoDTO dto){
            MusicoModel musico = musicoMapper.map(dto);
            MusicoModel saved = musicoRepository.save(musico);
           return musicoMapper.map(saved);
        }

        public void removerMusico(Long id){
            musicoRepository.deleteById(id);
        }

        public MusicoDTO atualizarMusico(Long id, MusicoDTO musico){
            if(musicoRepository.existsById(id)){
                MusicoModel model = musicoMapper.map(musico);
                MusicoModel update = musicoRepository.save(model);
                return musicoMapper.map(update);
            }
            return null;
        }

}
