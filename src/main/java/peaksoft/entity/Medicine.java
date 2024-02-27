package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "medicines")
@Getter
@Setter
@NoArgsConstructor
public class Medicine {

    @Id
    @GeneratedValue(generator = "medicine_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "medicine_gen", sequenceName = "medicine_seq", allocationSize = 1)
    private Long id;
    private String name;
    private BigDecimal price;
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
