package easy.bot.test.controller;

import easy.bot.test.entity.Notebook;
import easy.bot.test.repository.NotebookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notebooks")
public class NotebookController {
    private final NotebookRepository notebookRepository;

    public NotebookController(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    @GetMapping
    public List<Notebook> getAllNotebooks() {
        return notebookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Notebook getNotebookById(@PathVariable Long id) {
        return notebookRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Notebook addNotebook(@RequestBody Notebook notebook) {
        return notebookRepository.save(notebook);
    }

    @PutMapping("/{id}")
    public Notebook updateNotebook(@PathVariable Long id, @RequestBody Notebook updatedNotebook) {
        updatedNotebook.setId(id);
        return notebookRepository.save(updatedNotebook);
    }
}