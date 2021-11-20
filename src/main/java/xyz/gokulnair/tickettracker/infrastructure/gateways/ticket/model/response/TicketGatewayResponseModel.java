package xyz.gokulnair.tickettracker.infrastructure.gateways.ticket.model.response;


import lombok.AllArgsConstructor;
import xyz.gokulnair.tickettracker.core.entities.Ticket;

import java.time.LocalDate;

@AllArgsConstructor
public class TicketGatewayResponseModel {

    private final Long id;
    private final String title;
    private final String description;
    private final LocalDate createdAt;
    private final String severity;
    private final String status;
    private final boolean isDeleted;
    private final boolean isPublic;



    public Ticket fromThis(){
        return new Ticket(
                id,
                title,
                description,
                createdAt,
                severity,
                status,
                isDeleted,
                isPublic
        );
    }
}
