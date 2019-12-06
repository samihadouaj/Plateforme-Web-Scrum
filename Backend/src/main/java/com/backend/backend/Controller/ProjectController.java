package com.backend.backend.Controller;

import com.backend.backend.Model.Project;
import com.backend.backend.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200/projects")
@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectRepository repository;

    public ProjectController() {
    }

    @GetMapping
    public List<Project> getProjects() {
        return repository.findAll();
    }

    @PostMapping
    public Project createProject(@Valid @RequestBody Project project){
        return repository.save(project);
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable(value = "id") Long id,
                           @Valid @RequestBody Project projectDetails) {
        Optional<Project> project = repository.findById(id);
        project.get().setName(projectDetails.getName());
        project.get().setDescription(projectDetails.getDescription());
        project.get().setStartDate(projectDetails.getStartDate());
        project.get().setEndDate(projectDetails.getEndDate());
        project.get().setBacklogItems(projectDetails.getBacklogItems());
        project.get().setSprints(projectDetails.getSprints());

        Project updatedProject = repository.save(project.get());
        return updatedProject;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable(value = "id") Long id) {
        Optional<Project> project = repository.findById(id);
        repository.delete(project.get());

        return ResponseEntity.ok().build();
    }
}
