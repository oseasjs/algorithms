package com.study.algorithms.example;

import com.study.algorithms.examples.Employee;
import com.study.algorithms.examples.EmployeeCases;
import com.sun.crypto.provider.HmacMD5KeyGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeCasesTest {

    private EmployeeCases employeeCases = new EmployeeCases();

    private final String IT_DEPARTAMENT = "IT";
    private final String HR_DEPARTAMENT = "HR";

    private final Employee mary = new Employee(1, "Mary", IT_DEPARTAMENT, 6000);
    private final Employee paul = new Employee(2, "Paul", HR_DEPARTAMENT, 5000);
    private final Employee kelly = new Employee(3, "Kelly", IT_DEPARTAMENT, 4000);
    private final Employee carl = new Employee(4, "Carl", HR_DEPARTAMENT, 3000);

    private final List<Employee> employeeList = Stream.of(
        mary,
        paul,
        kelly,
        carl
    ).collect(Collectors.toList());

    @Test
    public void highestSalaryByDepartamentSuccessfully() {
        Map<String, Optional<Employee>> highestSalaryByDepartamentMap = new HashMap<>();
        highestSalaryByDepartamentMap.put(IT_DEPARTAMENT, Optional.of(mary));
        highestSalaryByDepartamentMap.put(HR_DEPARTAMENT, Optional.of(paul));
        Assert.assertEquals(highestSalaryByDepartamentMap, employeeCases.highestSalaryByDepartament(employeeList));
    }

    @Test
    public void lowestSalaryByDepartamentSuccessfully() {
        Map<String, Employee> lowestSalaryByDepartamentMap = new HashMap<>();
        lowestSalaryByDepartamentMap.put(IT_DEPARTAMENT, kelly);
        lowestSalaryByDepartamentMap.put(HR_DEPARTAMENT, carl);
        Assert.assertEquals(lowestSalaryByDepartamentMap, employeeCases.lowestSalaryByDepartament(employeeList));
    }

}
