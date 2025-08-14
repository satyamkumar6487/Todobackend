package Todo.todo.repo;

import Todo.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  TodoRepository  extends JpaRepository<Todo, Long> {
}
