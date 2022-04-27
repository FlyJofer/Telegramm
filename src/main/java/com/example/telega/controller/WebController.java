package com.example.telega.controller;

import com.example.telega.entities.Tasks;
import com.example.telega.form.TaskForm;
import com.example.telega.service.TasksService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Контроллер веб-страниц
 */

@Controller
@Log
public class WebController {
    /**
     * Сообщение на главной странице
     */
    private static final String MAIN_PAGE_MESSAGE = "Это главная страница";
    /**
     * Заголовок главной страницы
     */
    private static final String MAIN_PAGE_TITLE = "Здравствуйте!";
    private static final Object LIST_PAGE_MESSAGE = "Это список задач";
    private static final String LIST_PAGE_TEXT = "Текст";
    private static final String LIST_PAGE_AUTHOR = "Автор";
    private static final String LIST_PAGE_TITLE = "Список задач";

    /**
     * Главная страница доступна по адресам `/` и `/index`,
     *
     * @param model модель
     * @return возвращает путь к шаблону
     */
    private final TasksService tasksService;
    /**
     * Конструктор контроллера задач
     *
     * @param tasksService сервис задач
     */
    @Autowired
    public WebController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    /**
     * Cтраница списка задач доступна по адресу `taskList`,
     *
     * @param model - модель
     * @return - возвращает путь к шаблону
     */
    @GetMapping(value = {"/taskList"})
    public String tasksList(Model model) {
        // читаем все задачи
        final List<Tasks> tasks = tasksService.readAll();
        // добавляем их в список
        model.addAttribute("tasks", tasks);
        // задаём сообщение
        model.addAttribute("message", LIST_PAGE_MESSAGE);
        // задаём заголовок
        model.addAttribute("title", LIST_PAGE_TITLE);
        // добавляем фому
         model.addAttribute("text", LIST_PAGE_TEXT);
         model.addAttribute("author", LIST_PAGE_AUTHOR);
        TaskForm taskForm = new TaskForm();
        model.addAttribute("taskForm", taskForm);
        return "taskList";
    }

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        // задаём сообщение
        model.addAttribute("message", MAIN_PAGE_MESSAGE);
        // задаём заголовок
        model.addAttribute("title", MAIN_PAGE_TITLE);
        // возвращаем шаблон главной страницы
        return "index";
    }
}