package xyz.gokulnair.tickettracker.core.usecase.ticket.model;

public interface UpdateTicketPropertyInputBoundary {

    String updateSeverity(Long id,String severity);
    String updateStatus(Long id,String status);
}
