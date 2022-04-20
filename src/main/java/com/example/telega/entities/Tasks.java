package com.example.telega.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Класс задачи
 */
@Entity
@Table(name = "tasks_table")
@Data
@NoArgsConstructor
public class Tasks {
    /**
     * Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Заголовок
     */
    private String title;
    /**
     * Автор
     */
    private String author;
    /**
     * Текст
     */
    private String text;
}