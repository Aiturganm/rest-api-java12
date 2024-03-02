package peaksoft.service;

import peaksoft.entity.Worker;

import java.util.List;

public interface WorkerService {
    List<Worker> findAll();

    Worker saveWorkerByPharmacyId(Long pharmacyId, Worker worker);

    Worker findById(Long id);

    void update(Long id, Worker worker);

    void delete(Long id);

    List<Worker> sortBySalary();

    int averageAge();
}
