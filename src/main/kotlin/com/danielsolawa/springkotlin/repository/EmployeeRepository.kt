package com.danielsolawa.springkotlin.repository

import com.danielsolawa.springkotlin.model.Employee
import org.springframework.data.repository.CrudRepository

interface EmployeeRepository: CrudRepository<Employee, Long> {
}