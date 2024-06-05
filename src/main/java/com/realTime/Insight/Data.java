package com.realTime.Insight;

import java.io.Serializable;

public class Data implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private long timestamp;
    private String title;
    private String description;

    public Data() {
    }

    public Data(String id, long timestamp, String title, String description) {
        this.id = id;
        this.timestamp = timestamp;
        this.title = title;
        this.description = description;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
