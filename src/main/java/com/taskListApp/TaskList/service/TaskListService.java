package com.taskListApp.TaskList.service;

import com.taskListApp.TaskList.objcects.ListElementObject;
import com.taskListApp.TaskList.objcects.MakerListElement;
import com.taskListApp.TaskList.objcects.TransferListElement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskListService {
    private List<ListElementObject> taskList;

    public List<ListElementObject> getTaskList() {
        if (taskList.size() != 0) {
            return taskList;
        } else {
            return new ArrayList<>();
        }
    }

    public ListElementObject addTask(MakerListElement newTask) {
        ListElementObject newTaskElement;
        if (taskList.size() != 0) {
            Long lastUsedTaskID = taskList.get(taskList.size()-1).getId();
            Long freeTaskID = lastUsedTaskID + 1;
            newTaskElement = createListElementObject(freeTaskID, newTask.getTaskContent());
        } else {
            this.taskList = new ArrayList<>();
            newTaskElement = createListElementObject((long) 1, newTask.getTaskContent());
        }
        this.taskList.add(newTaskElement);
        return newTaskElement;
    }

    private ListElementObject createListElementObject(Long taskID, String taskContent) {
        return ListElementObject.builder()
                .id(taskID)
                .taskContent(taskContent)
                .finish(false).build();
    }

    public void deleteTask(Long taskID) {
        if (taskList.size() == 0) {
            throw new RuntimeException("Element o podanym ID nie istnieje");
        }
        this.taskList = taskList.stream()
                .filter(task -> !task.getId().equals(taskID))
                .collect(Collectors.toList());


    }

    public void updateTask(Long taskID, TransferListElement updatedTask) {
        Optional<ListElementObject> optionalTask = taskList.stream()
                .filter(task -> task.getId().equals(taskID))
                .findFirst();

        if (optionalTask.isPresent()) {
            ListElementObject existingTask = optionalTask.get();
            existingTask.setFinish(updatedTask.isFinish());
            existingTask.setTaskContent(updatedTask.getTaskContent());
        } else {
            throw new RuntimeException("Element o podanym ID nie istnieje");
        }
    }
}