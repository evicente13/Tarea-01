package net.javaguides.employeeservice.service.impl;

import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.mapper.AutoEmployeeMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);
        Employee employeeSaved= employeeRepository.save(employee);
        return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employeeSaved);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee= employeeRepository.findById(id).orElse(null);
        return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);
    }
}
