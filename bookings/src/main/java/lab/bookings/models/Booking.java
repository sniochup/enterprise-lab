package lab.bookings.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Apartment apartment;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fromDate;
    private LocalDate toDate;
    @Min(value = 1)
    @Max(value = 366)
    private Integer numDays = 1;
    @Min(value = 1)
    private Integer numGuests = 1;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;

    @PrePersist
    private void onPrePersist() {
        toDate = fromDate.plusDays(numDays);
    }

    public Long getId() {
        return id;
    }

    public Booking setId(Long id) {
        this.id = id;
        return this;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public Booking setApartment(Apartment apartment) {
        this.apartment = apartment;
        return this;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public Booking setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    public LocalDate getToDate() {
        return fromDate.plusDays(numDays);
    }

    public Booking setToDate(LocalDate toDate) {
        this.toDate = toDate;
        return this;
    }

    public Integer getNumDays() {
        return numDays;
    }

    public Booking setNumDays(Integer numDays) {
        this.numDays = numDays;
        return this;
    }

    public Integer getNumGuests() {
        return numGuests;
    }

    public Booking setNumGuests(Integer numGuests) {
        this.numGuests = numGuests;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Booking setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Booking setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}