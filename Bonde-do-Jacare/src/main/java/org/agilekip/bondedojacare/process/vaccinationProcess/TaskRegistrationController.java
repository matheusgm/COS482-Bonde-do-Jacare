package org.agilekip.bondedojacare.process.vaccinationProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vaccination-process/task-registration")
public class TaskRegistrationController {

    private final Logger log = LoggerFactory.getLogger(TaskRegistrationController.class);

    private final TaskRegistrationService taskRegistrationService;

    public TaskRegistrationController(TaskRegistrationService taskRegistrationService) {
        this.taskRegistrationService = taskRegistrationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskRegistrationContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskRegistrationContextDTO taskRegistrationContext = taskRegistrationService.loadContext(id);
        return ResponseEntity.ok(taskRegistrationContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskRegistrationContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskRegistrationContextDTO taskRegistrationContext = taskRegistrationService.claim(id);
        return ResponseEntity.ok(taskRegistrationContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskRegistrationContextDTO taskRegistrationContext) {
        log.debug("REST request to complete VaccinationProcess.TaskRegistration {}", taskRegistrationContext.getTaskInstance().getId());
        taskRegistrationService.complete(taskRegistrationContext);
        return ResponseEntity.noContent().build();
    }
}
