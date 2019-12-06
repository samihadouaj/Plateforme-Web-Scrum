package com.backend.backend.Controller;

import com.backend.backend.Model.BacklogItem;
import com.backend.backend.Repository.BacklogItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/backlogItems")
public class BacklogItemController {
    @Autowired
    private BacklogItemRepository repository;

    public BacklogItemController() {
    }

    @GetMapping
    public List<BacklogItem> getBacklogItems() {
        return repository.findAll();
    }

    @PostMapping
    public BacklogItem createBacklogItem(@Valid @RequestBody BacklogItem backlogItem){
        return repository.save(backlogItem);
    }

    @PutMapping("/{id}")
    public BacklogItem updateBacklogItem(@PathVariable(value = "id") Long id,
                                         @Valid @RequestBody BacklogItem backlogItemDetails) {
        Optional<BacklogItem> backlogItem = repository.findById(id);
        backlogItem.get().setName(backlogItemDetails.getName());
        backlogItem.get().setDescription(backlogItemDetails.getDescription());
        backlogItem.get().setEffort(backlogItemDetails.getEffort());
        backlogItem.get().setPriority(backlogItemDetails.getPriority());
        backlogItem.get().setStatus(backlogItemDetails.getStatus());

        BacklogItem updatedBacklogItem = repository.save(backlogItem.get());
        return updatedBacklogItem;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBacklogItem(@PathVariable(value = "id") Long id) {
        Optional<BacklogItem> backlogItem = repository.findById(id);
        repository.delete(backlogItem.get());

        return ResponseEntity.ok().build();
    }
}
