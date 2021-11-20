package xyz.gokulnair.tickettracker.infrastructure.gateways.ticket.model.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.tomcat.jni.Local;
import xyz.gokulnair.tickettracker.core.entities.Ticket;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class CreateTicketGatewayRequestModel {

    private final String title;
    private final String description;
    private final LocalDate createdAt;
    private final String severity;
    private final String status;
    private final boolean isDeleted;
    private final boolean isPublic;


    public static CreateTicketGatewayRequestModel of(Ticket ticket){
        return new CreateTicketGatewayRequestModel(
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
