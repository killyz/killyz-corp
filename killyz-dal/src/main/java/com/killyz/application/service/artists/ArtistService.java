package com.killyz.application.service.artists;

import com.killyz.models.Artist;

import java.util.List;

public interface ArtistService {

    void save(Artist artist);
    boolean isArtistExists(Artist artist);
    boolean isArtistExists(long artistId);
    List<Artist> getAll();
    void delete(long artistId);
}
