package com.tp.wrc.findmyparadise.controllers;

import com.tp.wrc.findmyparadise.exceptions.InvalidListingIDException;
import com.tp.wrc.findmyparadise.exceptions.NoListingFoundException;
import com.tp.wrc.findmyparadise.exceptions.NullListingIDException;
import com.tp.wrc.findmyparadise.models.Listing;
import com.tp.wrc.findmyparadise.services.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ListingController {

    @Autowired
    ListingService service;

    @PostMapping("/listing")

    public ResponseEntity createListing(@RequestBody Listing newListing) {
        return ResponseEntity.ok(service.create(newListing));
    }

    @GetMapping("/listing/{listingId}")
    public ResponseEntity getListingByID(@PathVariable Integer listingId) {
        Listing toReturn = null;
        try {
            toReturn = service.show(listingId);
        } catch (NoListingFoundException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
        return ResponseEntity.ok(toReturn);
    }
}