package mk.ukim.finki.soaticketsusers.models.blog;

import mk.ukim.finki.soaticketsusers.models.BaseEntity;
import mk.ukim.finki.soaticketsusers.models.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by DarkoM on 08.12.2017.
 */

@Entity
@Table(name = "posts")
public class Post extends BaseEntity {
    private String title;

    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Comment> comments;

    private Date createdAt;

    protected Post(){
        comments = new ArrayList<>();
        createdAt = new Date();
    }

    public Post(String title, String content, User author) {
        this.title = title;
        this.content = content;
        this.author = author;
        comments = new ArrayList<>();
        createdAt = new Date();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
