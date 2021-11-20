package xyz.gokulnair.tickettracker.core.usecase.ticket.model;


import org.springframework.stereotype.Service;
import xyz.gokulnair.tickettracker.core.usecase.ticket.model.exceptions.ResourceNotFoundException;
import xyz.gokulnair.tickettracker.infrastructure.gateways.ticket.model.TicketGateway;

@Service
public class UpdateTicketPropertyInteractor implements UpdateTicketPropertyInputBoundary{


    private final TicketGateway ticketGateway;

    public UpdateTicketPropertyInteractor(TicketGateway ticketGateway) {
        this.ticketGateway = ticketGateway;
    }


    @Override
    public String updateSeverity(Long id, String severity) throws ResourceNotFoundException {
        String response=ticketGateway.updateSeverityById(id,severity);
        return response;
    }

    @Override
    public String updateStatus(Long id, String status) throws ResourceNotFoundException {

        String response=ticketGateway.updateStatusById(id,status);
        return response;
    }
}
