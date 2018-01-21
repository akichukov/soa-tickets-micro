package mk.ukim.finki.soaticketsusers.business.view.models.user;

import mk.ukim.finki.soaticketsusers.business.view.models.LookupViewModel;

public class NotificationViewModel {
    private String content;
    private LookupViewModel<Long> userFrom;
    private String createdAt;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LookupViewModel<Long> getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(LookupViewModel<Long> userFrom) {
        this.userFrom = userFrom;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
