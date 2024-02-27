package peaksoft.service;

import peaksoft.entity.Pharmacy;

import java.util.List;

public interface PharmacyService {
    List<Pharmacy> findAll();

    Pharmacy save(Pharmacy pharmacy);

    Pharmacy getPharmacyByWorkerId(Long workerId);

    Pharmacy searchByName(String name);

    Pharmacy getPharmacyWithMostWorkers();
}
