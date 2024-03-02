package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Medicine;
import peaksoft.entity.Pharmacy;

import java.util.List;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

    @Query("select m from Medicine m where m.pharmacy.id = :id")
    List<Medicine> getMedicinesByPharmacy(Long id);

    @Query("select p from Pharmacy p order by size(p.workers) desc")
    Pharmacy getPharmacyWithMostWorkers();

    @Query("select p from Pharmacy p inner join p.workers w on w.id = :workerId")
    Pharmacy findByWorkerId(Long workerId);

    @Query("select p from Pharmacy p where p.name ilike (:name)")
    Pharmacy searchByName(String name);

}