package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Pharmacy;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

    @Query("select p from Pharmacy p inner join p.workers w on w.id = :workerId")
    Pharmacy findByWorkerId(Long workerId);

    Pharmacy searchByName(String name);

//    @Query("select p from Pharmacy p where p.workers.size=(select max(p2.workers.size) from Pharmacy p2)")
//////    @Query(value = "select p from pharmacies p where p.id = (select p.id from workers w inner join )", nativeQuery = true)
//    Pharmacy findPharmacyWithMostWorkers();

}