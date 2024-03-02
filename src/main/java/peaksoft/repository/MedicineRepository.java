package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Medicine;

import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    @Query(value = "select * from medicines m order by m.name asc )", nativeQuery = true)
    List<Medicine> sortByName();

    @Query("select m from Medicine m where m.name ilike (:name)")
    Medicine searchByName(String name);
}