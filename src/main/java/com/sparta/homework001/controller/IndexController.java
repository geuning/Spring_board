package com.sparta.homework001.controller;

import com.sparta.homework001.domain.Board;
import com.sparta.homework001.domain.BoardRepository;
import com.sparta.homework001.domain.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final BoardRepository boardRepository;

    @GetMapping("/")
    public String listBoards(Model model) {
        List<Board> listBoards = boardRepository.findAllByOrderByModifiedAtDesc();
        model.addAttribute("boardList", listBoards);
        return "list";
    }

    @GetMapping("/write")
    public String writeBoard() {
        return "write";
    }

    @GetMapping("/detail/{id}")
    public String detailBoard(@PathVariable Long id, Model model) {
        Board detailBoard = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("글이 존재하지 않습니다.")
        );
        model.addAttribute("boardDetail", detailBoard);
        return "detail";

    }

}
