package br.com.yanmuller.controllers;

import br.com.yanmuller.dto.GameDto;
import br.com.yanmuller.dto.GameListDto;
import br.com.yanmuller.dto.GameMinDto;
import br.com.yanmuller.dto.ReplacementDto;
import br.com.yanmuller.services.GameListService;
import br.com.yanmuller.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDto> getGameLists() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDto> findByList(@PathVariable("listId") Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable("listId") Long listId, @RequestBody ReplacementDto body) {
       gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }



}
