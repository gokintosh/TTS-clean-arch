package xyz.gokulnair.tickettracker.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xyz.gokulnair.tickettracker.infrastructure.tables.TicketTable;



@Repository
public interface TicketJPARepository extends JpaRepository<TicketTable,Long> {

    TicketTable findById(long id);


}
