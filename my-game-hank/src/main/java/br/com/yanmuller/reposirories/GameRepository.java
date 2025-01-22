package br.com.yanmuller.reposirories;

import br.com.yanmuller.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
