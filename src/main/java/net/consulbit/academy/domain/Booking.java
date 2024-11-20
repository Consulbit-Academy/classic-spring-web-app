package net.consulbit.academy.domain;

import lombok.Getter;
import lombok.Value;

import javax.persistence.*;

@Entity
@Table(schema = "test", name = "bookings")
@Getter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "from_location")
    private String fromLocation;
    @Column(name = "to_location")
    private String toLocation;

    public Booking() {
    }

    public Booking(Integer id, String from, String to) {
        this.id = id;
        this.fromLocation = from;
        this.toLocation = to;
    }
}