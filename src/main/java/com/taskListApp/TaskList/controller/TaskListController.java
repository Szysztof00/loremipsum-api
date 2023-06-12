package com.taskListApp.TaskList.controller;

import com.taskListApp.TaskList.objcects.ListElementObject;
import com.taskListApp.TaskList.objcects.MakerListElement;
import com.taskListApp.TaskList.objcects.TransferListElement;
import com.taskListApp.TaskList.service.TaskListService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
public class TaskListController {

    private final TaskListService toDoListService;

    @GetMapping("/taskList")
    public List<ListElementObject> getTaskList() {
        return toDoListService.getTaskList();
    }

    @DeleteMapping("/taskList/{taskID}")
    public void deleteTask(@PathVariable Long taskID) {
        toDoListService.deleteTask(taskID);
    }

    @PostMapping("/taskList")
    public ListElementObject addTask(@RequestBody MakerListElement newToDoListElement) {
        return toDoListService.addTask(newToDoListElement);
    }

    @PutMapping("/taskList/{taskID}")
    public void updateTask(@PathVariable Long taskID,@RequestBody TransferListElement updatedTask) {
        toDoListService.updateTask(taskID,updatedTask);
    }
}