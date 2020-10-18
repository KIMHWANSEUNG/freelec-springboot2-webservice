package com.khs.book.springboot.web.domain.posts;

import com.khs.book.springboot.web.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//** 중요 **
//Entitiy에는 Setter메소드를 만들지 않는다 대신 해당 필드 값의 변경이 필요하면 명확히 그 목적과 의도를
// 나타낼 수 있는 메소드를 추가, DB에는 @Builder를 통해 제공되는 빌더 클래스를 사용에 DB에 값을 넣어준다

@Getter //클래스내에 필드 getter 메소드 자동 생성
@NoArgsConstructor //기본 생성자 자동 추가 , public Posts(){}와 같은 효과
@Entity // 테이블과 링크될 클래스임을 나타냄, 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블이름을 매칭
public class Posts extends BaseTimeEntity {
    @Id  // 해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // PK생성 규칙을 나타냄, 스프링 부트 2.0에서는 GenerationType.IDENTITY를 추가해야만 AutoIncreament가 된다
    private Long id;

    //테이블 칼럼, 굳이 선언 X 해당클래스 필드는 모두 칼럼이 된다
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
