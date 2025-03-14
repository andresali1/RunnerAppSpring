package com.rungroup.web.services;

import java.util.List;

import com.rungroup.web.dto.EventDto;

public interface EventService {
    void createEvent(Long clubId, EventDto eventDto);

    List<EventDto> findAllEmails();

    EventDto findByEventId(Long eventId);

    void updateEvent(EventDto eventDto);
}
