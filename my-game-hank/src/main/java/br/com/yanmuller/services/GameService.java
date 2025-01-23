package br.com.yanmuller.services;

import br.com.yanmuller.dto.GameDto;
import br.com.yanmuller.dto.GameMinDto;

import br.com.yanmuller.entities.Game;
import br.com.yanmuller.reposirories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)//Do Spring não do jackarta!!
    public List<GameMinDto> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDto(x)).toList();
    }

    @Transactional(readOnly = true)
    public GameDto findById(Long id) {
        Game result = gameRepository.findById(id).get();//fazer um tratamento de exeção
        return new GameDto(result);
    }
}
