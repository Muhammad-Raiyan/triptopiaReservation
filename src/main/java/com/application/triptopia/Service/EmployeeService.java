package com.application.triptopia.Service;

import com.application.triptopia.Dao.EmployeeDao;
import com.application.triptopia.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Qualifier("MySQLData")
public class EmployeeService {

    @Qualifier("MySQLData")
    @Autowired
    private EmployeeDao employeeDao;

    public Collection<Employee> getAllEmployee(){
        return employeeDao.getAllEmployee();
    }

    public Employee getEmployee(int id){
        return this.employeeDao.getEmployee(id);
    }

    public void deleteEmployee(int id) {
        this.employeeDao.deleteEmployee(id);
    }

    public void updateEmployee(Employee employee){
        this.employeeDao.updateEmployee(employee);
    }

    public void insertEmployee(Employee employee) {
        this.employeeDao.insertEmployeeToDB(employee);
    }

    public Collection<Flight> getAllFlights(){
        return this.employeeDao.getAllFlight();
    }

    public Collection<Reservation> getReservationsByFlightNumber(String airlineId, int flightNo) {
        return this.employeeDao.getReservationsByFlightNumber(airlineId, flightNo);
    }

    public Collection<Reservation> getReservationsByCustomerName(String firstName, String lastName) {
        return this.employeeDao.getReservationsByCustomerName(firstName, lastName);
    }


    public Collection<SalesReport> getSalesReport(String date) {
        return this.employeeDao.getSalesReport(date);
    }

    public Collection<Revenue> getRevenueByFlightNumber(String airlineId, int flightNo) {
        return this.employeeDao.getRevenueByFlightNumber(airlineId, flightNo);
    }

    public Collection<Revenue> getRevenueByCity(String airlineId) {
        return this.employeeDao.getRevenueByCity(airlineId);
    }

    public Collection<Revenue> getRevenueByCustomer(int accountId) {
        return this.employeeDao.getRevenueByCustomer(accountId);
    }
}
