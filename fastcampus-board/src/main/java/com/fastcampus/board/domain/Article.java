package com.fastcampus.board.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
                 @Index(columnList = "title")
                ,@Index(columnList = "hashtag")
                ,@Index(columnList = "createdAt")
                ,@Index(columnList = "createdBy")
})
@Entity
public class Article extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(optional = false)
    private UserAccount userAccount;

    @Setter
    @Column(nullable = false)
    private String title; //제목

    @Setter
    @Column(nullable = false, length = 10000)
    private String content; // 내용

    @Setter
    private String hashtag; // 해시태그

    @ToString.Exclude
    // circular referencing 이슈가 생길 수 있음. 순환참조때문에 메모리의 과부하로 서버 꺼질 수 있음. ToString 둘 중 하나는 끊어줘야함.
    @OrderBy("createdAt DESC")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();


 //수정자

    protected Article(){

    }

    private Article(UserAccount userAccount, String title, String content, String hashtag){
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    public static Article of(UserAccount userAccount, String title, String content, String hashtag){

        return new Article(userAccount, title, content, hashtag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return id != null && id.equals(article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
