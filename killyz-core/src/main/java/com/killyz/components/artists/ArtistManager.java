package com.killyz.components.artists;

import com.killyz.models.Artist;

import java.util.List;

public interface ArtistManager {

    void saveArtist(Artist artist);
    List<Artist> getAll();
    void deleteArtist(long artistId);
}
