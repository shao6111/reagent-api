package com.myalltool.reagent_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.myalltool.reagent_api.model.Reagent;
import com.myalltool.reagent_api.repository.ReagentRepository;

@RestController
@RequestMapping("/api/reagents")
@CrossOrigin(origins = "*")
public class ReagentController {

    private final ReagentRepository reagentRepository;

    public ReagentController(ReagentRepository reagentRepository) {
        this.reagentRepository = reagentRepository;
    }
    
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteReagent(@PathVariable Long id) {
    if (!reagentRepository.existsById(id)) {
        return ResponseEntity.notFound().build();
    }

    reagentRepository.deleteById(id);
    return ResponseEntity.noContent().build();
}

    @GetMapping
    public List<Reagent> getAllReagents() {
        return reagentRepository.findAll();
    }

    @PostMapping
    public Reagent addReagent(@RequestBody Reagent reagent) {

    Reagent existing = reagentRepository
            .findByReagentNameAndLotNo(reagent.getReagentName(), reagent.getLotNo());

    if (existing != null) {
        existing.setQuantity(existing.getQuantity() + reagent.getQuantity());
        return reagentRepository.save(existing);
    }

    return reagentRepository.save(reagent);
}


    @PutMapping("/{id}/use")
    public Reagent useReagent(
            @PathVariable Long id,
            @RequestParam Integer amount
    ) {
        Reagent reagent = reagentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("找不到試劑資料"));

        int currentQuantity = reagent.getQuantity() == null ? 0 : reagent.getQuantity();

        if (amount == null || amount <= 0) {
            throw new RuntimeException("使用數量必須大於 0");
        }

        if (currentQuantity < amount) {
            throw new RuntimeException("庫存不足");
        }

        reagent.setQuantity(currentQuantity - amount);

        return reagentRepository.save(reagent);
    }


}