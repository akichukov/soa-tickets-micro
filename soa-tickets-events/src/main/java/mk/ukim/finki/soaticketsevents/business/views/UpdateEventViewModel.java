package mk.ukim.finki.soaticketsevents.business.views;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UpdateEventViewModel extends CreateEventViewModel {

    @NotNull
    @Min(1)
    private long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}