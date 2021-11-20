package xyz.gokulnair.tickettracker.core.usecase.ticket.model;


import org.springframework.stereotype.Service;
import xyz.gokulnair.tickettracker.infrastructure.gateways.ticket.model.TicketGateway;

@Service
public class DeleteTicketInteractor implements DeleteTicketInputBoundary{

    private final TicketGateway ticketGateway;

    public DeleteTicketInteractor(TicketGateway ticketGateway) {
        this.ticketGateway = ticketGateway;
    }

    @Override
    public String delete(Long id) {
        String response=ticketGateway.deleteTicketById(id);
        return response;
    }
}
