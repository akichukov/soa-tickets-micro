package mk.ukim.finki.soaticketsusers.models.tickets;


import mk.ukim.finki.soaticketsusers.models.BaseEntity;
import mk.ukim.finki.soaticketsusers.models.events.Event;
import mk.ukim.finki.soaticketsusers.models.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bought_tickets")
public class BoughtTicket extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    private Date purchasedOn;

    protected BoughtTicket() {
        purchasedOn = new Date();
    }

    public BoughtTicket(User user, Ticket ticket) {
        this.user = user;
        this.ticket = ticket;
        this.event = ticket.getEvent();
        this.purchasedOn = new Date();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Date getPurchasedOn() {
        return purchasedOn;
    }

    public void setPurchasedOn(Date purchasedOn) {
        this.purchasedOn = purchasedOn;
    }
}
