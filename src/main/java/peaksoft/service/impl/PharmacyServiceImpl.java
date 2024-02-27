package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Pharmacy;
import peaksoft.repository.PharmacyRepository;
import peaksoft.service.PharmacyService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PharmacyServiceImpl implements PharmacyService {

    private final PharmacyRepository pharmacyRepository;

    @Override
    public List<Pharmacy> findAll() {
        return pharmacyRepository.findAll();
    }

    @Override
    public Pharmacy save(Pharmacy pharmacy) {
        return pharmacyRepository.save(pharmacy);
    }

    @Override
    public Pharmacy getPharmacyByWorkerId(Long workerId) {
        return pharmacyRepository.findByWorkerId(workerId);
    }

    @Override
    public Pharmacy searchByName(String name) {
        return pharmacyRepository.searchByName(name);
    }

    @Override
    public Pharmacy getPharmacyWithMostWorkers() {
        return null;
    }
}
