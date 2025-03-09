package com.example.test.comment.model;

import com.example.test.board.model.Board;
import lombok.Builder;
import lombok.Getter;

public class CommentDto {

    @Getter
    public static class CommentRequest {
        private String content;
        private String writer;
        private Board board;

        public Comment toEntity() {
            return Comment.builder()
                    .content(content)
                    .writer(writer)
                    .board(board)
                    .build();
        }
    }

    @Getter
    @Builder
    public static class CommentResponse {
        private Long idx;
        private String content;
        private String writer;
        private Board board;

        public static CommentResponse from(Comment comment) {
            return CommentResponse.builder()
                    .idx(comment.getIdx())
                    .content(comment.getContent())
                    .writer(comment.getWriter())
                    .board(comment.getBoard())
                    .build();
        }
    }
}
