package br.com.yanmuller.controllers;

import br.com.yanmuller.dto.GameDto;
import br.com.yanmuller.dto.GameMinDto;
import br.com.yanmuller.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDto> findAll() {
        return gameService.findAll();
    }

    @GetMapping(value = "/{id}")
    public GameDto findById(@PathVariable("id") Long id) {
        return gameService.findById(id);
    }

}
