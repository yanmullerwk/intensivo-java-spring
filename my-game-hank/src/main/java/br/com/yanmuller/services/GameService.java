package br.com.yanmuller.services;

import br.com.yanmuller.dto.GameMinDto;

import br.com.yanmuller.entities.Game;
import br.com.yanmuller.reposirories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDto> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDto(x)).toList();

    }
}
