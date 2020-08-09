package com.danielsolawa.springkotlin.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Employee(
        var name: String,
        var age: Int,
        var position: String,
        @Id @GeneratedValue var employeeId: Long? = null) {



    override fun toString(): String {
        return "Employee(name='$name', age=$age, position='$position', employeeId=$employeeId)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Employee

        if (name != other.name) return false
        if (age != other.age) return false
        if (position != other.position) return false
        if (employeeId != other.employeeId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + age
        result = 31 * result + position.hashCode()
        result = 31 * result + (employeeId?.hashCode() ?: 0)
        return result
    }
}