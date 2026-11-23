package me.kimnayun.springboot;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest // 테스트용 애플리케이션 컨텍스트 생성
@AutoConfigureMockMvc // MockMvc 생성 및 자동 구성
class TestControllerTest {
    @BeforeEach
    public void setUp() {
        memberRepository.deleteAll();
    }

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach // 테스트 실행 전 실행하는 메서드
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @AfterEach // 테스트 실행 후 실행하는 메서드
    public void cleanUp() {
        memberRepository.deleteAll();
    }

    @DisplayName("getAllMembers: 아티클 조회에 성공한다.")
    @Test
    public void getAllMembers() throws Exception {
        // given: 멤버 저장
        final String url = "/test";
        Member savedMember = memberRepository.save(new Member("홍길동"));

        // when: 멤버 리스트를 조회하는 API 호출
        final ResultActions result = mockMvc.perform(get(url) // 1. perform() 메서드는 요청을 전송하는 역할
                .accept(MediaType.APPLICATION_JSON) // 2. accep() 메서드는 요청을 보낼 때 무슨 타입으로 응답을 받을지 결정하는 메서드
        );

        // then: 응답 코드가 200이고, 반환받은 값 중에 0번째 요소의 id와 name이 저장된 값과 같은지 확인
        result.andExpect(status().isOk()) // 3. andExcept() 메서드는 응답을 검증
                // 4. 응답의 0번째 값이 DB에 저장한 값과 같은지 확인
                // jsonPath("$[0].${필드명}")은 json 응답값의 값을 가져오는 역할의 메서드
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
    }
}