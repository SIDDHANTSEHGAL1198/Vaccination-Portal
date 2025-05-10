package com.vackDrive.repository;

import com.vackDrive.mapper.VaccinationDriveRowMapper;
import com.vackDrive.model.VaccinationDrive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class VaccinationDriveRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final VaccinationDriveRowMapper rowMapper = new VaccinationDriveRowMapper();

    public List<VaccinationDrive> findAll() {
        return jdbcTemplate.query("SELECT * FROM VaccinationDrive", rowMapper);
    }

    public VaccinationDrive findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM VaccinationDrive WHERE id = ?", rowMapper, id);
    }

    public void save(VaccinationDrive drive) {
        jdbcTemplate.update(
                "INSERT INTO VaccinationDrive (id, vaccinationName, date, availableDoses, applicableClasses, isEditable) VALUES (?, ?, ?, ?, ?, ?)",
                drive.getId(),
                drive.getVaccinationName(),
                Timestamp.valueOf(drive.getDate()),
                drive.getAvailableDoses(),
                drive.getApplicableClasses(),
                drive.isEditable() ? 1 : 0
        );
    }

    public void update(VaccinationDrive drive) {
        jdbcTemplate.update(
                "UPDATE VaccinationDrive SET date=?, availableDoses=?, isEditable=? WHERE id=?",
                Timestamp.valueOf(drive.getDate()),
                drive.getAvailableDoses(),
                drive.isEditable() ? 1 : 0,
                drive.getId()
        );
    }
}
