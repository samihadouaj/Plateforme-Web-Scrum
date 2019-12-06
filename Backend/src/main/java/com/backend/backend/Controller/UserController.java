package com.backend.backend.Controller;

import com.backend.backend.Model.ApplicationUser;
import com.backend.backend.Repository.ApplicationUserRepository;
import com.backend.backend.Repository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private ApplicationUserRepository repository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController() {
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        repository.save(user);
    }

    @GetMapping
    public List<ApplicationUser> getApplicationUsers() {
        return repository.findAll();
    }

@GetMapping("/{username}")
public  ApplicationUser getUserByUsername(@PathVariable String username){
        return this.repository.findByUsername(username);
}
    @PutMapping("/{id}")
    public ApplicationUser updateApplicationUser(@PathVariable(value = "id") Long id,
                               @Valid @RequestBody ApplicationUser userDetails) {
        Optional<ApplicationUser> user = repository.findById(id);
        user.get().setFirstName(userDetails.getFirstName());
        user.get().setLastName(userDetails.getLastName());
        user.get().setAssignedEpics(userDetails.getAssignedEpics());
        user.get().setAssignedItems(userDetails.getAssignedItems());
        user.get().setContributingInProjects(userDetails.getContributingInProjects());
        user.get().setInstitute(userDetails.getInstitute());
        user.get().setOwnedProjects(userDetails.getOwnedProjects());
        user.get().setWork(userDetails.getWork());

        ApplicationUser updatedApplicationUser = repository.save(user.get());
        return updatedApplicationUser;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteApplicationUser(@PathVariable(value = "id") Long id) {
        Optional<ApplicationUser> user = repository.findById(id);
        repository.delete(user.get());

        return ResponseEntity.ok().build();
    }
}