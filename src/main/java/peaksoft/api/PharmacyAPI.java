package peaksoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Medicine;
import peaksoft.entity.Pharmacy;
import peaksoft.service.PharmacyService;

import java.util.List;

@RestController
@RequestMapping("/api/pharmacies")
public class PharmacyAPI {

    @Autowired
    private PharmacyService pharmacyService;

    @GetMapping
    public List<Pharmacy> findAllPharmacy() {
        return pharmacyService.findAll();
    }

    @PostMapping
    public Pharmacy save(@RequestBody Pharmacy pharmacy) {
        return pharmacyService.save(pharmacy);
    }

    @PutMapping("/update")
    public Pharmacy update(@RequestParam Long id, @RequestBody Pharmacy pharmacy){
        try {
            return pharmacyService.update(id, pharmacy);
        } catch (Exception e) {
            System.out.println(new RuntimeException(e).getMessage());
        }
        return null;
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        try {
            pharmacyService.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @GetMapping("/getMed")
    public List<Medicine> getMedicines(@RequestParam Long id){
        return pharmacyService.getMedicinesByPharmacy(id);
    }

    @GetMapping("/worker-pharmacy/{workerId}")
    public Pharmacy getPharmacyByWorkerId(@PathVariable Long workerId) {
        return pharmacyService.getPharmacyByWorkerId(workerId);
    }

    @GetMapping("/search")
    public Pharmacy searchByName(@RequestParam String name) {
        return pharmacyService.searchByName(name);
    }

    @GetMapping("/max-worker")
    public Pharmacy getPharmacyWithMostWorkers() {
        return pharmacyService.getPharmacyWithMostWorkers();
    }


}
