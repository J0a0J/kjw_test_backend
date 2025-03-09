package com.example.test.board.model;

import com.example.test.comment.model.Comment;
import com.example.test.comment.model.CommentDto;
import lombok.Builder;
import lombok.Getter;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class BoardDto {

    @Getter
    public static class BoardRequest {
        private String title;
        private String content;
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
        private Long idx;
        private String title;
        private String writer;
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
        private Long idx;
        private String title;
        private String content;
        private String writer;
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
