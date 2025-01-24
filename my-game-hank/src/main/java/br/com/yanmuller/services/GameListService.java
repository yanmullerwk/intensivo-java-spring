package br.com.yanmuller.services;

import br.com.yanmuller.dto.GameListDto;
import br.com.yanmuller.entities.GameList;
import br.com.yanmuller.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAll() {
        List<GameList> gameLists = gameListRepository.findAll();
        return gameLists.stream().map(x -> new GameListDto(x)).toList();
    }
}
