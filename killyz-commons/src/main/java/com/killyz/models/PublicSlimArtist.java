package com.killyz.models;

public class PublicSlimArtist {

    private long _id;
    private String fullName;

    public PublicSlimArtist(Artist artist) {
        this._id = artist.get_id();
        this.fullName = artist.getFirstName() + " " + artist.getLastName();
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
