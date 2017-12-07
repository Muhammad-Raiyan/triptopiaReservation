package com.application.triptopia.Dao;

import com.application.triptopia.Entity.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeDao {
    Collection<Employee> getAllEmployee();

    void addEmployee(int key, Employee newEmployee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);

    void updateEmployee(Employee employee);

    void insertEmployeeToDB(Employee employee);

    Collection<Flight> getAllFlight();

    Collection<Reservation> getReservationsByFlightNumber(String airlineId, int flightNo);

    Collection<Reservation> getReservationsByCustomerName(String firstName, String lastName);

    Collection<SalesReport> getSalesReport(String date);

    Collection<Revenue> getRevenueByFlightNumber(String airlineId, int flightNo);

    Collection<Revenue> getRevenueByCity(String airlineId);

    Collection<Revenue> getRevenueByCustomer(int accountId);

    Collection<Employee> getCustomerRepOfMaxRevenue();

    List<Map<String, Object>> getMostActiveFlights();

    List<Map<String, Object>> getCustomersOnFlight(String airlineId, int flightNo, int legNo);
}
