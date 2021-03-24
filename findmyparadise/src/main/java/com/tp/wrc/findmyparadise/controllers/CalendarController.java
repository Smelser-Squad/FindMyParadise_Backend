package com.tp.wrc.findmyparadise.controllers;


import com.tp.wrc.findmyparadise.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class CalendarController {
    @Autowired
    CalendarService service;
}