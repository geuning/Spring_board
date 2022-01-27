package com.sparta.homework001.controller;

import com.sparta.homework001.domain.Board;
import com.sparta.homework001.domain.BoardRepository;
import com.sparta.homework001.domain.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardRepository boardRepository;
    // private final BoardService boardService;
//    @ResponseBody
    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        return  boardRepository.save(board);
    }

    @GetMapping("/api/boards")
    public List<Board> getBoards() {
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

//    @GetMapping("/api/boards/{id}")
//    public Long detailBoard(@PathVariable Long id){
//        boardRepository.findAllById(id);
//        return id
//    }
    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ



}
