package com.example.test.board;

import com.example.test.board.model.Board;
import com.example.test.board.model.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@AllArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/register")
    public ResponseEntity<BoardDto.BoardListResponse> register(@RequestBody BoardDto.BoardRequest dto) {
        return boardService.register(dto);
    }

    @GetMapping("/list")
    public ResponseEntity<List<BoardDto.BoardListResponse>> list() {
        return boardService.list();
    }

    @GetMapping("/list/{idx}")
    public ResponseEntity<BoardDto.BoardDetailResponse> detail(@PathVariable Long idx) {
        System.out.println("Received idx: " + idx);

        return boardService.findByIdx(idx);
    }
}
