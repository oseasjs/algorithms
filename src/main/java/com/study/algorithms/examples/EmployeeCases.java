package com.study.algorithms.examples;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class EmployeeCases {

    public Optional<Employee> highestSalary(List<Employee> employeeList) {

        return employeeList
            .stream()
            .reduce(
                BinaryOperator.maxBy(
                    Comparator.comparingDouble(Employee::getSalary)
                )
            );
    }

    public Employee lowestSalary(List<Employee> employeeList) {

        return employeeList
            .stream()
            .collect(
            Collectors.collectingAndThen(
                    Collectors.minBy(
                        Comparator.comparing(
                            Employee::getSalary
                        )
                    ),
                    Optional::get
                )
            );

    }

    public Map<String, Optional<Employee>> highestSalaryByDepartament(List<Employee> employeeList) {

        return employeeList
            .stream()
            .collect(
                Collectors.groupingBy(
                    Employee::getDepartament,
                    Collectors.reducing(
                        BinaryOperator.maxBy(
                            Comparator.comparingDouble(Employee::getSalary)
                        )
                    )
                )
            );
    }

    public Map<String, Employee> lowestSalaryByDepartament(List<Employee> employeeList) {

        return employeeList
            .stream()
            .collect(
                Collectors.groupingBy(
                    Employee::getDepartament,
                    Collectors.collectingAndThen(
                        Collectors.minBy(
                            Comparator.comparing(
                                Employee::getSalary
                            )
                        ),
                        Optional::get
                    )
                )
            );

    }

}
