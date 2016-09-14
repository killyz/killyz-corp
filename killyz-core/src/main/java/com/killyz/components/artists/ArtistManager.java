package com.killyz.components.artists;

import com.killyz.models.Artist;
import com.killyz.models.PublicSlimArtist;

import java.util.List;

public interface ArtistManager {

    void saveArtist(Artist artist);
    List<Artist> getAll();
    List<PublicSlimArtist> getAllArtistNames();
    void deleteArtist(long artistId);

}
