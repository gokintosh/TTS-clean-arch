package xyz.gokulnair.tickettracker.core.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Ticket {
    private final Long id;
    private final String title;
    private final String description;
    private final LocalDate createdAt;
    private String severity;
    private String status;
    private boolean isDeleted;
    private final boolean isPublic;


    public boolean canShow(){
        return !isDeleted && isPublic;
    }

    public void delete(){
        this.isDeleted=true;
    }



}
