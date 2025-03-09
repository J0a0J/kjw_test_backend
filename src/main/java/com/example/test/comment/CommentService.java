package com.example.test.comment;

import com.example.test.board.model.BoardDto;
import com.example.test.comment.model.Comment;
import com.example.test.comment.model.CommentDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public ResponseEntity<CommentDto.CommentResponse> register(CommentDto.CommentRequest dto) {
        Comment comment = commentRepository.save(dto.toEntity());

        return ResponseEntity.ok(CommentDto.CommentResponse.from(comment));
    }
}
