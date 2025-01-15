package com.example.hotelmanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "room_no", nullable = false)
    private Integer roomNo;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "contact_no", nullable = false)
    private String contactNo;

    @Column(name = "no_of_days", nullable = false)
    private Integer noOfDays;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Integer getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(Integer noOfDays) {
        this.noOfDays = noOfDays;
    }
}
