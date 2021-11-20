package xyz.gokulnair.tickettracker.infrastructure.gateways.ticket.model;
import org.springframework.stereotype.Service;
import xyz.gokulnair.tickettracker.core.entities.Severity;
import xyz.gokulnair.tickettracker.core.entities.Status;
import xyz.gokulnair.tickettracker.infrastructure.gateways.ticket.model.request.CreateTicketGatewayRequestModel;
import xyz.gokulnair.tickettracker.infrastructure.gateways.ticket.model.response.TicketGatewayResponseModel;
import xyz.gokulnair.tickettracker.infrastructure.repositories.TicketJPARepository;
import xyz.gokulnair.tickettracker.infrastructure.tables.TicketTable;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TicketJpa implements TicketGateway{


    private final TicketJPARepository ticketJPArepository;

    public TicketJpa(TicketJPARepository ticketJPArepository) {
        this.ticketJPArepository = ticketJPArepository;
    }

    @Override
    public TicketTable create(CreateTicketGatewayRequestModel createTicketGatewayRequestModel) {

        TicketTable ticketTable=this.ticketJPArepository.save(new TicketTable(
                null,
                createTicketGatewayRequestModel.getTitle(),
                createTicketGatewayRequestModel.getDescription(),
                createTicketGatewayRequestModel.getCreatedAt(),
                "",
                createTicketGatewayRequestModel.getStatus(),
                createTicketGatewayRequestModel.isDeleted(),
                createTicketGatewayRequestModel.isPublic()

        ));

        return ticketTable;



    }

    @Override
    public List<TicketGatewayResponseModel> findAll() {

        return ticketJPArepository.findAll().stream()
                .map(ticketTable->new TicketGatewayResponseModel(
                        ticketTable.getId(),
                        ticketTable.getTitle(),
                        ticketTable.getDecsription(),
                        ticketTable.getCreatedAt(),
                        ticketTable.getSeverity(),
                        ticketTable.getStatus(),
                        ticketTable.getIsDeleted(),
                        ticketTable.getIsPublic()
                )).collect(Collectors.toList());
    }

    @Override
    public String updateSeverityById(Long id, String severity) {

        TicketTable result=getTicketFromId(id);

        String severityToCheck=severity.toUpperCase();

        try{
            Severity severityFromEnum=Severity.valueOf(severityToCheck);
            String severityString=severityFromEnum.toString();

            result.setSeverity(severityString);
        }catch (IllegalArgumentException ex){
            result.setSeverity(severity);
        }




        ticketJPArepository.save(result);

        return "success";

    }

    @Override
    public String updateStatusById(Long id, String status) {
        TicketTable result=getTicketFromId(id);


        String statusToCheck=status.toUpperCase();

        try{
            Status statusFromEnum=Status.valueOf(statusToCheck);
            String statusString=statusFromEnum.toString();

            result.setStatus(statusString);
        }catch (IllegalArgumentException ex){
            result.setStatus(status);
        }


        ticketJPArepository.save(result);

        return "success";

    }

    @Override
    public String deleteTicketById(Long id) {
        TicketTable result=ticketJPArepository.findById(id).orElse(null);

        result.setIsDeleted(true);
        result.setIsPublic(false);

        ticketJPArepository.save(result);

        return "success";
    }




//    reduce boilerplate code

    public TicketTable getTicketFromId(Long id){
        return ticketJPArepository.findById(id).orElse(null);

    }


}
