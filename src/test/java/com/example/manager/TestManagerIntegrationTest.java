package com.example.manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static com.example.manager.TestStatus.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class TestManagerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TestEntityRepository repository;

    @Test
    void shouldFindThreeDefaultDTOs() throws Exception {
        MvcResult result = mockMvc.perform(get("/api")).andReturn();

        String contentJson = result.getResponse().getContentAsString();
        List<TestDto> content = Arrays.asList(objectMapper.readValue(contentJson, TestDto[].class));

        TestDto testDto1 = TestDto.builder().id(1L).name("My test 1").status(UNDEFINED).build();
        TestDto testDto2 = TestDto.builder().id(2L).name("My test 2").status(FAILED).build();
        TestDto testDto3 = TestDto.builder().id(3L).name("My test 3").status(PASSED).build();

        assertThat(content)
                .hasSize(3)
                .contains(testDto1, testDto2, testDto3);
    }


    @Test
    void shouldSaveNewTestAndReturnDTOWithId() throws Exception {
        TestDto dto = TestDto.builder().name("IntegrationTest").status(PASSED).build();

        MvcResult result = mockMvc.perform(post("/api")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(dto)))
                .andReturn();

        String contentJson = result.getResponse().getContentAsString();
        TestDto content = objectMapper.readValue(contentJson, TestDto.class);

        TestEntity entity = repository.findById(content.getId()).orElse(null);

        assertThat(content)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(dto);

        assertThat(content)
                .usingRecursiveComparison()
                .comparingOnlyFields("id", "name", "status")
                .isEqualTo(entity);

        assertThat(content.getId())
                .isNotNull();
    }

}
