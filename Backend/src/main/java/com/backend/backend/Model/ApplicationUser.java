package com.backend.backend.Model;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class ApplicationUser {
    @Id
    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String work;
    private String institute;
    private Project[] ownedProjects;
    private Project[] contributingInProjects;
    private BacklogItem[] assignedItems;
    private Epic[] assignedEpics;

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public Project[] getOwnedProjects() {
        return ownedProjects;
    }

    public void setOwnedProjects(Project[] ownedProjects) {
        this.ownedProjects = ownedProjects;
    }

    public Project[] getContributingInProjects() {
        return contributingInProjects;
    }

    public void setContributingInProjects(Project[] contributingInProjects) {
        this.contributingInProjects = contributingInProjects;
    }

    public BacklogItem[] getAssignedItems() {
        return assignedItems;
    }

    public void setAssignedItems(BacklogItem[] assignedItems) {
        this.assignedItems = assignedItems;
    }

    public Epic[] getAssignedEpics() {
        return assignedEpics;
    }

    public void setAssignedEpics(Epic[] assignedEpics) {
        this.assignedEpics = assignedEpics;
    }

    public ApplicationUser() {
    }

    public ApplicationUser(String username, String password, String firstName, String lastName, String work, String institute, Project[] ownedProjects, Project[] contributingInProjects, BacklogItem[] assignedItems, Epic[] assignedEpics) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.work = work;
        this.institute = institute;
        this.ownedProjects = ownedProjects;
        this.contributingInProjects = contributingInProjects;
        this.assignedItems = assignedItems;
        this.assignedEpics = assignedEpics;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();

        String jsonString = "";
        try {
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            jsonString = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonString;
    }
}