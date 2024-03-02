package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Worker;
import peaksoft.service.WorkerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/workers")
public class WorkerAPI {

    private final WorkerService workerService;

    @GetMapping("/findAll")
    public List<Worker> findAll(){
        return workerService.findAll();
    }

    @PostMapping("/{pharmacyId}")
    public Worker save(@PathVariable Long pharmacyId,
                       @RequestBody Worker worker) {
        Worker worker1 = null;
        try {
            worker1 = workerService.saveWorkerByPharmacyId(pharmacyId, worker);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return worker1;
    }

    @GetMapping("/findById")
    public Worker findById(@RequestParam Long id){
        try {
            return workerService.findById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @PutMapping("/update")
    public void update(@RequestParam Long id, @RequestBody Worker worker){
        try {
            workerService.update(id, worker);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        workerService.delete(id);
    }

    @GetMapping("/getSort")
    public List<Worker> sortBySalary(){
        return workerService.sortBySalary();
    }

    @GetMapping("/avgAge")
    public int averageAge(){
        return workerService.averageAge();
    }
}
