package com.vackDrive.mapper;

import com.vackDrive.model.Student;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

    @Component
    public class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student s = new Student();
            s.setId(rs.getLong("id"));
            s.setName(rs.getString("name"));
            s.setClassName(rs.getString("className"));
            s.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
            s.setVaccinated(rs.getInt("isVaccinated") == 1 );
            s.setVaccineName(rs.getString("vaccineName"));
            s.setDateofVaccination(rs.getDate("dateofVaccination").toLocalDate());

            return s;
        }
    }


