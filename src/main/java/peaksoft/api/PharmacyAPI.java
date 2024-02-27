package peaksoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    // findById, update and delete methods

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
