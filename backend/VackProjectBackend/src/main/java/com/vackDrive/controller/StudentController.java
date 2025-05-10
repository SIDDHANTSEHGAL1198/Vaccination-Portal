package com.vackDrive.controller;

import com.vackDrive.model.Student;
import com.vackDrive.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = repository.findAll();
        int total = students.size();

        return ResponseEntity
                .ok()
                .header("Content-Range", "students 0-" + (students.size() - 1) + "/" + total)
                .body(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Long id) {
        Student student = repository.findById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }


    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        repository.save(student);
        return ResponseEntity.ok("Student created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        repository.update(student);
        return ResponseEntity.ok("Student updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        repository.delete(id);
        return ResponseEntity.ok("Student deleted");
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadCSV(@RequestParam("file") MultipartFile file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 3) {
                    Student student = new Student();
                    student.setName(data[0].trim());
                    student.setClassName(data[1].trim());
                    student.setDateOfBirth(LocalDate.parse(data[2].trim()));
                    student.setVaccinated(false);
                    repository.save(student);
                }
            }
            return ResponseEntity.ok("Bulk upload successful");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Upload failed");
        }
    }

    @GetMapping("/report")
    public ResponseEntity<List<Student>> getVaccinatedReport(@RequestParam(required = false) String vaccineName) {
        List<Student> report = (vaccineName != null)
                ? repository.findByVaccineName(vaccineName)
                : repository.findAllVaccinated();

        int total = report.size();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Range", "students 0-" + (total - 1) + "/" + total);
        headers.add("Access-Control-Expose-Headers", "Content-Range");

        return new ResponseEntity<>(report, headers, HttpStatus.OK);
    }



}
