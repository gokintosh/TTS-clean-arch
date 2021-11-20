package xyz.gokulnair.tickettracker.core.usecase.ticket.model;

import xyz.gokulnair.tickettracker.core.usecase.ticket.model.request.CreateTicketRequestModel;
import xyz.gokulnair.tickettracker.infrastructure.tables.TicketTable;

public interface CreateTicketInputBoundary {

    TicketTable create(CreateTicketRequestModel requestModel);
}
