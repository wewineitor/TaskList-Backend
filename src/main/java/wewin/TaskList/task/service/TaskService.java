package wewin.TaskList.task.service;

import wewin.TaskList.task.dto.TaskDto;

import java.util.List;
import java.util.Map;

public interface TaskService {
    List<TaskDto> findAllTasks();
    List<TaskDto> findTasksByUserId(Long userId);
    Map<String, String> addTask(TaskDto taskDto);
    void endTask(Long taskId);
}