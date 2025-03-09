package com.example.test.comment.model;

import com.example.test.board.model.Board;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

public class CommentDto {

    @Getter
    public static class CommentRequest {

        @Schema(description = "댓글 내용")
        private String content;

        @Schema(description = "댓글 작성자")
        private String writer;

        @Schema(description = "게시글 정보")
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

        @Schema(description = "댓글 고유 ID")
        private Long idx;

        @Schema(description = "댓글 내용")
        private String content;

        @Schema(description = "댓글 작성자")
        private String writer;

        @Schema(description = "게시글 정보")
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
