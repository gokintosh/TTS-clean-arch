package xyz.gokulnair.tickettracker.core.usecase.ticket.model.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import xyz.gokulnair.tickettracker.core.entities.Ticket;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class TicketResponseModel {

    private final Long id;
    private final String title;
    private final String description;
    private final LocalDate createdAt;
    private final String severity;
    private final String status;
    private final boolean isDeleted;
    private final boolean isPublic;

    public static TicketResponseModel of(Ticket ticket){
        return new TicketResponseModel(
                ticket.getId(),
                ticket.getTitle(),
                ticket.getDescription(),
                ticket.getCreatedAt(),
                ticket.getSeverity(),
                ticket.getStatus(),
                ticket.isDeleted(),
                ticket.isPublic()
        );
    }
}
