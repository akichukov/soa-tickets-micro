package mk.ukim.finki.soaticketsusers.business.view.models.user;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UpdateUserViewModel extends RegisterUserViewModel {
    @NotNull
    @Min(1)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}