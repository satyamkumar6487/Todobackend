package Todo.todo.service;


import Todo.todo.entity.Todo;
import Todo.todo.repo.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository  todoRepository){

        this.todoRepository = todoRepository;
    }



    public List<Todo> getAllTodos(){
        return todoRepository.findAll();

    }
    public Optional<Todo> getTodoById(Long id){
        return todoRepository.findById(id);
    }


    public Todo createTodo(Todo todo){

        return todoRepository.save(todo);

    }

    public Todo updateTodo(Long id, Todo updateTodo){

        return todoRepository.findById(id) .map(todo -> {

            todo.setTitle(updateTodo.getTitle());
            todo.setDescription(updateTodo.getDescription());
            todo.setCompleted(updateTodo.isCompleted());
            return todoRepository.save(todo);

        }).orElseThrow(()-> new RuntimeException("Todo Not Found"));
    }


public void deleteTodo (Long id){

        if(todoRepository.existsById(id)){
            todoRepository.deleteById(id);
        } else {
            throw new RuntimeException("todo not found id:" + id);
        }

}

}
