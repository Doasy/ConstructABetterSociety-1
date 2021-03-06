package ConstructABetterSociety.domain;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import javax.persistence.*;

@Entity
public class City extends UriEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private State state;

    private String name;

    public City() {}

    public City(State state, String name) {
        this.state = state;
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
