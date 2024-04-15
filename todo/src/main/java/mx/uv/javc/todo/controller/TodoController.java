package mx.uv.javc.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import mx.uv.javc.todo.dto.TodoDTO;
import mx.uv.javc.todo.dto.createTodoDTO;
import mx.uv.javc.todo.service.TodoService;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    //Obtener todas las tareas
    @RequestMapping("/obtenerTodos")
    public List<TodoDTO> getAll(){
        return todoService.getAll();
    }

    //Crear una nueva tarea
    @RequestMapping("/crearTodo")
    public TodoDTO create(@Valid @RequestBody createTodoDTO data){
        return todoService.create(data);
    }
     
}
