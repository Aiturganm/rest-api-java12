package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Entity
@Table(name = "workers")
@Getter
@Setter
@NoArgsConstructor
public class Worker {

    @Id
    @GeneratedValue(generator = "worker_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "worker_gen", sequenceName = "worker_seq", allocationSize = 1)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;
    private int salary;
    private String address;
    private LocalDate dateOfBirth;
    private ZonedDateTime createdDate;
    private ZonedDateTime updatedDate;

    @ManyToOne
    private Pharmacy pharmacy;

    @PrePersist
    public void prePersist() {
        this.createdDate = ZonedDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedDate = ZonedDateTime.now();
    }
}
