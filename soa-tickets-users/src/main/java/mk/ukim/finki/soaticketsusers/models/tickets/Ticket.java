package mk.ukim.finki.soaticketsusers.models.tickets;

import javax.persistence.*;

import mk.ukim.finki.soaticketsusers.models.BaseEntity;
import mk.ukim.finki.soaticketsusers.models.events.Event;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    private float price;

    protected Ticket() { }

    public Ticket(Event event, float price) {
        this.event = event;
        this.price = price;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
