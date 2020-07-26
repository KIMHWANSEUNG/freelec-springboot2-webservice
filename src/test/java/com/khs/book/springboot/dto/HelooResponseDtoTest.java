package com.khs.book.springboot.dto;

import com.khs.book.springboot.web.dto.HelloResponseDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
// assertJ의 장점 CoreMathvers와 달리 추가적으로 라이브러리 필요x, assertJ는 Junit에서 자동으로 라이브러리 등록


//*********이슈 사항**********
// intellij utilmate는 설치시 디폴트 gradle버전이 5.0으로 에러가남 따라서 그래들 버전을 다운그레이드함
// 터미널에 gradlew wrapper --gradle-version 4.10.2을 치고 다운그레이드 진행  => 테스트 성공
public class HelooResponseDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto =new HelloResponseDto(name,amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}
