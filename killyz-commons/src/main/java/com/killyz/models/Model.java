package com.killyz.models;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private long _id;
    private String title;
    private String imageUrl;
    private long artistId;
    private List<Long> upcList;

    public Model() {
        this.upcList = new ArrayList<>();
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getArtistId() {
        return artistId;
    }

    public void setArtistId(long artistId) {
        this.artistId = artistId;
    }

    public List<Long> getUpcList() {
        return upcList;
    }

    public void setUpcList(List<Long> upcList) {
        this.upcList = upcList;
    }
}
