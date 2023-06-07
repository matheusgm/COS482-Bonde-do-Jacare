package org.agilekip.bondedojacare.process.vaccinationProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vaccination-process/task-application")
public class TaskApplicationController {

    private final Logger log = LoggerFactory.getLogger(TaskApplicationController.class);

    private final TaskApplicationService taskApplicationService;

    public TaskApplicationController(TaskApplicationService taskApplicationService) {
        this.taskApplicationService = taskApplicationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskApplicationContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskApplicationContextDTO taskApplicationContext = taskApplicationService.loadContext(id);
        return ResponseEntity.ok(taskApplicationContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskApplicationContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskApplicationContextDTO taskApplicationContext = taskApplicationService.claim(id);
        return ResponseEntity.ok(taskApplicationContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskApplicationContextDTO taskApplicationContext) {
        log.debug("REST request to complete VaccinationProcess.TaskApplication {}", taskApplicationContext.getTaskInstance().getId());
        taskApplicationService.complete(taskApplicationContext);
        return ResponseEntity.noContent().build();
    }
}
