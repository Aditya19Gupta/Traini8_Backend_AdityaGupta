package com.adi.dum.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "training_center")
public class TrainingCenter {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    Long id;

    @Column(name = "center_name", nullable = false, length = 40)
    private String centerName;

    @Column(name = "center_code", nullable = false, length = 12, unique = true)
    private String centerCode;

    @Column(name = "student_capacity")
    private Integer studentCapacity;

    @ElementCollection
    @CollectionTable(name = "training_center_courses", joinColumns = @JoinColumn(name = "center_id"))
    @Column(name = "course")
    private List<String> coursesOffered;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "contact_phone", nullable = false, length = 10)
    private String contactPhone;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_on", updatable = false)
    private Date createdOn;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "address_id", nullable = true)
    private Address address;

    @PrePersist
    protected void onCreate() {
        this.createdOn = new Date(); // Automatically set createdOn
    }
}
