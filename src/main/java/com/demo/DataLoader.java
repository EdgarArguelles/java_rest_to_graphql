package com.demo;

import com.demo.models.Category;
import com.demo.models.Game;
import com.demo.models.Store;
import com.demo.repositories.CategoryRepository;
import com.demo.repositories.GameRepository;
import com.demo.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Populates data tables at application start
@Component
public class DataLoader {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private StoreRepository storeRepository;

    @PostConstruct
    private void setupDatabase() {
        try {
            if (gameRepository.count() == 0) {
                insertData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertData() {
        List<Category> categories = List.of(
                new Category("A", "Game suitable for young adventurers", 5, 1),
                new Category("B", "Game suitable for the whole family", 10, 1),
                new Category("C", "Very violent game, kill, kill, kill, kill", 18, 1),
                new Category("R", "This game will make you a very dangerous person", 30, 1),
                new Category("XXX", "Only for real gamers!!!", 15, 0)
        );
        categoryRepository.saveAll(categories);

        List<Game> games = List.of(
                new Game("Resisent Evil", 450.85, null, 4561, categories.get(2)),
                new Game("Resisent Evil 2", 1450.85, "The best Resisent Evil", 8000, categories.get(2)),
                new Game("Resisent Evil 3", 478.0, "NEMESIS", 1234, categories.get(2)),
                new Game("Hello Kitty", 20.99, null, 78124, categories.get(4)),
                new Game("Fortnite", 999.99, null, 0, categories.get(0)),
                new Game("Assassin's Creed", 888.88, null, 7451, categories.get(3)),
                new Game("Tetris", 877.77, null, 200, categories.get(3)),
                new Game("Batman Arkham Knight", 4758.0, null, 350, categories.get(1))
        );
        gameRepository.saveAll(games);

        List<Store> stores = List.of(
                new Store("Game Planet", "Fake St. #123", "458-547-2454", 784478148.45, "Under the mattress", new HashSet<>(games)),
                new Store("Edgar Games", "Sorry I can't tell you", "478-457-1124", 5004875.65, "In a very save place", Set.of(games.get(2), games.get(3), games.get(6))),
                new Store("Broken Store", "My parents' basement", "784-458-1124", 0.1, "In my wallet", Collections.emptySet()),
                new Store("Unosquare Games", "Main Square #784", "128-789-4554", 57504878.45, "In leon office", new HashSet<>(games))
        );
        storeRepository.saveAll(stores);
    }
}