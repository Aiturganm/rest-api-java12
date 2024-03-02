package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Medicine;
import peaksoft.service.MedicineService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/medicines")
public class MedicineAPI {
    private final MedicineService medicineService;
    @GetMapping("/findAll")
    public List<Medicine> findAll(){
        return medicineService.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Medicine medicine){
        medicineService.save(medicine);
    }

    @GetMapping("/findById")
    public Medicine findById(@RequestParam Long id){
        try {
            return medicineService.findById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @PutMapping("/update")
    public Medicine update(@RequestParam Long id, @RequestBody Medicine medicine){
        Medicine medicine1 = null;
        try {
            medicine1 = medicineService.update(id, medicine);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return medicine1;
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        try {
            medicineService.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @GetMapping("/getSort")
    public List<Medicine> sortByName(){
        return medicineService.sortByName();
    }

    @GetMapping("/getByName")
    public Medicine searchByName(@PathVariable String name){
        return medicineService.searchByName(name);
    }
}
