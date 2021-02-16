package com.company.OOP.Example5;
import java.time.*;
public class Ticket {
    private PublicTransport publicTransport;
    private LocalDate localDate;
    private LocalDate validUntil;

    public Ticket(PublicTransport publicTransport, LocalDate localDate, LocalDate validUntil) {
        this.publicTransport = publicTransport;
        this.localDate = localDate;
        this.validUntil = validUntil;
    }

    public PublicTransport isPublicTransport() {
        return publicTransport;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }
}
