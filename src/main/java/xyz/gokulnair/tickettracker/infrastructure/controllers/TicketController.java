package xyz.gokulnair.tickettracker.infrastructure.controllers;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.gokulnair.tickettracker.core.usecase.ticket.model.CreateTicketInputBoundary;
import xyz.gokulnair.tickettracker.core.usecase.ticket.model.DeleteTicketInputBoundary;
import xyz.gokulnair.tickettracker.core.usecase.ticket.model.FindVisibleTicketInputBoundary;
import xyz.gokulnair.tickettracker.core.usecase.ticket.model.UpdateTicketPropertyInputBoundary;
import xyz.gokulnair.tickettracker.core.usecase.ticket.model.request.CreateTicketRequestModel;
import xyz.gokulnair.tickettracker.core.usecase.ticket.model.response.TicketResponseModel;
import xyz.gokulnair.tickettracker.infrastructure.tables.TicketTable;

import java.util.List;

@RestController
@RequestMapping("ticket")
public class TicketController {


    private final UpdateTicketPropertyInputBoundary updateTicketPropertyInputBoundary;
    private final CreateTicketInputBoundary createTicketInputBoundary;
    private final FindVisibleTicketInputBoundary findVisibleTicketInputBoundary;
    private final DeleteTicketInputBoundary deleteTicketInputBoundary;


    public TicketController(UpdateTicketPropertyInputBoundary updateTicketPropertyInputBoundary, CreateTicketInputBoundary createTicketInputBoundary, FindVisibleTicketInputBoundary findVisibleTicketInputBoundary, DeleteTicketInputBoundary deleteTicketInputBoundary) {
        this.updateTicketPropertyInputBoundary = updateTicketPropertyInputBoundary;
        this.createTicketInputBoundary = createTicketInputBoundary;
        this.findVisibleTicketInputBoundary = findVisibleTicketInputBoundary;
        this.deleteTicketInputBoundary = deleteTicketInputBoundary;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreateTicketRequestModel createTicketRequestModel){
        TicketTable result=createTicketInputBoundary.create(createTicketRequestModel);

        return ResponseEntity.ok().body("your Ticket id is "+result.getId()+" please save it for future uses.");
    }


    @GetMapping
    public ResponseEntity findAllTickets(){
        List<TicketResponseModel>ticketResponseModels=findVisibleTicketInputBoundary.create();

        return ResponseEntity.ok().body(ticketResponseModels);
    }


    @PutMapping("/updateseverity/{id}")
    public ResponseEntity updateSeverity(@PathVariable(value = "id")Long ticketId,@RequestBody String severity){
        String updateResult=updateTicketPropertyInputBoundary.updateSeverity(ticketId,severity);

        return ResponseEntity.ok().body(updateResult);
    }
    @PutMapping("/updatestatus/{id}")
    public ResponseEntity updateStatus(@PathVariable(value = "id")Long ticketId,@RequestBody String status){
        String updateResult=updateTicketPropertyInputBoundary.updateStatus(ticketId,status);

        return ResponseEntity.ok().body(updateResult);
    }

    @DeleteMapping("/deleteticket/{id}")
    public ResponseEntity deleteticket(@PathVariable(value = "id")Long ticketId){
        String deleteResult= deleteTicketInputBoundary.delete(ticketId);

        return ResponseEntity.ok().body(deleteResult);
    }

}
