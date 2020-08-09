package com.danielsolawa.springkotlin.service

import com.danielsolawa.springkotlin.model.Employee
import com.danielsolawa.springkotlin.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.*
import java.util.logging.Level
import java.util.logging.Logger
import javax.transaction.Transactional
import kotlin.math.log

@Service
class EmployeeServiceImpl(
        @Autowired val employeeRepository: EmployeeRepository) : EmployeeService {

    companion object{
        val logger: Logger = Logger.getLogger(this::class.java.simpleName);
    }

    override fun create(employee: Employee): Employee {
        logger.log(Level.INFO, "[CREATE] $employee")

        return employeeRepository.save(employee)
    }

    @Transactional
    override fun getAll(): MutableIterable<Employee> {
        logger.log(Level.INFO, "[GET ALL]")

        create(Employee(name = "Thomas", age = 27, position = "worker"))
        create(Employee(name = "Lara", age = 32, position = "cio"))
        create(Employee(name = "Catylin", age = 53, position = "worker"))
        create(Employee(name = "Michael", age = 26, position = "worker"))



        var groupBy = employeeRepository.findAll().groupBy(Employee::employeeId)

        val valid = if(groupBy.size > 20) "yes" else if(groupBy.size < 20) "no" else "no twice"

        logger.log(Level.INFO, valid)
        groupBy.forEach { (t, u) ->    logger.log(Level.INFO, "$t = $u")}

        return employeeRepository.findAll()
    }

    override fun getByEmployeeId(employeeId: Long): Employee {
        logger.log(Level.INFO, "[GET BY EMPLOYEE ID]")

        return findByEmployeeId(employeeId)
                .orElseThrow { RuntimeException("Not found") }
    }

    @Transactional
    override fun update(employeeId: Long, employee: Employee): Employee {
        logger.log(Level.INFO, "[UPDATE] $employee")

        var oldEmployee = getByEmployeeId(employeeId)
        employee.employeeId = oldEmployee.employeeId

        return employeeRepository.save(employee)
    }

    override fun delete(employeeId: Long) {
        logger.log(Level.INFO, "[DELETE] $employeeId")

        var oldEmployee = getByEmployeeId(employeeId)
        employeeRepository.delete(oldEmployee)
    }

    private fun findByEmployeeId(employeeId: Long): Optional<Employee> {
        return employeeRepository.findById(employeeId)
    }
}