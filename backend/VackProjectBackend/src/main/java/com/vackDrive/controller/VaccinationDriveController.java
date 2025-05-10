package com.vackDrive.controller;

import com.vackDrive.model.VaccinationDrive;
import com.vackDrive.repository.VaccinationDriveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/drives")
public class VaccinationDriveController {

    @Autowired
    private VaccinationDriveRepository repo;

    @GetMapping
    public ResponseEntity<List<VaccinationDrive>> getAll() {
        List<VaccinationDrive> drives = repo.findAll();
        int total = drives.size();
        return ResponseEntity
                .ok()
                .header("Content-Range", "drives 0-" + (total - 1) + "/" + total)
                .body(drives);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody VaccinationDrive drive) {
        if (drive.getDate().isBefore(LocalDateTime.now().plusDays(15))) {
            return ResponseEntity.badRequest().body("Drive must be scheduled at least 15 days in advance");
        }
        drive.setEditable(true);
        repo.save(drive);
        return ResponseEntity.ok("Drive created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody VaccinationDrive drive) {
        if (drive.getDate().isBefore(LocalDateTime.now())) {
            drive.setEditable(false);
            return ResponseEntity.badRequest().body("Cannot edit past drives");
        }
        drive.setId(id);
        repo.update(drive);
        return ResponseEntity.ok("Drive updated");
    }
}
