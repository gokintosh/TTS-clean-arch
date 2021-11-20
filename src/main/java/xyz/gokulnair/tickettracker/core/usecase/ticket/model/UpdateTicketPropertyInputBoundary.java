package xyz.gokulnair.tickettracker.core.usecase.ticket.model;

import xyz.gokulnair.tickettracker.core.usecase.ticket.model.exceptions.ResourceNotFoundException;

public interface UpdateTicketPropertyInputBoundary {

    String updateSeverity(Long id,String severity) throws ResourceNotFoundException;
    String updateStatus(Long id,String status) throws ResourceNotFoundException;
}

