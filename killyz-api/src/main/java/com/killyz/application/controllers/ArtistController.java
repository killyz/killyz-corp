package com.killyz.application.controllers;

import com.killyz.components.artists.ArtistManager;
import com.killyz.models.Artist;
import com.killyz.models.PaymentMethod;
import com.killyz.models.PaymentPlatform;
import com.killyz.models.PublicSlimArtist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
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

    @RequestMapping(value = "/getAllNames", method = RequestMethod.GET)
    public List<PublicSlimArtist> getAllArtistNames() {
        return artistManager.getAllArtistNames();
    }

    @RequestMapping(value = "/getAllPaymentPlatforms", method = RequestMethod.GET)
    public List<String> getAllPaymentPlatforms() {
        return PaymentPlatform.getPlatforms().stream().map(PaymentPlatform::getPlatformName).collect(Collectors.toList());
    }

    @RequestMapping(value = "/getAllPaymentMethods", method = RequestMethod.GET)
    public List<String> getAllPaymentMethods() {
        return PaymentMethod.getMethods().stream().map(PaymentMethod::getMethodName).collect(Collectors.toList());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void deleteArtist(@RequestBody Artist artist) {
        artistManager.deleteArtist(artist.get_id());
    }
}
