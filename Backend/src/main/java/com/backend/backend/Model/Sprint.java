package com.backend.backend.Model;

import com.backend.backend.Constants.Status;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="sprint")
public class Sprint {
    @Id
    private String id;
    private String name;
    private String startDate;
    private String endDate;
    private boolean isCompleted;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
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

    public Sprint(String name, String startDate, String endDate, boolean isCompleted, Status status, BacklogItem[] backlogItems) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isCompleted = isCompleted;
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
