package com.tp.wrc.findmyparadise.services;

import com.tp.wrc.findmyparadise.exceptions.NoListingFoundException;
import com.tp.wrc.findmyparadise.models.Listing;

import java.util.List;

public interface ListingService {
    public List<Listing> index();

    public Listing show(int id) throws NoListingFoundException;

    public Listing create(Listing Listing);

    public boolean destroy(int id);
}
