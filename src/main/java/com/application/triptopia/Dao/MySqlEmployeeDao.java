package com.application.triptopia.Dao;

import com.application.triptopia.Entity.Employee;
import com.application.triptopia.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("MySQLData")
public class MySqlEmployeeDao implements EmployeeDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Collection<Employee> getAllEmployee() {

        final String sql = "SELECT * FROM reservation_schema.employee e, reservation_schema.person p WHERE p.Id = e.id";
        KeyHolder holder = new GeneratedKeyHolder();
        List<Employee> queryViewEmployees = jdbcTemplate.query(sql, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setFirstName(resultSet.getString("FirstName"));
                employee.setLastName(resultSet.getString("LastName"));
                employee.setAddress(resultSet.getString("Address"));
                employee.setCity(resultSet.getString("City"));
                employee.setState(resultSet.getString("State"));
                employee.setZipCode(resultSet.getInt("ZipCode"));
/*
                employee.setFirstName("fName");
                employee.setLastName("lName");
                employee.setAddress("address");
                employee.setCity("city");
                employee.setState("State");
*/
                employee.setZipCode(111);
                employee.setPersonId(resultSet.getInt("Id"));
                employee.setSsn(resultSet.getInt("SSN"));
                employee.setManager(resultSet.getBoolean("IsManager"));
                employee.setStartDate(resultSet.getString("StartDate"));
                employee.setHourlyRate(resultSet.getDouble("HourlyRate"));
                return employee;
            }
        });
        return queryViewEmployees;
    }

    @Override
    public void addEmployee(int key, Employee newEmployee) {

    }

    @Override
    public Employee getEmployee(int id) {
        return null;
    }

    @Override
    public void deleteEmployee(int id) {

    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void insertEmployeeToDB(Employee employee) {

    }
}
