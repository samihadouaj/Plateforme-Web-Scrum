package com.backend.backend.Model;

import com.backend.backend.Constants.Status;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="epic")
public class Epic {
    @Id
    private String id;
    private String name;
    private String description;
    private Status status;
    private BacklogItem[] backlogItems;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BacklogItem[] getBacklogItems() {
        return backlogItems;
    }

    public void setBacklogItems(BacklogItem[] backlogItems) {
        this.backlogItems = backlogItems;
    }

    public Epic(String name, String description, Status status, BacklogItem[] backlogItems) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.backlogItems = backlogItems;
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
