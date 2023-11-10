package com.fastcampus.board.service;

import com.fastcampus.board.dto.ArticleCommentDto;
import com.fastcampus.board.repository.ArticleCommentRepository;
import com.fastcampus.board.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleCommentService {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    @Transactional(readOnly = true)
    public List<ArticleCommentDto> searchArticleComments(Long articleId) {
        return List.of();
    }

    public void saveArticleComment(ArticleCommentDto dto) {
    }

    public void deleteArticleComment(Long articleCommentId, String userId) {
    }
}
