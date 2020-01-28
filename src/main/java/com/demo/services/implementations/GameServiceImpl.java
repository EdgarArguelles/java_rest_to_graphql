package com.demo.services.implementations;

import com.demo.exceptions.DemoDontFoundException;
import com.demo.models.Game;
import com.demo.repositories.GameRepository;
import com.demo.services.GameService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLId;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@GraphQLApi
@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    @GraphQLQuery(name = "games", description = "Find all games")
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    @GraphQLQuery(name = "game", description = "Find a game by ID")
    public Game findById(@GraphQLId @GraphQLNonNull @GraphQLArgument(name = "id", description = "Game's ID") Long id) throws DemoDontFoundException {
        return gameRepository.findById(id).orElseThrow(() -> new DemoDontFoundException("Nothing with the ID '" + id + "'."));
    }
}