package com.vackDrive.repository;

import com.vackDrive.mapper.StudentRowMapper;
import com.vackDrive.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StudentRowMapper rowMapper;

    public List<Student> findAll() {
        return jdbcTemplate.query("SELECT * FROM student", rowMapper);
    }

    public Student findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM student WHERE id = ?", rowMapper, id);
    }

    public int save(Student student) {
        return jdbcTemplate.update("INSERT INTO student(name, className, dateOfBirth, isVaccinated) VALUES(?,?,?,?)",
                student.getName(), student.getClassName(), Date.valueOf(student.getDateOfBirth()), student.getVaccinated());
    }

    public int update(Student student) {
        return jdbcTemplate.update("UPDATE student SET name=?, className=?, dateOfBirth=?, isVaccinated=? WHERE id=?",
                student.getName(), student.getClassName(), Date.valueOf(student.getDateOfBirth()), student.getVaccinated(), student.getId());
    }

    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM student WHERE id=?", id);
    }

    public List<Student> findAllVaccinated() {
        return jdbcTemplate.query("SELECT * FROM student WHERE isVaccinated = 1", rowMapper);
    }

    public List<Student> findByVaccineName(String vaccine) {
        return jdbcTemplate.query("SELECT * FROM student WHERE isVaccinated = 1 AND vaccineName = ?", rowMapper, vaccine);
    }

}
