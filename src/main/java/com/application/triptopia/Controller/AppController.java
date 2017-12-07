package com.application.triptopia.Controller;

import com.application.triptopia.Entity.*;
import com.application.triptopia.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/home")
public class AppController {

    @Autowired
    protected EmployeeService appService;

    @RequestMapping(value = "/employee/allEmployees", method = RequestMethod.GET)
    public Collection<Employee> getAllEmployee() {
        return appService.getAllEmployee();
    }

    @RequestMapping(value = "/employee/get/{id}", method = RequestMethod.GET)
    public List<Map<String, Object>> getEmployee(@PathVariable("id") int id) {
        return this.appService.getEmployee(id);
    }

    @RequestMapping(value = "/employee/delete/{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable("id") int id) {
        appService.deleteEmployee(id);
    }

    @RequestMapping(value = "/employee/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateEmployee(@RequestBody Employee employee) {
        appService.updateEmployee(employee);
    }

    @RequestMapping(value = "/employee/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertEmployee(@RequestBody Employee employee) {
        System.out.println("IN insert employee");
        appService.insertEmployee(employee);
    }

    @RequestMapping(value = "/employee/allFlights", method = RequestMethod.GET)
    public Collection<Flight> getListOfFlight() {
        return appService.getAllFlights();
    }

    @RequestMapping(value = "/employee/reservationsByFlightNumber/{airlineId}/{flightNo}", method = RequestMethod.GET)
    public Collection<Reservation> getReservationsByFlightNumber(@PathVariable("airlineId") String airlineId, @PathVariable("flightNo") int flightNo) {
        return appService.getReservationsByFlightNumber(airlineId, flightNo);
    }

    @RequestMapping(value = "/employee/reservationsByCustomerName/{firstName}/{lastName}", method = RequestMethod.GET)
    public Collection<Reservation> getReservationsByCustomerName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        return appService.getReservationsByCustomerName(firstName, lastName);
    }

    @RequestMapping(value = "/employee/salesReport/{date}", method = RequestMethod.GET)
    public Collection<SalesReport> getSalesReport(@PathVariable("date") String date) {
        return appService.getSalesReport(date);
    }

    @RequestMapping(value = "/employee/revenueByFlight/{airlineId}/{flightNo}", method = RequestMethod.GET)
    public Collection<Revenue> getRevenueByFlightNumber(@PathVariable("airlineId") String airlineId, @PathVariable("flightNo") int flightNo) {
        return appService.getRevenueByFlightNumber(airlineId, flightNo);
    }

    @RequestMapping(value = "/employee/revenueByDestinationCity/{city}", method = RequestMethod.GET)
    public Collection<Revenue> getRevenueByDestinationCity(@PathVariable("city") String airlineId) {
        return appService.getRevenueByCity(airlineId);
    }

    @RequestMapping(value = "/employee/revenueByCustomer/{accountId}", method = RequestMethod.GET)
    public Collection<Revenue> getRevenueByCustomer(@PathVariable("accountId") int accountId) {
        return appService.getRevenueByCustomer(accountId);
    }
    @RequestMapping(value="/employee/customerOfMaxRevenue", method = RequestMethod.GET)
    public Collection<Employee>  getCustomerRepOfMaxRevenue(){
        return appService.getCustomerRepOfMaxRevenue();
    }

    @RequestMapping(value = "/employee/mostActiveFlights", method = RequestMethod.GET)
    public List<Map<String, Object>> getMostActiveFlights(){
        return appService.getMostActiveFlights();
    }

    @RequestMapping(value = "/employee/customersOnFlight/{airlineId}/{flightNo}/{legNo}", method = RequestMethod.GET)
    public List<Map<String, Object>> getCustomersOnFlight(@PathVariable("airlineId") String airlineId, @PathVariable("flightNo") int flightNo, @PathVariable("legNo") int legNo){
        return appService.getCustomersOnFlight(airlineId, flightNo, legNo);
    }

    @RequestMapping(value = "/rep/recordReservation", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void recordReservation(@RequestBody Reservation reservation) {
        System.out.println("IN insert employee");

        appService.recordReservation(reservation);
    }

    @RequestMapping(value = "/rep/insertCustomer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCustomer(@RequestBody Customer customer) {
        appService.addCustomer(customer);
    }

    @RequestMapping(value = "/rep/allCustomers", method = RequestMethod.GET)
    public Collection<Customer> getAllCustomers() {
        return appService.getAllCustomers();
    }
}
