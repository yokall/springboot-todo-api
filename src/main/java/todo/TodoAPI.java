package todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoAPI {
	@Autowired
	private TodoItemRepository todosRepository;

	TodoAPI() {
	}

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public List<TodoItem> todo_list() {
		return todosRepository.findAll();
	}

	@RequestMapping(value = "/todos", method = RequestMethod.POST)
	public TodoItem add_todo(@RequestBody TodoItem new_todo) {
		new_todo = todosRepository.save(new_todo);

		return new_todo;
	}

	@RequestMapping(value = "/todos/{id}", method = RequestMethod.PUT)
	public TodoItem update_todo(@PathVariable String id, @RequestBody TodoItem todo) {
		todo = todosRepository.save(todo);

		return todo;
	}

	@RequestMapping(value = "/todos/{id}", method = RequestMethod.DELETE)
	public void remove_todo(@PathVariable String id) {
		todosRepository.deleteById(id);
	}
}