package com.fastcampus.board.repository;

import com.fastcampus.board.config.JpaConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.*;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
// 테스트가 JpaConfig를 제대로 읽지 못한다. 직접 만들었기 때문에 import 해줘야 Auditing을 할 수 있음.
@DataJpaTest
class JpaRepositoryTest {
//JUnit5를 사용하면 테스트에서도 생성자 주입 패턴을 사용할 수 있음. DataJpaTest 에 들어가면 모든 slice 테스트가
// 가지고 있는 extend with spring extension 이 있다. 이 표현은 Junit5를 위해 만들어져 있는 것이고,
// Junit4를 쓰고 계신 경우에는 runmit으로 바꿔서 써주어야함.


    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(
            @Autowired ArticleRepository articleRepository,
            @Autowired ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @DisplayName("select test")
    @Test
    void  givenTestData_whenSelecting_thenWorksFine(){

        //Given

        //When

        //Then

    }


}