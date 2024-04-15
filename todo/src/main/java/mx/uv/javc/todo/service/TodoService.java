package mx.uv.javc.todo.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import mx.uv.javc.todo.dto.TodoDTO;
import mx.uv.javc.todo.dto.createTodoDTO;
import mx.uv.javc.todo.model.Todo;

@RestController
public class TodoService {

    private List<Todo> todos;
    private long currentID = 1;

    public TodoService() {
        todos = new LinkedList<>();
        todos.add(new Todo(1, "Primera tarea", "Proyecto Spring", false));
    }

    public List<TodoDTO> getAll(){
        List<TodoDTO> data = new LinkedList<>();

        for (Todo model : todos) {
            TodoDTO dto = new TodoDTO();
            dto.setId(model.getId());
            dto.setTitle(model.getTitle());
            dto.setDescription(model.getDescription());
            dto.setCompleted(model.isCompleted());
            data.add(dto);
        }
        return data;
    }

    public TodoDTO create(@Valid @RequestBody createTodoDTO data){

        //Conversión de DTO a model(model es como almaceno los datos)
        //DTO es como los recibo y como los regreso

        Todo model = new Todo(++currentID, data.getTitle(), data.getDescription(), false);
        todos.add(model);

        TodoDTO dto = new TodoDTO();
        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setDescription(model.getDescription());
        dto.setCompleted(model.isCompleted());

        return dto;
    }
    
}
