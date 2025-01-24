package br.com.yanmuller.repositories;

import br.com.yanmuller.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList,Long> {
}
