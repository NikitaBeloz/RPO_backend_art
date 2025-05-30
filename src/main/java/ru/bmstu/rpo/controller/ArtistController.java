package ru.bmstu.rpo.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bmstu.rpo.entity.Artist;
import ru.bmstu.rpo.entity.Painting;
import ru.bmstu.rpo.service.ArtistService;

import java.util.List;

@RequestMapping("/api/v1/artists")
@CrossOrigin(origins = "http://localhost:3000")
@Data
@RestController
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @GetMapping(("/"))
    public List findAllArtists() {
        return artistService.findAllArtists();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createArtist(@RequestBody Artist artist) {
        return artistService.createArtist(artist);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Artist> updateArtist(@PathVariable(value = "id") Long artistId, @RequestBody Artist artistDetails) {
        return artistService.updateArtist(artistId, artistDetails);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Object> deleteArtist(@PathVariable(value = "id") Long artistId) {
        return artistService.deleteArtist(artistId);
    }

    @GetMapping("/{id}/paintings")
    public ResponseEntity<List<Painting>> getArtistPainting(@PathVariable(value = "id") Long artistId) {
        return artistService.getArtistPainting(artistId);
    }
}
