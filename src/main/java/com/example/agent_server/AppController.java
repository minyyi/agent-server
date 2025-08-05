package com.example.agent_server;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class AppController {
    
    private BoardRepository boardRepository;

    public AppController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @GetMapping("/home")
    public String home() {
        return "agent Action!!!";
    }
    
    @GetMapping("/boards")
    public ResponseEntity<List<Board>> getBoards() {
        Board board = new Board("agent", "agent content");
        boardRepository.save(board);

        List<Board> boards = boardRepository.findAll();
        return  ResponseEntity.ok().body(boards);
    }
    
}

