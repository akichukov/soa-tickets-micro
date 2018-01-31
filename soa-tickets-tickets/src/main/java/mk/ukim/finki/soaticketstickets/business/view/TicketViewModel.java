package mk.ukim.finki.soaticketstickets.business.view;


public class TicketViewModel {

    private long id;
    private EventViewModel event;
    private float price;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public EventViewModel getEvent() {
        return event;
    }

    public void setEvent(EventViewModel event) {
        this.event = event;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}