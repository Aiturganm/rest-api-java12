package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Worker;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

    @Query(value = "insert into workers(name, email, salary, address, date_of_birth, pharmacy_id) values (:name, :email, :salary, :address, :date_of_birth, :pharmacyId)", nativeQuery = true)
    Worker saveWorkerByPharmacyId(String name, String email, int salary, String address, LocalDate date_of_birth, Long pharmacyId);

    @Query("select w from Worker w order by w.salary desc")
    List<Worker> sortBySalary();

    @Query("select avg(function('DATEDIFF', current_date , w.dateOfBirth) ) from Worker w")
    int averageAge();
}