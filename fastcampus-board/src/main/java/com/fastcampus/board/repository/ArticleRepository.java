package com.fastcampus.board.repository;

import com.fastcampus.board.domain.Article;
import com.fastcampus.board.domain.QArticle;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.sql.DatabaseMetaData;

@RepositoryRestResource
public interface ArticleRepository extends
        JpaRepository<Article, Long>,
        QuerydslPredicateExecutor<Article>,
// 기본적으로 엔티티 안에 있는 기본 검색기능을 추가해준다.
        QuerydslBinderCustomizer<QArticle> {
    @Override
    default void customize(QuerydslBindings bindings, QArticle root) {
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.title, root.content , root.hashtag, root.createdAt , root.createdBy);
        bindings.bind(root.title).first(StringExpression::containsIgnoreCase); // like '%${v}%'
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase); // like '%${v}%'
        bindings.bind(root.hashtag).first(StringExpression::containsIgnoreCase); // like '%${v}%'
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
        bindings.bind(root.createdBy).first(StringExpression::eq);
    }
}