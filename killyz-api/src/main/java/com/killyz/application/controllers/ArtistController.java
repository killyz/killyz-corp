package com.killyz.application.controllers;

import com.killyz.components.artists.ArtistManager;
import com.killyz.models.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistManager artistManager;

    @Autowired
    public ArtistController(ArtistManager artistManager) {
        this.artistManager = artistManager;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public void newArtist(@RequestBody Artist artist) {
        artistManager.saveArtist(artist);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Artist> getAllArtists() {
        return artistManager.getAll();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void deleteArtist(@RequestBody Artist artist) {
        artistManager.deleteArtist(artist.get_id());
    }
}
