package com.khs.book.springboot;

import com.khs.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)// Junit과 스프링 부트 테스트 사이의 연결자 역할
@WebMvcTest(controllers = HelloController.class)// 여러 스프링 어노테이션 중 web에 집중 할 수 있는 어노테이션
public class HelloControllerTest {
    //빈주입 하는 어노테이션
    @Autowired
    private MockMvc mvc;//웹 API를 테스트할 때 사용한다 , 스프링 MVC 테스트의 시작점 , 이클래스를 통해 HTTP GET, POST 등에
    // 대한 API를 테스트


    @Test
    public void hello가_리턴된다() throws Exception{
        String hello="hello";

        mvc.perform(get("/hello")) //HTTP GET요청
                .andExpect(status().isOk())     //mvc.perform의 결과를 검증 ,HTTP header의 Status를 검증, 우리가 흔히 알고있는 200,404,500등의 에러를 검증
                .andExpect(content().string(hello)); // .. /응답 본문의 내용을 검증, Controller에서 hello를 리턴하기 때문에 이값이 맞는지 검증한다!
    }


}
