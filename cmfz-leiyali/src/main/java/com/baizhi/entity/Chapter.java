package com.baizhi.entity;

import java.util.Date;

public class Chapter {
    private String id;
    private String title;
    private String url;
    private long size;
    private long duration;
    private int alId;
    private String newname;

    public Chapter(String id, String title, String url, long size, long duration, int alId, String newname) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.size = size;
        this.duration = duration;
        this.alId = alId;
        this.newname = newname;
    }

    public Chapter() {
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", size=" + size +
                ", duration=" + duration +
                ", alId=" + alId +
                ", newname='" + newname + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getAlId() {
        return alId;
    }

    public void setAlId(int alId) {
        this.alId = alId;
    }

    public String getNewname() {
        return newname;
    }

    public void setNewname(String newName) {
        this.newname = newname;
    }
}
