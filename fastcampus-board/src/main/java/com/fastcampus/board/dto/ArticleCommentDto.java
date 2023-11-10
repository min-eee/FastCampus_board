package com.fastcampus.board.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.fastcampus.board.domain.ArticleComment}
 */
public record ArticleCommentDto(
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy,
        String content
)  {
    public static ArticleCommentDto of(LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy, String content) {
       return new ArticleCommentDto(createdAt, createdBy, modifiedAt, modifiedBy, content);
    }

    public Long articleId() {
        return articleId();
    }

    public void parentCommentId() {

    }
}