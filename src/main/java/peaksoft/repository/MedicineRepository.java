package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}