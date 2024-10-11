package org.example.services.impl;

import org.example.dao.EmployeeDAO;
import org.example.dto.AddressInDTO;
import org.example.dto.EmployeeInDTO;
import org.example.entities.Address;
import org.example.entities.Employee;
import org.example.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Employee findById(Integer id) {
        return employeeDAO.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        //TODO : find a way to use inDTO later
        //Employee employee = toEntity(employeeInDTO);
        return employeeDAO.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
    }

    @Override
    public Employee update(Employee employee) {
        return null;
    }

    private Employee toEntity(EmployeeInDTO employeeInDTO){
        Employee employee = new Employee();
        employee.setAge(employee.getAge());
        employee.setName(employee.getName());

        if(nonNull(employeeInDTO.getAddressInDTO())){
            AddressInDTO addressInDTO = employeeInDTO.getAddressInDTO();

            Address address = new Address();
            address.setZip(addressInDTO.getZip());
            address.setCountry(addressInDTO.getCountry());
            address.setStreet1(addressInDTO.getStreet1());
            address.setStreet2(addressInDTO.getStreet2());
        }

        return employee;
    }
}
