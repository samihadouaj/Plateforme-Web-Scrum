package com.backend.backend.Controller;

import com.backend.backend.Model.Sprint;
import com.backend.backend.Repository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sprints")
public class SprintController {
    @Autowired
    private SprintRepository repository;

    public SprintController() {
    }

    @GetMapping
    public List<Sprint> getSprints() {
        return repository.findAll();
    }

    @PostMapping
    public Sprint createSprint(@Valid @RequestBody Sprint sprint){
        return repository.save(sprint);
    }

    @PutMapping("/{id}")
    public Sprint updateSprint(@PathVariable(value = "id") Long id,
                                 @Valid @RequestBody Sprint sprintDetails) {
        Optional<Sprint> sprint = repository.findById(id);
        sprint.get().setName(sprintDetails.getName());
        sprint.get().setStartDate(sprintDetails.getStartDate());
        sprint.get().setEndDate(sprintDetails.getEndDate());
        sprint.get().setBacklogItems(sprintDetails.getBacklogItems());
        sprint.get().setStatus(sprintDetails.getStatus());
        sprint.get().setCompleted(sprintDetails.isCompleted());

        Sprint updatedSprint = repository.save(sprint.get());
        return updatedSprint;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSprint(@PathVariable(value = "id") Long id) {
        Optional<Sprint> sprint = repository.findById(id);
        repository.delete(sprint.get());

        return ResponseEntity.ok().build();
    }
}
