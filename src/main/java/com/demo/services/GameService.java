package com.demo.services;

import com.demo.exceptions.DemoDontFoundException;
import com.demo.models.Game;

import java.util.List;

public interface GameService {

    /**
     * Retrieves all games.
     *
     * @return list of all games.
     */
    List<Game> findAll();

    /**
     * Retrieves a Game by its id.
     *
     * @param id value to search.
     * @return the Game with the given id.
     * @throws DemoDontFoundException if Game not found.
     */
    Game findById(Long id) throws DemoDontFoundException;
}