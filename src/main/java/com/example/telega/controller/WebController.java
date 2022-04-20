package com.example.telega.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    /**
     * Главная страница доступна по адресам `/` и `/index`,
     *
     * @param model модель
     * @return возвращает путь к шаблону
     */
    private final TasksService tasksService;
    @Autowired
    public WebController(TasksService tasksService) {
        this.tasksService = tasksService;
    }
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