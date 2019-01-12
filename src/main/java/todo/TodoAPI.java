package todo;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoAPI {
	private final AtomicInteger counter = new AtomicInteger();

	private ArrayList<TodoItem> todos = new ArrayList<TodoItem>();

	TodoAPI() {
		TodoItem starting_item = new TodoItem(counter.incrementAndGet(), "My first todo task", true);
		todos.add(starting_item);
	}

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ArrayList<TodoItem> todo_list() {
		return todos;
	}

	@RequestMapping(value = "/todos", method = RequestMethod.POST)
	public TodoItem add_todo(@RequestBody TodoItem new_todo) {
		new_todo.setId(counter.incrementAndGet());
		todos.add(new_todo);

		return new_todo;
	}

	@RequestMapping(value = "/todos/{id}", method = RequestMethod.PUT)
	public TodoItem update_todo(@PathVariable int id, @RequestBody TodoItem todo) {
		todos.set(id - 1, todo);

		return todo;
	}

	@RequestMapping(value = "/todos/{id}", method = RequestMethod.DELETE)
	public void remove_todo(@PathVariable int id) {
		todos.remove(id - 1);
	}
}