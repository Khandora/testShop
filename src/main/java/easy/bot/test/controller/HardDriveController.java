package easy.bot.test.controller;

import easy.bot.test.entity.HardDrive;
import easy.bot.test.repository.HardDriveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/harddrives")
public class HardDriveController {
    @Autowired
    private HardDriveRepository hardDriveRepository;

    @GetMapping
    public List<HardDrive> getAllHardDrives() {
        return hardDriveRepository.findAll();
    }

    @GetMapping("/{id}")
    public HardDrive getHardDriveById(@PathVariable Long id) {
        return hardDriveRepository.findById(id).orElse(null);
    }

    @PostMapping
    public HardDrive addHardDrive(@RequestBody HardDrive hardDrive) {
        return hardDriveRepository.save(hardDrive);
    }

    @PutMapping("/{id}")
    public HardDrive updateHardDrive(@PathVariable Long id, @RequestBody HardDrive updatedHardDrive) {
        updatedHardDrive.setId(id);
        return hardDriveRepository.save(updatedHardDrive);
    }
}
