package com.application.triptopia.Dao;

import com.application.triptopia.Entity.Employee;
import com.application.triptopia.Entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

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

    private static class FlightRowMapper implements RowMapper<Flight>{
        @Override
        public Flight mapRow(ResultSet resultSet, int i) throws SQLException {
            Flight flight = new Flight();
            flight.setAirlineId(resultSet.getString("airlineId"));
            flight.setFlightNo(resultSet.getInt("flightNo"));
            flight.setNoOfSeats(resultSet.getInt("noOfSeats"));
            flight.setDaysOperating(resultSet.getString("daysOperating"));
            flight.setMaxLengthOfStay(resultSet.getInt("maxLengthOfStay"));
            flight.setMinLengthOfStay(resultSet.getInt("minLengthOfStay"));
            return flight;
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
        final String sql = "UPDATE Employee\n" +
                "    SET Employee.IsManager=?, Employee.StartDate=?, Employee.HourlyRate=?\n" +
                "    WHERE Employee.SSN=?";
        Object[] param = new Object[]{employee.isManager(), employee.getStartDate(), employee.getHourlyRate(), employee.getSsn()};
        jdbcTemplate.update(sql, param);
    }

    @Override
    public void insertEmployeeToDB(Employee employee) {
        String sqlAddPerson = "INSERT INTO Person(FirstName,LastName,Address,City,State,ZipCode)\n" +
                "    values(?,?,?,?,?,?);";

        KeyHolder key = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sqlAddPerson, new String[]{"firstName", "lastName", "address", "city", "state", "zipCode" });
                ps.setString(1, employee.getFirstName());
                ps.setString(2, employee.getLastName());
                ps.setString(3, employee.getAddress());
                ps.setString(4, employee.getCity());
                ps.setString(5, employee.getState());
                ps.setInt(6, employee.getZipCode());
                return ps;
            }
        }, key);

        String sql = "INSERT INTO reservation_schema.Employee(Id,SSN,IsManager,StartDate,HourlyRate) VALUES (?, ?, ?, ?, ?)";
        DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        Date date = null;
        try {
            date = formatter.parse(employee.getStartDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jdbcTemplate.update(sql, key.getKey(), employee.getSsn(), employee.isManager(), date, employee.getHourlyRate());
    }

    @Override
    public Collection<Flight> getAllFlight() {
        String sql = " SELECT * FROM Flight";
        List<Flight> query = jdbcTemplate.query(sql, new FlightRowMapper());
        return query;
    }
}
