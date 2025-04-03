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
        return paintingService.findAllPainting();
    }

    @PostMapping("/create")
        return paintingService.createPainting(painting);
    }

    @PostMapping("/update/{id}")
        return paintingService.updatePainting(paintingId, paintingDetails);
    }

    @PostMapping("/delete/{id}")
        return paintingService.deletePainting(paintingId);
    }
}
