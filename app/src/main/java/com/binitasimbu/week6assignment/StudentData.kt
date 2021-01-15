package com.binitasimbu.week6assignment

import com.binitasimbu.week6assignment.Model.students
import java.util.*

class StudentData private constructor() {
    var list = ArrayList<students>()
    fun List(): ArrayList<students> {
        return list
    }

    companion object {
        private val data = StudentData()
        fun get(): StudentData {
            return data
        }
    }
}