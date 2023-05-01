package com.geekster.UniversityEventManagment.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geekster.UniversityEventManagment.model.Event;
import com.geekster.UniversityEventManagment.service.EventService;

import jakarta.validation.Valid;

@RestController
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping(value = "/addEvent")
    public String addEvent(@Valid @RequestBody Event event) {
        eventService.addEvent(event);
        return "added";
    }

    @GetMapping(value = "/getEventByDate/{date}")
    public List<Event> getAllEventsByDate(@PathVariable String date) {
        return eventService.getAllEventsByDate(date);

    }

    @DeleteMapping(value = "/deleteEventById/eventId/{eventId}")
    public void deleteEventById(@PathVariable Long eventId) {
        eventService.deleteEventById(eventId);
    }

    @PutMapping(value = "/updateEventById/{eventId}")
    public void updateEventById(@PathVariable Long eventId, @Valid @RequestBody Event event) {
        eventService.updateEventById(eventId, event);
    }

}
