package net.javaguides.departamentservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.departamentservice.dto.DepartmentDto;
import net.javaguides.departamentservice.entity.Departament;
import net.javaguides.departamentservice.mapper.AutoDepartmentMapper;
import net.javaguides.departamentservice.repository.DepartmentRepository;
import net.javaguides.departamentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto save(DepartmentDto departmentDto) {
        Departament departament = AutoDepartmentMapper.MAPPER.mapToDepartment(departmentDto);
        Departament savedDepartament = departmentRepository.save(departament);
        return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartament);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Departament departament = departmentRepository.findByDepartamentCode(code);
        return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(departament);
    }
}
