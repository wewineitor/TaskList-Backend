package wewin.TaskList.task.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wewin.TaskList.task.dto.TaskDto;
import wewin.TaskList.task.service.TaskService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/")
    public ResponseEntity<Map<String, String>> addTask(@RequestBody TaskDto taskDto) {
        return new ResponseEntity<>(taskService.addTask(taskDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskDto>> findAllTasks() {
        return new ResponseEntity<>(taskService.findAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<TaskDto>> findTasksByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(taskService.findTasksByUserId(userId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<HttpStatus> endTask(@PathVariable Long taskId) {
        taskService.endTask(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
