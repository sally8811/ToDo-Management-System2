package com.dmm.task.survice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.dmm.task.data.entity.TaskRepository;

@Service
public class TaskCalendarService {

    private final TaskRepository taskRepository;

    public TaskCalendarService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public MultiValueMap<LocalDate, Task> groupByDate(List<Task> tasks) {
        MultiValueMap<LocalDate, Task> map = new LinkedMultiValueMap<>();
        for (Task t : tasks) {
            LocalDate key = t.getDate().toLocalDate();
            map.add(key, t); 
        }
        return map;
    }

   
    public MultiValueMap<LocalDate, Task> findMonthlyTasksGrouped(String name, YearMonth ym) {
        LocalDateTime from = ym.atDay(1).atStartOfDay();
        LocalDateTime to   = ym.atEndOfMonth().atTime(23, 59, 59);

        List<Task> tasks = taskRepository.findByDateBetween(from, to, name);
        return groupByDate(tasks);
    }
}
