package com.example.test.board.model;

import com.example.test.comment.model.Comment;
import com.example.test.comment.model.CommentDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class BoardDto {

    @Getter
    public static class BoardRequest {

        @Schema(description = "게시글 제목")
        private String title;

        @Schema(description = "게시글 내용")
        private String content;

        @Schema(description = "게시글 작성자")
        private String writer;

        public Board toEntity() {
            return Board.builder()
                    .title(title)
                    .content(content)
                    .writer(writer)
                    .build();
        }
    }

    /** 📌 목록 조회용 DTO (댓글 리스트 X, 댓글 개수만 포함) */
    @Getter
    @Builder
    public static class BoardListResponse {

        @Schema(description = "게시글 고유 ID")
        private Long idx;

        @Schema(description = "게시글 제목")
        private String title;

        @Schema(description = "게시글 작성자")
        private String writer;

        @Schema(description = "댓글 개수")
        private int commentCount;

        public static BoardListResponse from(Board board) {
            return BoardListResponse.builder()
                    .idx(board.getIdx())
                    .title(board.getTitle())
                    .writer(board.getWriter())
                    .commentCount(board.getCommentList() == null ? 0 : board.getCommentList().size())
                    .build();
        }
    }

    /** 📌 상세 조회용 DTO (댓글 리스트 포함) */
    @Getter
    @Builder
    public static class BoardDetailResponse {

        @Schema(description = "게시글 고유 ID")
        private Long idx;

        @Schema(description = "게시글 제목")
        private String title;

        @Schema(description = "게시글 내용")
        private String content;

        @Schema(description = "게시글 작성자")
        private String writer;

        @Schema(description = "댓글 리스트")
        private List<CommentDto.CommentResponse> commentList;

        public static BoardDetailResponse from(Board board) {
            return BoardDetailResponse.builder()
                    .idx(board.getIdx())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .commentList(board.getCommentList().stream()
                            .map(CommentDto.CommentResponse::from)
                            .toList())
                    .build();
        }
    }

}
