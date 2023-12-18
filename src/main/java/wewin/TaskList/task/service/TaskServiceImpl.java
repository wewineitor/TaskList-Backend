package wewin.TaskList.task.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import wewin.TaskList.task.dto.TaskDto;
import wewin.TaskList.task.entity.Task;
import wewin.TaskList.task.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<TaskDto> findAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(task -> modelMapper.map(task, TaskDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> findTasksByUserId(Long userId) {
        Optional<Task> tasks = taskRepository.findTasksByUserId(userId);
        return tasks.stream()
                .map(task -> modelMapper.map(task, TaskDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, String> addTask(TaskDto taskDto) {
        Task task = modelMapper.map(taskDto, Task.class);
        LocalDateTime dateTime = LocalDateTime.now();
        task.setInitialTime(dateTime.toLocalTime());
        task.setInitialDate(dateTime.toLocalDate());
        modelMapper.map(taskRepository.save(task), TaskDto.class);
        Map<String, String> response = new HashMap<>();
        response.put("Message", "Task added successfully");
        return response;
    }

    @Override
    public void endTask(Long taskId) {
        Task existingTask = taskRepository.findTaskByUserId(taskId);
        LocalDateTime dateTime = LocalDateTime.now();
        existingTask.setCompleted(true);
        existingTask.setFinalTime(dateTime.toLocalTime());
        existingTask.setFinalDate(dateTime.toLocalDate());
        taskRepository.save(existingTask);
    }
}