package xyz.gokulnair.tickettracker.core.usecase.ticket.model.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateTicketRequestModel {

    private final String title;
    private final String description;
    private final boolean isPublic;

}
