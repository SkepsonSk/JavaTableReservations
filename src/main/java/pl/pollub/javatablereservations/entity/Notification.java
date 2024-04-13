package pl.pollub.javatablereservations.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    private Date date;

    private String title;
    private String body;

    @ManyToOne
    private User user;

    public Notification() {}

    public Notification(String title, String body, User user) {
        this.date = new Date();
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public User getUser() {
        return user;
    }
}
