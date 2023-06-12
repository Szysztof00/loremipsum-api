package com.taskListApp.TaskList.objcects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TransferListElement {
    private String taskContent;
    private boolean finish;
}