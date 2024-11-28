package com.example.demo;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class Controller {
    private static final Random RANDOM = new Random();
    final ModelRepo repo;

    Integer pageSize = 20;

    public Controller(ModelRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/users")
    public List<Model> index() {
        int usersCount = 100_000;
        int maxPage = usersCount / pageSize;
        int pageIndex = RANDOM.nextInt(maxPage);
        return repo.findAll(Pageable.ofSize(pageSize).withPage(pageIndex)).getContent();
    }
}
