package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Medicine;
import peaksoft.repository.MedicineRepository;
import peaksoft.service.MedicineService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MedicineServiceImpl implements MedicineService {
    private final MedicineRepository medicineRepository;

    @Override
    public List<Medicine> findAll() {
        return medicineRepository.findAll();
    }

    @Override
    public void save(Medicine medicine) {
        medicineRepository.save(medicine);
    }

    @Override
    public Medicine findById(Long id) {
        return medicineRepository.findById(id).orElseThrow();
    }

    @Override
    public Medicine update(Long id, Medicine medicine) {
        Medicine findedMedicine = medicineRepository.findById(id).orElseThrow();
        findedMedicine.setName(medicine.getName());
        findedMedicine.setPrice(medicine.getPrice());
        return findedMedicine;
    }

    @Override
    public void delete(Long id) {
        Medicine medicine = medicineRepository.findById(id).orElseThrow();
        medicineRepository.delete(medicine);
    }

    @Override
    public List<Medicine> sortByName() {
        return medicineRepository.sortByName();
    }

    @Override
    public Medicine searchByName(String name) {
        return medicineRepository.searchByName(name);
    }
}
