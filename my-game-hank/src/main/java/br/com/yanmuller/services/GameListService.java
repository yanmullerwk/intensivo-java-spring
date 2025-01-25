package br.com.yanmuller.services;

import br.com.yanmuller.dto.GameListDto;
import br.com.yanmuller.entities.GameList;
import br.com.yanmuller.projections.GameMinProjection;
import br.com.yanmuller.repositories.GameListRepository;
import br.com.yanmuller.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAll() {
        List<GameList> gameLists = gameListRepository.findAll();
        return gameLists.stream().map(x -> new GameListDto(x)).toList();
    }

     @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(),i);
        }
    }
}
