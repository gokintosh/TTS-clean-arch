package xyz.gokulnair.tickettracker.core.usecase.ticket.model;

import org.springframework.stereotype.Service;
import xyz.gokulnair.tickettracker.core.entities.Ticket;
import xyz.gokulnair.tickettracker.core.usecase.ticket.model.response.TicketResponseModel;
import xyz.gokulnair.tickettracker.infrastructure.gateways.ticket.model.TicketGateway;
import xyz.gokulnair.tickettracker.infrastructure.gateways.ticket.model.response.TicketGatewayResponseModel;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class FindVisibleTicketInteractor implements FindVisibleTicketInputBoundary{

    private final TicketGateway ticketGateway;

    public FindVisibleTicketInteractor(TicketGateway ticketGateway) {
        this.ticketGateway = ticketGateway;
    }

    @Override
    public List<TicketResponseModel> create() {
        List<TicketGatewayResponseModel>ticketGatewayResponseModels=ticketGateway.findAll();


        List<Ticket>tickets=ticketGatewayResponseModels.stream().
                map(TicketGatewayResponseModel::fromThis)
                .collect(Collectors.toList());

        List<TicketResponseModel>ticketResponseModels=tickets.stream()
                .filter(Ticket::canShow)
                .map(TicketResponseModel::of)
                .collect(Collectors.toList());


        return ticketResponseModels;
    }
}
