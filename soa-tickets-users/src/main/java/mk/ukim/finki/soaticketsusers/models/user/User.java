package mk.ukim.finki.soaticketsusers.models.user;

import mk.ukim.finki.soaticketsusers.models.BaseEntity;
import mk.ukim.finki.soaticketsusers.models.blog.Post;
import mk.ukim.finki.soaticketsusers.models.events.Event;
import mk.ukim.finki.soaticketsusers.models.support.SupportTicket;
import mk.ukim.finki.soaticketsusers.models.tickets.BoughtTicket;
import mk.ukim.finki.soaticketsusers.models.tickets.Invoice;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by DarkoM on 22.10.2017.
 */

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String firstName;
    private String lastName;

    private String password;
    @Column(unique = true)
    private String email;
    private String phoneNumber;
    private boolean isActive;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Event> ownedEvents;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BoughtTicket> boughtTickets;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Invoice> invoices;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(mappedBy = "userTo", cascade = CascadeType.ALL)
    private List<Notification> receivedNotifications;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<SupportTicket> supportTickets;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private List<Message> sendMessages;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private List<Message> receivedMessages;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    protected User(){
        this.boughtTickets = new ArrayList<>();
        this.ownedEvents = new ArrayList<>();
        this.roles = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.receivedNotifications = new ArrayList<>();
        this.supportTickets = new ArrayList<>();
        this.sendMessages = new ArrayList<>();
        this.receivedMessages = new ArrayList<>();
    }

    public User(String firstName, String lastName, String email, String password, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.isActive = true;
        this.boughtTickets = new ArrayList<>();
        this.ownedEvents = new ArrayList<>();
        this.roles = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.receivedNotifications = new ArrayList<>();
        this.supportTickets = new ArrayList<>();
        this.sendMessages = new ArrayList<>();
        this.receivedMessages = new ArrayList<>();
    }

    @Override
    public String toString(){
        return getFirstName() + " " + getLastName();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<BoughtTicket> getBoughtTickets() {
        return boughtTickets;
    }

    public void setBoughtTickets(List<BoughtTicket> boughtTickets) {
        this.boughtTickets = boughtTickets;
    }

    public List<Event> getOwnedEvents() {
        return ownedEvents;
    }

    public void setOwnedEvents(List<Event> ownedEvents) {
        this.ownedEvents = ownedEvents;
    }

    public List<String> getRoles() {
        List<String> roleNames = roles.stream().map(Role::getName).collect(Collectors.toList());

        return roleNames;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role){
        this.roles.add(role);
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Notification> getReceivedNotifications() {
        return receivedNotifications;
    }

    public void setReceivedNotifications(List<Notification> receivedNotifications) {
        this.receivedNotifications = receivedNotifications;
    }

    public List<Message> getSendMessages() {
        return sendMessages;
    }

    public void setSendMessages(List<Message> sendMessages) {
        this.sendMessages = sendMessages;
    }

    public List<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(List<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    public List<SupportTicket> getSupportTickets() {
        return supportTickets;
    }

    public void setSupportTickets(List<SupportTicket> supportTickets) {
        this.supportTickets = supportTickets;
    }
}
