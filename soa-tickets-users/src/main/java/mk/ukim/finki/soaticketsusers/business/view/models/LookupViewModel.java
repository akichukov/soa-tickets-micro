package mk.ukim.finki.soaticketsusers.business.view.models;

public class LookupViewModel<T> {
    private T id;
    private String name;

    public LookupViewModel(T id, String name) {
        this.id = id;
        this.name = name;
    }

    public T getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
