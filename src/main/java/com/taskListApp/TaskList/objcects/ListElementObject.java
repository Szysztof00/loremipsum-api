package com.taskListApp.TaskList.objcects;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class ListElementObject {
    private Long id;
    private String taskContent;
    private boolean finish;
}