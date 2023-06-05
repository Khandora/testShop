package easy.bot.test.controller;

import easy.bot.test.entity.Monitor;
import easy.bot.test.repository.MonitorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitors")
public class MonitorController {
    private final MonitorRepository monitorRepository;

    public MonitorController(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    @GetMapping
    public List<Monitor> getAllMonitors() {
        return monitorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Monitor getMonitorById(@PathVariable Long id) {
        return monitorRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Monitor addMonitor(@RequestBody Monitor monitor) {
        return monitorRepository.save(monitor);
    }

    @PutMapping("/{id}")
    public Monitor updateMonitor(@PathVariable Long id, @RequestBody Monitor updatedMonitor) {
        updatedMonitor.setId(id);
        return monitorRepository.save(updatedMonitor);
    }
}
