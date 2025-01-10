package com.neverians.characters.controller;

import com.neverians.characters.dto.CharactersDTO;
import com.neverians.characters.entities.Characters;
import com.neverians.characters.service.CharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/characters")
public class CharactersController {

    @Autowired
    private CharactersService charactersService;

    @GetMapping
    public List<CharactersDTO> findAll() {
        return charactersService.findAll();
    }

    @GetMapping(value = "/{id}")
    public CharactersDTO findById(@PathVariable Long id) {
        return charactersService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Characters> saveCharacters(@RequestBody CharactersDTO charactersDTO) {
        Characters characters = charactersService.createCharacters(charactersDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(characters);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCharacters(@PathVariable Long id) {
        charactersService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public CharactersDTO updateCharacters(@PathVariable Long id, @RequestBody CharactersDTO dto) {
        return charactersService.updateCharacters(id, dto);
    }

}
