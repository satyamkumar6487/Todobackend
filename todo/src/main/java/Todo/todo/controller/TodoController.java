package Todo.todo.controller;

import Todo.todo.entity.Todo;
import Todo.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:5173")
public class TodoController {


    private final TodoService todoService;

    public TodoController(TodoService todoService){

        this.todoService = todoService;
    }



    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();

    }


    @GetMapping("/{id}")

    public Todo getTodoById(@PathVariable Long id){
        return todoService.getTodoById(id)
                .orElseThrow(()-> new RuntimeException("Todo not Found"));

    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo){
        return todoService.createTodo(todo);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo){
        return todoService.updateTodo(id, todo);
    }

@DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);

}



}
