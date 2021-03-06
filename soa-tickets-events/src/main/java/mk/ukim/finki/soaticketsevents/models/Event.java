package mk.ukim.finki.soaticketsevents.models;

import org.h2.command.ddl.Analyze;
import org.jboss.logging.Field;

import javax.persistence.*;
import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
public class Event extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Field
    private String name;

    @Field
    private String description;

    @Field
    private String location;

    private Date date;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<BoughtTicket> boughtTickets;

    protected Event() {}

    public Event(User owner, String name, String description, String location, Date date) {
        this.owner = owner;
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;

        this.tickets = new ArrayList<>();
        this.boughtTickets = new ArrayList<>();
    }

    public User getOwner() { return owner; }

    public void setOwner(User owner) { this.owner = owner; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<BoughtTicket> getBoughtTickets() {
        return boughtTickets;
    }

    public void setBoughtTickets(List<BoughtTicket> boughtTickets) {
        this.boughtTickets = boughtTickets;
    }
}