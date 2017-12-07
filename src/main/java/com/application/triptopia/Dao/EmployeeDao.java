package com.application.triptopia.Dao;

import com.application.triptopia.Entity.Employee;
import com.application.triptopia.Entity.Flight;
import com.application.triptopia.Entity.Reservation;

import java.util.Collection;

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
}
