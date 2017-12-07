package com.application.triptopia.Controller;

import com.application.triptopia.Entity.*;
import com.application.triptopia.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/allEmployees", method = RequestMethod.GET)
    public Collection<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable("id") int id){
        return this.employeeService.getEmployee(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable("id") int id){
        employeeService.deleteEmployee(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertEmployee(@RequestBody Employee employee){
        System.out.println("IN insert employee");
        employeeService.insertEmployee(employee);
    }

    @RequestMapping(value="/allFlights", method = RequestMethod.GET)
    public Collection<Flight> getListOfFlight(){
        return employeeService.getAllFlights();
    }

    @RequestMapping(value="/reservationsByFlightNumber/{airlineId}/{flightNo}", method = RequestMethod.GET)
    public Collection<Reservation> getReservationsByFlightNumber(@PathVariable("airlineId") String airlineId, @PathVariable("flightNo") int flightNo){
        return employeeService.getReservationsByFlightNumber(airlineId, flightNo);
    }

    @RequestMapping(value="/reservationsByCustomerName/{firstName}/{lastName}", method = RequestMethod.GET)
    public Collection<Reservation> getReservationsByCustomerName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName){
        return employeeService.getReservationsByCustomerName(firstName, lastName);
    }

    @RequestMapping(value="/salesReport/{date}", method = RequestMethod.GET)
    public Collection<SalesReport> getSalesReport(@PathVariable("date") String date){
        return employeeService.getSalesReport(date);
    }

    @RequestMapping(value="/revenueByFlight/{airlineId}/{flightNo}", method = RequestMethod.GET)
    public Collection<Revenue> getRevenueByFlightNumber(@PathVariable("airlineId") String airlineId, @PathVariable("flightNo") int flightNo){
        return employeeService.getRevenueByFlightNumber(airlineId, flightNo);
    }

    @RequestMapping(value="/revenueByDestinationCity/{city}", method = RequestMethod.GET)
    public Collection<Revenue> getRevenueByDestinationCity(@PathVariable("city") String airlineId){
        return employeeService.getRevenueByCity(airlineId);
    }

    @RequestMapping(value="/revenueByCustomer/{accountId}", method = RequestMethod.GET)
    public Collection<Revenue> getRevenueByCustomer(@PathVariable("accountId") int accountId){
        return employeeService.getRevenueByCustomer(accountId);
    }
}
