package com.example.trello.repository;
import com.example.trello.entity.TaskUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.util.List;

public interface TaskUserRepository extends JpaRepository<TaskUser,Integer> {

    @Modifying
    @Transactional
    @Query(value="DELETE FROM task_user WHERE task_user.task_id = ?1 and task_user.user_id = ?2", nativeQuery = true)
    public void removeUserFromTask(int task_id,int user_id);

    public List<TaskUser> findByTaskId(int task_id);

    public TaskUser findByUserId(int user_id);
}
