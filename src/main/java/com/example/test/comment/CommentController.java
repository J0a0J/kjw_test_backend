package com.example.test.comment;

import com.example.test.comment.model.Comment;
import com.example.test.comment.model.CommentDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<CommentDto.CommentResponse> register(@RequestBody CommentDto.CommentRequest dto) {
        return commentService.register(dto);
    }
}
