package com.neverians.characters.service;

import com.neverians.characters.dto.CharactersDTO;
import com.neverians.characters.entities.Characters;
import com.neverians.characters.repository.CharactersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CharactersService {

    @Autowired
    private CharactersRepository charactersRepository;

    private final ModelMapper modelMapper;

    public CharactersService() {
        this.modelMapper = new ModelMapper();
    }

    public List<CharactersDTO> findAll() {
        List<Characters> result = charactersRepository.findAll();
        return result.stream().map(character -> modelMapper.map(character, CharactersDTO.class)).toList();
    }

    public CharactersDTO findById(Long id) {
        Characters result = charactersRepository.findById(id).orElseThrow(() -> new RuntimeException("Character not found"));
        return modelMapper.map(result, CharactersDTO.class);
    }

    public Characters createCharacters(CharactersDTO charactersDTO) {
        Characters characters = modelMapper.map(charactersDTO, Characters.class);
        return charactersRepository.save(characters);
    }

    public void deleteById(Long id) {
        charactersRepository.deleteById(id);
    }

    public CharactersDTO updateCharacters (Long id, CharactersDTO dto) {
        Characters entity = charactersRepository.findById(id).orElseThrow(() -> new RuntimeException("Character not found"));
        modelMapper.map(dto, entity);
        entity = charactersRepository.save(entity);
        return modelMapper.map(entity, CharactersDTO.class);
    }

}
