package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Medicine;
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
    public Pharmacy update(Long id, Pharmacy pharmacy) {
        Pharmacy pharmacy1 = pharmacyRepository.findById(id).orElseThrow();
        pharmacy1.setName(pharmacy.getName());
        pharmacy1.setAddress(pharmacy.getAddress());
        return pharmacy1;
    }

    @Override
    public void delete(Long id) {
        pharmacyRepository.delete(pharmacyRepository.findById(id).orElseThrow());
    }

    @Override
    public List<Medicine> getMedicinesByPharmacy(Long id) {
        return pharmacyRepository.getMedicinesByPharmacy(id);
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
        return pharmacyRepository.getPharmacyWithMostWorkers();
    }
}
