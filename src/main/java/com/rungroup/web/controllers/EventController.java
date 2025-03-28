package com.rungroup.web.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.rungroup.web.dto.EventDto;
import com.rungroup.web.models.Event;
import com.rungroup.web.services.EventService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventController {
    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public String eventList(Model model) {
        List<EventDto> events = eventService.findAllEmails();
        model.addAttribute("events", events);
        return "events-list";
    }

    @GetMapping("/events/{eventId}")
    public String viewEvent(@PathVariable("eventId") Long eventId, Model model) {
        EventDto eventDto = eventService.findByEventId(eventId);
        model.addAttribute("event", eventDto);
        return "events-detail";
    }

    @GetMapping("/events/{clubId}/new")
    public String createEventForm(@PathVariable("clubId") Long clubId, Model model) {
        Event event = new Event();
        model.addAttribute("clubId", clubId);
        model.addAttribute("event", event);
        return "events-create";
    }

    @PostMapping("/events/{clubId}")
    public String createEvent(@PathVariable("clubId") Long clubId, @Valid @ModelAttribute("event") EventDto eventDto,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("event", eventDto);
            return "events-create";
        }

        eventService.createEvent(clubId, eventDto);
        return "redirect:/clubs/" + clubId;
    }

    @GetMapping("/events/{eventId}/edit")
    public String editEventForm(@PathVariable("eventId") long eventId, Model model) {
        EventDto event = eventService.findByEventId(eventId);
        model.addAttribute("event", event);
        return "events-edit";
    }

    @PostMapping("/events/{eventId}/edit")
    public String updateEvent(@PathVariable("eventId") long eventId,
            @Valid @ModelAttribute("event") EventDto eventDto,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("event", eventDto);
            return "events-edit";
        }

        EventDto eventDtoDb = eventService.findByEventId(eventId);
        eventDto.setId(eventId);
        eventDto.setClub(eventDtoDb.getClub());
        eventService.updateEvent(eventDto);
        return "redirect:/events";
    }

    @GetMapping("/events/{eventId}/delete")
    public String deleteEvent(@PathVariable("eventId") Long eventId) {
        eventService.deleteEvent(eventId);
        return "redirect:/events";
    }

}
