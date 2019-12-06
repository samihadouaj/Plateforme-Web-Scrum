package com.backend.backend.Controller;

import com.backend.backend.Model.Epic;
import com.backend.backend.Repository.EpicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/epics")
public class EpicController {
    @Autowired
    private EpicRepository repository;

    public EpicController() {
    }

    @GetMapping
    public List<Epic> getEpics() {
        return repository.findAll();
    }

    @PostMapping
    public Epic createEpic(@Valid @RequestBody Epic epic){
        return repository.save(epic);
    }

    @PutMapping("/{id}")
    public Epic updateEpic(@PathVariable(value = "id") Long id,
                                         @Valid @RequestBody Epic epicDetails) {
        Optional<Epic> epic = repository.findById(id);
        epic.get().setName(epicDetails.getName());
        epic.get().setDescription(epicDetails.getDescription());
        epic.get().setStatus(epicDetails.getStatus());
        epic.get().setBacklogItems(epicDetails.getBacklogItems());

        Epic updatedEpic = repository.save(epic.get());
        return updatedEpic;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEpic(@PathVariable(value = "id") Long id) {
        Optional<Epic> epic = repository.findById(id);
        repository.delete(epic.get());

        return ResponseEntity.ok().build();
    }
}
