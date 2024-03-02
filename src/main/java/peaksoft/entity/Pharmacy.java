package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "pharmacies")
@Getter
@Setter
@NoArgsConstructor
public class Pharmacy {

    @Id
    @GeneratedValue(generator = "pharmacy_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "pharmacy_gen", sequenceName = "pharmacy_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String address;
    private ZonedDateTime createdDate;
    private ZonedDateTime updatedDate;















    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "pharmacy")
    private List<Worker> workers;

    @OneToMany(cascade = {CascadeType.ALL},
            mappedBy = "pharmacy")
    private List<Medicine> medicines;

    @PrePersist
    public void prePersist() {
        this.createdDate = ZonedDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedDate = ZonedDateTime.now();
    }
}
