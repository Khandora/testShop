package easy.bot.test.controller;

import easy.bot.test.entity.DesktopComputer;
import easy.bot.test.repository.DesktopComputerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desktops")
public class DesktopComputerController {
    private final DesktopComputerRepository desktopComputerRepository;

    public DesktopComputerController(DesktopComputerRepository desktopComputerRepository) {
        this.desktopComputerRepository = desktopComputerRepository;
    }

    @GetMapping
    public List<DesktopComputer> getAllDesktopComputers() {
        return desktopComputerRepository.findAll();
    }

    @GetMapping("/{id}")
    public DesktopComputer getDesktopComputerById(@PathVariable Long id) {
        return desktopComputerRepository.findById(id).orElse(null);
    }

    @PostMapping
    public DesktopComputer addDesktopComputer(@RequestBody DesktopComputer desktopComputer) {
        return desktopComputerRepository.save(desktopComputer);
    }

    @PutMapping("/{id}")
    public DesktopComputer updateDesktopComputer(@PathVariable Long id, @RequestBody DesktopComputer updatedDesktopComputer) {
        updatedDesktopComputer.setId(id);
        return desktopComputerRepository.save(updatedDesktopComputer);
    }
}
