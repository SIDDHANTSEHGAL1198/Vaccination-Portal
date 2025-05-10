package com.vackDrive.mapper;

import com.vackDrive.model.VaccinationDrive;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class VaccinationDriveRowMapper implements RowMapper<VaccinationDrive> {
    @Override
    public VaccinationDrive mapRow(ResultSet rs, int rowNum) throws SQLException {
        VaccinationDrive drive = new VaccinationDrive();
        drive.setId(rs.getInt("id"));
        drive.setVaccinationName(rs.getString("vaccinationName"));
        drive.setDate(rs.getTimestamp("date").toLocalDateTime());
        drive.setAvailableDoses(rs.getString("availableDoses"));
        drive.setApplicableClasses(rs.getString("applicableClasses"));
        drive.setEditable(rs.getBoolean("isEditable"));
        return drive;
    }
}
