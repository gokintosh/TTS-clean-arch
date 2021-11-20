package xyz.gokulnair.tickettracker.infrastructure.gateways.ticket.model;

import xyz.gokulnair.tickettracker.infrastructure.gateways.ticket.model.request.CreateTicketGatewayRequestModel;
import xyz.gokulnair.tickettracker.infrastructure.gateways.ticket.model.response.TicketGatewayResponseModel;
import xyz.gokulnair.tickettracker.infrastructure.tables.TicketTable;

import java.util.List;

public interface TicketGateway {

    TicketTable create(CreateTicketGatewayRequestModel createTicketGatewayRequestModel);
    List<TicketGatewayResponseModel> findAll();
    String updateSeverityById(Long id,String severity);
    String updateStatusById(Long id,String status);
    String deleteTicketById(Long id);
}
