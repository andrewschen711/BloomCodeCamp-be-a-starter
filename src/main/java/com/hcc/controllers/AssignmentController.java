package com.hcc.controllers;

import com.hcc.dto.AssignmentResponseDto;
import com.hcc.entities.Assignment;
import com.hcc.services.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {
    @Autowired
    AssignmentService assignmentService;

    @GetMapping
    public List<AssignmentResponseDto> getAssignmentsByUser(@RequestParam Long userId) {
        return assignmentService.getAssignmentsByUserId(userId);
    }

    @GetMapping("/{id}")
    public AssignmentResponseDto getAssignmentById(@PathVariable Long id) {
        return assignmentService.getAssignmentById(id);
    }

    @PutMapping("/{id}")
    public AssignmentResponseDto updateAssignment(@PathVariable Long id,
                                       @RequestBody Assignment assignmentDetails) {
        return assignmentService.updateAssignment(id, assignmentDetails);
    }

    @PostMapping
    public AssignmentResponseDto createAssignment(@RequestBody Assignment assignment) {
        return assignmentService.createAssignment(assignment);
    }

}
