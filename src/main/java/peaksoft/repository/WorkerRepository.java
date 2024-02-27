package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}