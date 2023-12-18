package wewin.TaskList.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wewin.TaskList.task.entity.Task;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findTasksByUserId(Long userId);
    Task findTaskByUserId(Long userId);
}
