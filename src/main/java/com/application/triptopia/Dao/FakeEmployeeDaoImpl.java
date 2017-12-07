package com.application.triptopia.Dao;

import com.application.triptopia.Entity.Employee;
import com.application.triptopia.Entity.Flight;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class FakeEmployeeDaoImpl implements EmployeeDao {

    private static Map<Integer, Employee> employeeMap;

    static {
        employeeMap = new HashMap<Integer, Employee>(){
            {
                put(1, new Employee("John", "Martin", "123 Ms", "NY", "NY", 12345,  1, 987654, true, "01/02", 12.5));
                put(2, new Employee("Muhammad", "raiyan", "123 Ms", "NY", "NY", 12345,  2, 987654, false, "01/02", 12.5));
            }
        };
    }

    @Override
    public Collection<Employee> getAllEmployee(){
        return this.employeeMap.values();
    }

    @Override
    public void addEmployee(int key, Employee newEmployee){
        this.employeeMap.put(key, newEmployee);
    }

    @Override
    public Employee getEmployee(int id){
        return this.employeeMap.get(id);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeMap.remove(id);
    }

    @Override
    public void updateEmployee(Employee employee){
        Employee e = employeeMap.get(employee.getPersonId());
        e.setHourlyRate(employee.getHourlyRate());
        e.setManager(employee.isManager());
        e.setSsn(employee.getSsn());
        e.setStartDate(employee.getStartDate());
        employeeMap.put(employee.getPersonId(), employee);
    }

    @Override
    public void insertEmployeeToDB(Employee employee) {
        this.employeeMap.put(employee.getPersonId(), employee);
    }

    @Override
    public Collection<Flight> getAllFlight() {

        return null;
    }
}
