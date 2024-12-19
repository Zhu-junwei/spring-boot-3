package com.zjw.crud.service;

import com.zjw.crud.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 朱俊伟
 * @Description
 * @since 2023-04-28 16:41
 */
@Service
public class EmployeeService {

    Map<Long, Employee> data = new ConcurrentHashMap<>(){{
        put(1L, new Employee(1L, "Tom", 25, "tom@gmail.com"));
        put(2L, new Employee(2L, "Jerry", 30, "jerry@gmail.com"));
    }};

    public Employee getEmployeeById(Long id) {
        return data.get(id);
    }

    public List<Employee> getEmployees() {
        return data.values().stream().toList();
    }

    public void saveEmployee(Employee employee) {
        data.put(employee.getId(),employee);
    }

    public void deleteEmployee(Long id) {
        data.remove(id);
    }
}
