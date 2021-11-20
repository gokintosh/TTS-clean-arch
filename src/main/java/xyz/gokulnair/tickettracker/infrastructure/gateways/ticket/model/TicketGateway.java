package xyz.gokulnair.tickettracker.infrastructure.gateways.ticket.model;

import xyz.gokulnair.tickettracker.core.usecase.ticket.model.exceptions.ResourceNotFoundException;
import xyz.gokulnair.tickettracker.infrastructure.gateways.ticket.model.request.CreateTicketGatewayRequestModel;
import xyz.gokulnair.tickettracker.infrastructure.gateways.ticket.model.response.TicketGatewayResponseModel;
import xyz.gokulnair.tickettracker.infrastructure.tables.TicketTable;

import java.util.List;

public interface TicketGateway {

    TicketTable create(CreateTicketGatewayRequestModel createTicketGatewayRequestModel);
    List<TicketGatewayResponseModel> findAll();
    String updateSeverityById(Long id,String severity) throws ResourceNotFoundException;
    String updateStatusById(Long id,String status) throws ResourceNotFoundException;
    String deleteTicketById(Long id) throws ResourceNotFoundException;
}
