package xyz.gokulnair.tickettracker.core.usecase.ticket.model;

import xyz.gokulnair.tickettracker.core.usecase.ticket.model.response.TicketResponseModel;

import java.util.List;

public interface FindVisibleTicketInputBoundary {
    List<TicketResponseModel>create();
}
