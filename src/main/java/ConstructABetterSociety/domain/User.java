package ConstructABetterSociety.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User extends UriEntity<String> {

    @Id
    private String nickname;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String email;

    private String name;

    private String surname;

    private double rate;

    private long numberOfTimesRated;

    private int coins;

    public User() {}

    public User(String nickname, String password, String email, String name, String surname, double rate, long numberOfTimesRated, int coins) {
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.rate = rate;
        this.numberOfTimesRated = numberOfTimesRated;
        this.coins = coins;
    }

    @Override
    public String getId() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public long getNumberOfTimesRated() {
        return numberOfTimesRated;
    }

    public void setNumberOfTimesRated(long numberOfTimesRated) {
        this.numberOfTimesRated = numberOfTimesRated;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
