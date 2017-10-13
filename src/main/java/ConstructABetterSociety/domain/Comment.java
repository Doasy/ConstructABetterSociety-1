package ConstructABetterSociety.domain;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Comment extends UriEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private Place place;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private User user;

    private String type;

    @Override
    public Long getId() {
        return id;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
