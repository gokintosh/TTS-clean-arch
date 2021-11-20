package xyz.gokulnair.tickettracker.core.usecase.ticket.model.Interactor;



import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import xyz.gokulnair.tickettracker.core.usecase.ticket.model.CreateTicketInteractor;
import xyz.gokulnair.tickettracker.core.usecase.ticket.model.request.CreateTicketRequestModel;
import xyz.gokulnair.tickettracker.infrastructure.gateways.ticket.model.TicketGateway;
import xyz.gokulnair.tickettracker.infrastructure.gateways.ticket.model.request.CreateTicketGatewayRequestModel;
import xyz.gokulnair.tickettracker.infrastructure.tables.TicketTable;

import java.time.LocalDate;
import java.util.Optional;


public class TicketCreatorTest {


    private TicketGateway ticketGateway= Mockito.mock(TicketGateway.class);





    @Test
    void testTicketCreation(){
        CreateTicketRequestModel testModel=new CreateTicketRequestModel(
                "network error Opole",
                "Politechnika Opolska",
                true);

        TicketTable expectedResult=new TicketTable(123L,"network error Opole","Politechnika Opolska", LocalDate.now(),"","new",false,true);

        CreateTicketInteractor createTicketInteractor=new CreateTicketInteractor(ticketGateway);
        TicketTable testTable=createTicketInteractor.create(testModel);

        Mockito.when(ticketGateway.create(Mockito.any(CreateTicketGatewayRequestModel.class))).thenReturn(expectedResult);

        Assertions.assertThat(testTable.getTitle()).isEqualTo(testModel.getTitle());



    }

//    todo
//    test delete api
//    test update api
//    test get api


}
