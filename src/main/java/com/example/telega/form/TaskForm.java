package com.example.telega.form;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Форма добавления задачи
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskForm {
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