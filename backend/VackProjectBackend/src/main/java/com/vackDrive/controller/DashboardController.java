package com.vackDrive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getDashboardData() {
        Map<String, Object> response = new HashMap<>();

        Integer totalStudents = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM student", Integer.class);
        Integer vaccinatedStudents = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM students WHERE isVaccinated = 1", Integer.class);

        List<Map<String, Object>> upcomingDrives = jdbcTemplate.queryForList("SELECT * FROM VaccinationDrive WHERE drive_date >= CURRENT_DATE");

        response.put("totalStudents", totalStudents);
        response.put("vaccinatedStudents", vaccinatedStudents);
        response.put("upcomingDrives", upcomingDrives);

        return ResponseEntity.ok(response);
    }

}
