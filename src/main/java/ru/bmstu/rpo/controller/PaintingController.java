package ru.bmstu.rpo.controller;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bmstu.rpo.entity.Painting;
import ru.bmstu.rpo.service.PaintingService;

import java.util.List;

@Data
@RestController
@RequestMapping("/api/v1/paintings")
public class PaintingController {

    @Autowired
    PaintingService paintingService;

    @GetMapping("/")
    public List findAllMuseums() {
        return paintingService.findAllPainting();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createMuseum(@RequestBody Painting painting) {
        return paintingService.createPainting(painting);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Painting> updateMuseum(@PathVariable(value = "id") Long paintingId, @RequestBody Painting paintingDetails) {
        return paintingService.updatePainting(paintingId, paintingDetails);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Object> deleteMuseum(@PathVariable(value = "id") Long paintingId) {
        return paintingService.deletePainting(paintingId);
    }
}
