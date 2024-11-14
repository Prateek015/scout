package scout.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/labour")
public class LabourController {

    @GetMapping("/tasks")
    public String viewTasks() {
        // Logic for returning daily tasks
        return "Task data";
    }
}
