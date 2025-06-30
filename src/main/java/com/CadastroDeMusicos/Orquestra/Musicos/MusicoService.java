package com.CadastroDeMusicos.Orquestra.Musicos;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MusicoService {
    private final MusicoRepository musicoRepository;
    private final MusicoMapper musicoMapper;

    public MusicoService(MusicoRepository musicoRepository, MusicoMapper musicoMapper) {
        this.musicoRepository = musicoRepository;
        this.musicoMapper = musicoMapper;
    }

    public List<MusicoDTO> listarMusicos(){
        List<MusicoModel> musicos = musicoRepository.findAll();
            return musicos.stream()
                    .map(musicoMapper::map)
                    .collect(Collectors.toList());
        }

    public MusicoDTO listarPorId(Long id) {
        return musicoRepository.findById(id)
                .map(musicoMapper::map)
                .orElse(null);
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
            Optional<MusicoModel> musicoExistente = musicoRepository.findById(id);
            if(musicoExistente.isPresent()){
                MusicoModel musicoModel = musicoMapper.map(musico);
                musicoModel.setId(id);
                musicoModel = musicoRepository.save(musicoModel);
                return musicoMapper.map(musicoModel);
            }
            return null;
        }

}
