package com.killyz.application.service.artists;

import com.killyz.models.Artist;

public interface ArtistService {

    void save(Artist artist);
    boolean isArtistExists(Artist artist);
    boolean isArtistExists(long artistId);
}
