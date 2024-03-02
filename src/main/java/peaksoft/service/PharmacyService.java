package peaksoft.service;

import peaksoft.entity.Medicine;
import peaksoft.entity.Pharmacy;

import java.util.List;

public interface PharmacyService {
    List<Pharmacy> findAll();

    Pharmacy save(Pharmacy pharmacy);

    Pharmacy update(Long id, Pharmacy pharmacy);

    void delete(Long id);

    List<Medicine> getMedicinesByPharmacy(Long id);
    Pharmacy getPharmacyByWorkerId(Long workerId);

    Pharmacy searchByName(String name);

    Pharmacy getPharmacyWithMostWorkers();
}
