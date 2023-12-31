package com.fastcampus.board.Controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Disabled("Spring Data REST 통합테스트는 불필요 하므로 제외시킴")
@DisplayName("Data REST - API 테스트")
@Transactional
// 이 내용은 integration 테스트이므로 이 API가 실행한 결과가 리포지토리까지 저부 다 실행을 시켜서
// Hibernat Query 문까지 나온다. 어떻게 보면 DB에 영향을 주는 테스트가 되어버림.
//Transactional 을 넣어줌 테스트에서 동작하는 transactional의 기본 동작은 rollback 이다.
// 모든 Data List 테스트 밑에 각각의 유닛 테스트 메소드들은 롤백상태로 트랜잭션이 묶이게 된다.
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestTest {


    // 평범한 테스트 라면 integrationTest 의 integration cycle 을 끊을 수 있음.
    // 예를 들어, 지금 이건 Spring Boot 테스트 이기는 하지만 MocMvc에서 호출할 것으로 예상되는 레포지토리가 있다.
    // article repository와 articleComment repository를 Mocking 하여 중간에 repository까지 접근하는 코드의 흐름을 끊을 수 있다.
    // Spring DataList 가 아니었다면 가능하다.
    private final MockMvc mvc;

    public DataRestTest(@Autowired MockMvc mvc){
        this.mvc = mvc;

    }

    @DisplayName("[api] 게시글 리스트 조회")
    @Test
    void  givenNothing_whenRequestingArticles_thenReturnsArticlesJsonResponse() throws Exception {
        //Given

        //When&Then
        mvc.perform(get("/api/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] 게시글 단건 조회")
    @Test
    void  givenNothing_whenRequestingArticles_thenReturnsArticleJsonResponse() throws Exception {
        //Given

        //When&Then
        mvc.perform(get("/api/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] 게시글 -> 댓글 리스트 조회")
    @Test
    void  givenNothing_whenRequestingArticleCommentsFromArticle_thenReturnsArticleCommentsJsonResponse() throws Exception {
        //Given

        //When&Then
        mvc.perform(get("/api/articles/1/articleComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] 댓글 리스트 조회")
    @Test
    void  givenNothing_whenRequestingArticleComments_thenReturnsArticleCommentsJsonResponse() throws Exception {
        //Given

        //When&Then
        mvc.perform(get("/api/articleComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] 댓글 단건 조회")
    @Test
    void  givenNothing_whenRequestingArticleComment_thenReturnsArticleCommentJsonResponse() throws Exception {
        //Given

        //When&Then
        mvc.perform(get("/api/articleComments/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

}
