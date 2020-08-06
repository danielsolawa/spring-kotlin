package com.danielsolawa.springkotlin.service

import com.danielsolawa.springkotlin.model.Employee

interface EmployeeService {

    fun create(employee: Employee): Employee
    fun getAll(): MutableIterable<Employee>
    fun getByEmployeeId(employeeId: Long): Employee
    fun update(employeeId: Long, employee: Employee): Employee
    fun delete(employeeId: Long)
}