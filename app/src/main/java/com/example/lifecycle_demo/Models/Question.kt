package com.example.lifecycle_demo.Models

import androidx.lifecycle.ViewModel

class Question : ViewModel() {
    var name : String? = null
    var no1 : Int = 0
    var no2 : Int = 0

    init{
        generateQuestion()
    }

    fun getAnswer():Int {
        return no1+no2
    }

    fun generateQuestion(): String {
        no1 = (Math.random() * 100).toInt()
        no2 = (Math.random() * 100).toInt()

        return "${no1} + ${no2} = ?"
    }

    fun getQuestion(): String{
        return "${no1} + ${no2} = ?"
    }

    companion object{
        private var instance: Question? = null

        fun getInstance() =
            instance ?: synchronized(Question::class.java){
                instance?: Question().also { instance = it }
            }
    }
}