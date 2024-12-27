package by.barouski.online.store.entity;

import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;
@Entity
public class Buyer {
    @Id

    private long buyerId;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String email;

    public Buyer() {
    }

    public Buyer(long buyerId, String firstName, String lastName, long phoneNumber, String email) {
        this.buyerId = buyerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(long buyerId) {
        this.buyerId = buyerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
