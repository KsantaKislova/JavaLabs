package by.gsu.pms.beans;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    private String name;
    private Date date;
    private String passportNumber;
    @Enumerated(EnumType.ORDINAL)
    private FlightClass flightClass;

    public Registration() {
    }

    public Registration(User user, String name, Date date, String passportNumber, FlightClass flightClass) {
        this.user = user;
        this.name = name;
        this.date = date;
        this.passportNumber = passportNumber;
        this.flightClass = flightClass;
    }


    public Registration(User user, String name, Date date) {
        this.user = user;
        this.name = name;
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserId() {
        return user.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public FlightClass getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(FlightClass flightClass) {
        this.flightClass = flightClass;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", passportNumber='" + passportNumber + '\'' +
                ", flightClass=" + flightClass +
                '}';
    }
}

