package wewin.TaskList.task.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
public class TaskDto {
    private Long taskId;
    private Long userId;
    private String title;
    private String description;
    private boolean completed;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate initialDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate finalDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalTime initialTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalTime finalTime;
}
