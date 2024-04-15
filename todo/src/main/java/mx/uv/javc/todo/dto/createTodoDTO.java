package mx.uv.javc.todo.dto;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Size;

public class createTodoDTO {

    @Nonnull
    @Size(max = 50)
    private String title;

    @Nonnull
    @Size(max = 100)
    private String description;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
}
