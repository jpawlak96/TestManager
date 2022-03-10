package com.example.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TestManagerServiceTest {

    @InjectMocks
    private TestManagerService service;

    @Mock
    private TestEntityRepository repository;

    @Mock
    private TestEntityMapperImpl mapper;

    @Test
    void shouldFindAll() {
        // given
        var entity = new TestEntity();
        var entities = List.of(entity);
        var dto = new TestDto();

        when(repository.findAll()).thenReturn(entities);
        when(mapper.toDto(entity)).thenReturn(dto);

        // when
        var result = service.findAll();

        // then
        assertThat(result)
                .contains(dto)
                .hasSize(1);
    }


    @Test
    void shouldSave() {
        // given
        var sourceDto = new TestDto();
        var sourceEntity = new TestEntity();
        var resultEntity = new TestEntity();
        var resultDto = new TestDto();

        when(mapper.toEntity(sourceDto)).thenReturn(sourceEntity);
        when(repository.save(sourceEntity)).thenReturn(resultEntity);
        when(mapper.toDto(resultEntity)).thenReturn(resultDto);

        // when
        var result = service.save(sourceDto);

        // then
        assertThat(result).isEqualTo(resultDto);
    }


    @Test
    void shouldUpdateStatusById() {
        // given
        var id = 1L;
        var newStatus = TestStatus.UNDEFINED;
        var targetEntity = new TestEntity();
        var resultEntity = new TestEntity();
        var resultDto = new TestDto();

        when(repository.findById(id)).thenReturn(Optional.of(targetEntity));
        when(repository.save(targetEntity)).thenReturn(resultEntity);
        when(mapper.toDto(resultEntity)).thenReturn(resultDto);

        // when
        var result = service.updateStatusById(id, newStatus);

        // then
        assertThat(targetEntity.getStatus()).isEqualTo(newStatus);
        assertThat(result).isEqualTo(resultDto);
    }

    @Test
    void shouldThrownNotFoundExceptionOnWrongId() {
        // given
        var id = 1L;
        var newStatus = TestStatus.UNDEFINED;

        when(repository.findById(id)).thenReturn(Optional.empty());

        // when
        Throwable thrown = catchThrowable(() -> service.updateStatusById(id, newStatus));

        // then
        assertThat(thrown)
                .isInstanceOf(ResponseStatusException.class)
                .hasMessageContaining(HttpStatus.NOT_FOUND.toString());
    }
}
