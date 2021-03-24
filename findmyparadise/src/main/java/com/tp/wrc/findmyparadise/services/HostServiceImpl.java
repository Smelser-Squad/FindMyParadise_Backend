package com.tp.wrc.findmyparadise.services;


import com.tp.wrc.findmyparadise.exceptions.InvalidHostIDException;
import com.tp.wrc.findmyparadise.exceptions.NullHostIDException;
import com.tp.wrc.findmyparadise.models.Host;
import com.tp.wrc.findmyparadise.repositories.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class HostServiceImpl implements HostService {

    @Autowired
    HostRepository hRepo;

    @Override
    public List<Host> getAll() throws InvalidHostIDException, NullHostIDException {
        return hRepo.findAll();
    }

    @Override
    public Host show(Integer hostID) throws InvalidHostIDException, NullHostIDException {
        if(hostID==null){
            throw new NullHostIDException("Null host id entered");
        }
        Host newHost = null;
        Optional<Host> opt = hRepo.findById(hostID);
        if (opt.isPresent()) {
            newHost = opt.get();

            return newHost;
        } else {
            throw new InvalidHostIDException("a host with that ID doesn't exist");
        }
    }

    @Override
    public Host create(Host newHost) throws InvalidHostIDException, NullHostIDException {
        return hRepo.saveAndFlush(newHost);
    }

    @Override
    public Host update(Integer hostID, Host newHost) throws InvalidHostIDException, NullHostIDException {
        Host hostToUpdate = hRepo.findById(hostID).get();

        if(hostID==null){
            throw new NullHostIDException("Null host id entered");
        }

        if (hostToUpdate != null) {

            hostToUpdate.setHostID(hostID);
            hostToUpdate.setHostName(newHost.getHostName());
            hostToUpdate.setTotalReviews(newHost.getTotalReviews());
            hostToUpdate.setSuperHost(newHost.isSuperHost());
            hostToUpdate.setVerified(newHost.isVerified());
            hostToUpdate.setResponseTime(newHost.getResponseTime());
            hostToUpdate.setResponseRate(newHost.getResponseRate());
            hostToUpdate.setJoinDate(newHost.getJoinDate());
            hostToUpdate.setEmail(newHost.getEmail());
            hostToUpdate.setImageSrc(newHost.getImageSrc());

            return hRepo.saveAndFlush(hostToUpdate);
        } else {
            throw new InvalidHostIDException("a host with that ID doesn't exist");
        }
    }

    @Override
    public boolean destroy(Integer hostID) throws InvalidHostIDException, NullHostIDException {
        if(hostID==null){
            throw new NullHostIDException("Null host id entered");
        }
        Host newHost = hRepo.findById(hostID).get();

        if (newHost != null) {
            hRepo.delete(newHost);
            return true;
        } else {
            throw new InvalidHostIDException("a host with that ID doesn't exist");
        }
    }

}
