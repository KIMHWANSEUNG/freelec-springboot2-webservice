package com.khs.book.springboot.web.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우 필드들 (createdDate,modifiedDate)도 칼럼으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class) //BaseTimeEntity 클래스에 Auditing기능을 포함시킨다
public abstract class BaseTimeEntity {
    //Entity가 생성되어 저장될 때 시간이 자동 저장
    @CreatedDate
    private LocalDateTime createdDate;
    //조회한 Entity의 값을 변경할 때 시간이 자동 저장
    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
