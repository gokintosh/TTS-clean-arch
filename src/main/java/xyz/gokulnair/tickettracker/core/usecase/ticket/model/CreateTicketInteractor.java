package xyz.gokulnair.tickettracker.core.usecase.ticket.model;

import org.springframework.stereotype.Service;
import xyz.gokulnair.tickettracker.core.entities.Ticket;
import xyz.gokulnair.tickettracker.core.usecase.ticket.model.request.CreateTicketRequestModel;
import xyz.gokulnair.tickettracker.infrastructure.gateways.ticket.model.TicketGateway;
import xyz.gokulnair.tickettracker.infrastructure.gateways.ticket.model.request.CreateTicketGatewayRequestModel;
import xyz.gokulnair.tickettracker.infrastructure.tables.TicketTable;

import java.time.LocalDate;


@Service
public class CreateTicketInteractor implements CreateTicketInputBoundary{
    private final TicketGateway ticketGateway;

    public CreateTicketInteractor(TicketGateway ticketGateway) {
        this.ticketGateway = ticketGateway;
    }

    @Override
    public TicketTable create(CreateTicketRequestModel requestModel) {
        Ticket ticket=new Ticket(null,
                requestModel.getTitle(),
                requestModel.getDescription(),
                LocalDate.now(),
                "",
                "new",
                false,
                requestModel.isPublic()
        );

        CreateTicketGatewayRequestModel createTicketGatewayRequestModel=CreateTicketGatewayRequestModel.of(ticket);
        TicketTable ticketTable=ticketGateway.create(createTicketGatewayRequestModel);

        return ticketTable;


    }
}
