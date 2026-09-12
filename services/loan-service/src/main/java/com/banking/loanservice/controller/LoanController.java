package com.banking.loanservice.controller;
import com.banking.loanservice.model.Loan;
import com.banking.loanservice.repository.LoanRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/loan")
public class LoanController {
    private final LoanRepository repository;
    public LoanController(LoanRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Loan> findAll() { return repository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> findById(@PathVariable Long id) {
        return repository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Loan create(@RequestBody Loan value) {
        return repository.save(value);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loan> update(@PathVariable Long id, @RequestBody Loan value) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        value.setId(id);
        return ResponseEntity.ok(repository.save(value));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
