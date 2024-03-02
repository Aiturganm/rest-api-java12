package peaksoft.service;

import peaksoft.entity.Medicine;

import java.util.List;

public interface MedicineService {
    List<Medicine> findAll();
    void save(Medicine medicine);
    Medicine findById(Long id);
    Medicine update(Long id, Medicine medicine);
    void delete(Long id);
    List<Medicine> sortByName();
    Medicine searchByName(String name);
}
