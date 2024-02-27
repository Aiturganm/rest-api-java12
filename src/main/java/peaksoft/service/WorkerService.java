package peaksoft.service;

import peaksoft.entity.Worker;

public interface WorkerService {
    Worker saveWorkerByPharmacyId(Long pharmacyId, Worker worker);
}
