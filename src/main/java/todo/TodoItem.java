package todo;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class TodoItem {

    @Id
    private String id;
    private final String title;
    private boolean complete;

    public TodoItem(String title, boolean complete) {
        this.title = title;
        this.complete = complete;
    }
}