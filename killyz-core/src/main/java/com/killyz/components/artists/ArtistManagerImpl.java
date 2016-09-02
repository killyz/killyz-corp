package com.killyz.components.artists;

import com.killyz.application.service.artists.ArtistService;
import com.killyz.components.counters.CounterManager;
import com.killyz.models.Artist;
import com.killyz.models.PublicSlimArtist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArtistManagerImpl implements ArtistManager {

    private final String artistCounterName = "artists";
    private final CounterManager counterManager;
    private final ArtistService artistService;

    @Autowired
    public ArtistManagerImpl(CounterManager counterManager, ArtistService artistService) {
        this.counterManager = counterManager;
        this.artistService = artistService;
    }

    @Override
    public void saveArtist(Artist artist) {
        if (artistService.isArtistExists(artist))
            throw new RuntimeException("Cannot create artist. " + artist.getFirstName() + " " + artist.getLastName() + " already exists");

        artist.set_id(counterManager.getSequence(artistCounterName));
        artistService.save(artist);
    }

    @Override
    public List<Artist> getAll() {
        return artistService.getAll();
    }

    @Override
    public List<PublicSlimArtist> getAllArtistNames() {
        return getAll().stream().map(PublicSlimArtist::new).collect(Collectors.toList());
    }

    @Override
    public void deleteArtist(long artistId) {
        artistService.delete(artistId);
    }
}
