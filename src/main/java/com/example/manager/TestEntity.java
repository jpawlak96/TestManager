package com.example.manager;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = TestEntity.TABLE_NAME)
public class TestEntity {

    public static final String TABLE_NAME = "TESTS";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private TestStatus status;
}
