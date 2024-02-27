package peaksoft.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Pharmacy;
import peaksoft.entity.Worker;
import peaksoft.repository.PharmacyRepository;
import peaksoft.repository.WorkerRepository;
import peaksoft.service.WorkerService;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;
    private final PharmacyRepository pharmacyRepository;

    @Override
    public Worker saveWorkerByPharmacyId(Long pharmacyId, Worker worker) {
        Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId).orElseThrow(
                () -> new EntityNotFoundException("Pharmacy with id " + pharmacyId + " not found!")
        );

        worker.setPharmacy(pharmacy);
        pharmacy.getWorkers().add(worker);
        return workerRepository.save(worker);
    }
}
