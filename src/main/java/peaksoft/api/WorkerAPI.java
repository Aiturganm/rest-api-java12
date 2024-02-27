package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Worker;
import peaksoft.service.WorkerService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/workers")
public class WorkerAPI {

    private final WorkerService workerService;

    // findAll, update, delete

    @PostMapping("/{pharmacyId}")
    public Worker save(@PathVariable Long pharmacyId,
                       @RequestBody Worker worker) {
        return workerService.saveWorkerByPharmacyId(pharmacyId, worker);
    }
}
