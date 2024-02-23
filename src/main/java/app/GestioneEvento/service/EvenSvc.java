package app.GestioneEvento.service;

import app.GestioneEvento.exception.NotFoundException;
import app.GestioneEvento.model.entities.Event;
import app.GestioneEvento.model.request.EventReq;
import app.GestioneEvento.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvenSvc {
    @Autowired
    private EventRepo eventRepo;

    public Event saveEvent (EventReq eventReq){
        Event event = new Event(eventReq.getTitle(),
                eventReq.getDescription(),
                eventReq.getDate(),
                eventReq.getLocation(),
                eventReq.getNrPlace());
        return eventRepo.save(event);
    }

    public Event getEventById(int id) throws NotFoundException {
       Event event = eventRepo.findById(id).orElseThrow(() -> new NotFoundException("Event do not found"));
        return event;
    }

    public Event upDateEvent (int id, EventReq eventReq) throws NotFoundException {
        Event event = getEventById(id);
        event.setTitle(eventReq.getTitle());
        event.setDescription(eventReq.getDescription());
        event.setDate(eventReq.getDate());
        event.setLocation(eventReq.getLocation());
        event.setNrPlace(eventReq.getNrPlace());
        return eventRepo.save(event);
    }

    public void deleteEvent(int id) throws NotFoundException{
        Event event = getEventById(id);
        eventRepo.delete(event);
    }


}
