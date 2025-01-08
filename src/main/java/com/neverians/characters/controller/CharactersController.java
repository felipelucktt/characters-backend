package com.neverians.characters.controller;

import com.neverians.characters.dto.CharactersDTO;
import com.neverians.characters.service.CharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
