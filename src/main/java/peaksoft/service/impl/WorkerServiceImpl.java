package peaksoft.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Pharmacy;
import peaksoft.entity.Worker;
import peaksoft.repository.PharmacyRepository;
import peaksoft.repository.WorkerRepository;
import peaksoft.service.WorkerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;
    private final PharmacyRepository pharmacyRepository;

    @Override
    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    @Override
    public Worker saveWorkerByPharmacyId(Long pharmacyId, Worker worker) {
        Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId).orElseThrow(
                () -> new EntityNotFoundException("Pharmacy with id " + pharmacyId + " not found!")
        );
        worker.setPharmacy(pharmacy);
        pharmacy.getWorkers().add(worker);
        return workerRepository.saveWorkerByPharmacyId(worker.getName(), worker.getEmail(), worker.getSalary(), worker.getAddress(), worker.getDateOfBirth(), pharmacyId);
    }

    @Override
    public Worker findById(Long id) {
        return workerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Pharmasy with id " + id + " not found!")
        );
    }

    @Override
    public void update(Long id, Worker worker) {
        Worker findedWorker = workerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Pharmasy with id " + id + " not found!")
        );
        findedWorker.setName(worker.getName());
        findedWorker.setEmail(worker.getEmail());
        findedWorker.setSalary(worker.getSalary());
        findedWorker.setAddress(worker.getAddress());
        findedWorker.setDateOfBirth(worker.getDateOfBirth());
    }

    @Override
    public void delete(Long id) {
        workerRepository.delete(findById(id));
    }

    @Override
    public List<Worker> sortBySalary() {
        return workerRepository.sortBySalary();
    }

    @Override
    public int averageAge() {
        return workerRepository.averageAge();
    }
}
