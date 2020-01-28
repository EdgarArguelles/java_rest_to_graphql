package com.demo.services.implementations;

import com.demo.exceptions.DemoDontFoundException;
import com.demo.models.Game;
import com.demo.repositories.GameRepository;
import com.demo.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public Game findById(Long id) throws DemoDontFoundException {
        return gameRepository.findById(id).orElseThrow(() -> new DemoDontFoundException("Nothing with the ID '" + id + "'."));
    }
}