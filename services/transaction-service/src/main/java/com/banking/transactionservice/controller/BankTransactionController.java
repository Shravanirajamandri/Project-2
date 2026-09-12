package com.banking.transactionservice.controller;
import com.banking.transactionservice.model.BankTransaction;
import com.banking.transactionservice.repository.BankTransactionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/transaction")
public class BankTransactionController {
    private final BankTransactionRepository repository;
    public BankTransactionController(BankTransactionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<BankTransaction> findAll() { return repository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<BankTransaction> findById(@PathVariable Long id) {
        return repository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BankTransaction create(@RequestBody BankTransaction value) {
        return repository.save(value);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankTransaction> update(@PathVariable Long id, @RequestBody BankTransaction value) {
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
