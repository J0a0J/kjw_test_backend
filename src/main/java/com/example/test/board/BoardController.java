package com.example.test.board;

import com.example.test.board.model.Board;
import com.example.test.board.model.BoardDto;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(
            summary = "게시글 등록",
            description = "새로운 게시글을 등록합니다."
    )
    public ResponseEntity<BoardDto.BoardListResponse> register(@RequestBody BoardDto.BoardRequest dto) {
        return boardService.register(dto);
    }

    @GetMapping("/list")
    @Operation(
            summary = "게시글 목록 조회",
            description = "모든 게시글 항목을 조회합니다."
    )
    public ResponseEntity<List<BoardDto.BoardListResponse>> list() {
        return boardService.list();
    }

    @GetMapping("/list/{idx}")
    @Operation(
            summary = "게시글 상세 조회",
            description = "특정 게시글의 상세 정보를 조회합니다. 'idx'는 게시글의 고유 ID입니다."
    )
    public ResponseEntity<BoardDto.BoardDetailResponse> detail(@PathVariable Long idx) {
        System.out.println("Received idx: " + idx);

        return boardService.findByIdx(idx);
    }
}
