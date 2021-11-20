package xyz.gokulnair.tickettracker.infrastructure.tables;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="ticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String decsription;

    @Column(name = "createAt")
    private LocalDate createdAt;

    @Column(name = "severity")
    private String severity;

    @Column(name = "status")
    private String status;


    @Column(name = "is_deleted", columnDefinition = "tinyint")
    private Boolean isDeleted;

    @Column(name = "is_public", columnDefinition = "tinyint")
    private Boolean isPublic;



}
