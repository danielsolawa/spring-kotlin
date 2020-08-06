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

}