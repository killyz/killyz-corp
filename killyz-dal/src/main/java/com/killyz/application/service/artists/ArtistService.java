package com.killyz.application.service.artists;

import com.killyz.models.Artist;

import java.util.List;

public interface ArtistService {

    void save(Artist artist);
    Artist getArtist(long artistId);
    boolean isArtistExists(Artist artist);
    boolean isArtistExists(long artistId);
    void increaseNumberOfModels(long artistId);
    long getNumberOfArtists();
    List<Artist> getAll();
    void delete(long artistId);
}
