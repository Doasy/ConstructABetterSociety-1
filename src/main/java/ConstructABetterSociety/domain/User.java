package ConstructABetterSociety.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User extends UriEntity<String> {

    @Id
    private String nickname;

    private String name;

    private String surname;

    private double rate;

    private long numberOfTimesRated;

    private int Coins;

    @Override
    public String getId() {
        return nickname;
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
        return Coins;
    }

    public void setCoins(int coins) {
        Coins = coins;
    }
}
