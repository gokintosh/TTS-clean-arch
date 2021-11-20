package xyz.gokulnair.tickettracker.core.usecase.ticket.model;

import xyz.gokulnair.tickettracker.core.usecase.ticket.model.exceptions.ResourceNotFoundException;

public interface DeleteTicketInputBoundary {
    String delete(Long id) throws ResourceNotFoundException;
}
