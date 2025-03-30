package ru.bmstu.rpo.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bmstu.rpo.entity.Country;
import ru.bmstu.rpo.service.CountryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@RestController
@RequestMapping("/api/v1/countries")
public class SampleController {

    @Autowired
    CountryService countryService;

    @GetMapping("/")
    public List findAllCountries() {
        return countryService.findAllCountries();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createCountry(@RequestBody Country country) {
        return countryService.createCountry(country);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable(value = "id") Long countryId, @RequestBody Country countryDetails) {
        return countryService.updateCountry(countryId, countryDetails);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCountry(@PathVariable(value = "id") Long countryId) {
        return countryService.deleteCountry(countryId);
    }
}

