package com.application.triptopia.Dao;

import com.application.triptopia.Entity.Employee;
import com.application.triptopia.Entity.Person;
import com.sun.rowset.internal.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository("MySQLData")
public class MySqlEmployeeDao implements EmployeeDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class EmployeeRowMapper implements RowMapper<Employee>{

        @Override
        public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
            Employee employee = new Employee();
            employee.setFirstName(resultSet.getString("FirstName"));
            employee.setLastName(resultSet.getString("LastName"));
            employee.setAddress(resultSet.getString("Address"));
            employee.setCity(resultSet.getString("City"));
            employee.setState(resultSet.getString("State"));
            employee.setZipCode(resultSet.getInt("ZipCode"));
            employee.setZipCode(111);
            employee.setPersonId(resultSet.getInt("Id"));
            employee.setSsn(resultSet.getInt("SSN"));
            employee.setManager(resultSet.getBoolean("IsManager"));
            employee.setStartDate(resultSet.getString("StartDate"));
            employee.setHourlyRate(resultSet.getDouble("HourlyRate"));
            return employee;
        }
    }

    @Override
    public Collection<Employee> getAllEmployee() {

        final String sql = "SELECT * FROM reservation_schema.employee e, reservation_schema.person p WHERE p.Id = e.id";
        List<Employee> queryViewEmployees = jdbcTemplate.query(sql, new EmployeeRowMapper());
        return queryViewEmployees;
    }

    @Override
    public void addEmployee(int key, Employee newEmployee) {

    }

    @Override
    public Employee getEmployee(int id) {
        final String sql = "SELECT * FROM reservation_schema.employee em, reservation_schema.person p WHERE p.Id = em.id AND em.SSN = ?";
        Employee employee = jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        final String sql = "DELETE FROM Employee WHERE Employee.SSN = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateEmployee(Employee employee) {


    }

    @Override
    public void insertEmployeeToDB(Employee employee) {
        String sql = "INSERT INTO reservation_schema.Employee(Id,SSN,IsManager,StartDate,HourlyRate) VALUES (?, ?, ?, ?, ?)";
        DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        Date date = null;
        try {
            date = formatter.parse(employee.getStartDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jdbcTemplate.update(sql, employee.getPersonId(), employee.getSsn(), employee.isManager(), date, employee.getHourlyRate());
    }
}
