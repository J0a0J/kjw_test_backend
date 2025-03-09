package com.example.test.board;

import com.example.test.board.model.Board;
import com.example.test.board.model.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public ResponseEntity<BoardDto.BoardListResponse> register(BoardDto.BoardRequest dto) {
        Board board = boardRepository.save(dto.toEntity());

        return ResponseEntity.ok(BoardDto.BoardListResponse.from(board));
    }

    public ResponseEntity<List<BoardDto.BoardListResponse>> list() {
        List<BoardDto.BoardListResponse> boardResponseList = boardRepository.findAll()
                .stream()
                .map(BoardDto.BoardListResponse::from)
                .toList();

        return ResponseEntity.ok(boardResponseList);
    }

    public ResponseEntity<BoardDto.BoardDetailResponse> findByIdx(Long idx) {
        Board board = boardRepository.findByIdx(idx);
        
        return ResponseEntity.ok(BoardDto.BoardDetailResponse.from(board));
    }
}
