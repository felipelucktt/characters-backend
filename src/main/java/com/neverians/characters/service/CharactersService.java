package com.neverians.characters.service;

import com.neverians.characters.dto.CharactersDTO;
import com.neverians.characters.entities.Characters;
import com.neverians.characters.repository.CharactersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharactersService {

    @Autowired
    private CharactersRepository charactersRepository;

    public List<CharactersDTO> findAll() {
        List<Characters> result = charactersRepository.findAll();
        return result.stream().map(CharactersDTO::new).toList();
    }

}
