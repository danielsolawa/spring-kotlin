package com.danielsolawa.springkotlin.controller

import com.danielsolawa.springkotlin.model.Employee
import com.danielsolawa.springkotlin.service.EmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/employees")
class EmployeeController(
        val employeeService: EmployeeService){

    @PostMapping
    fun create(@RequestBody employee:Employee): ResponseEntity<Employee>{

        return ResponseEntity.ok(employeeService.create(employee))
    }

    @GetMapping
    fun getAll(): ResponseEntity<MutableIterable<Employee>>{
        return ResponseEntity.ok(employeeService.getAll())
    }

    @GetMapping("/{employeeId}")
    fun getEmployeeById(@PathVariable employeeId: Long): ResponseEntity<Employee>{
        return ResponseEntity.ok(employeeService.getByEmployeeId(employeeId))
    }

    @PutMapping("/{employeeId}")
    fun update(@PathVariable employeeId: Long, @RequestBody employee: Employee): ResponseEntity<Employee>{
        return ResponseEntity.ok(employeeService.update(employeeId, employee))
    }

    @DeleteMapping("/{employeeId}")
    fun delete(@PathVariable employeeId: Long): ResponseEntity.HeadersBuilder<*> {
        employeeService.delete(employeeId)

        return ResponseEntity.noContent()
    }

}