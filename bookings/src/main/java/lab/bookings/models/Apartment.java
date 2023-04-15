package lab.bookings.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;

import java.util.List;

@Entity
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Min(value = 1, message = "Value must be a positive integer")
    private int capacity;
    @OneToMany(mappedBy = "apartment")
    private List<Booking> bookings;

    public Long getId() {
        return id;
    }

    public Apartment setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Apartment setName(String name) {
        this.name = name;
        return this;
    }

    public int getCapacity() {
        return capacity;
    }

    public Apartment setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public Apartment setBookings(List<Booking> bookings) {
        this.bookings = bookings;
        return this;
    }
}
