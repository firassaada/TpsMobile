package com.example.tp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp2.Student
import com.example.tp2.StudentsAdapter

class MainActivity : AppCompatActivity() {

    val recycler : RecyclerView by lazy { findViewById(R.id.recycler) }
    val tousRadio : RadioButton by lazy { findViewById(R.id.tousRadio) }
    val presentsRadio : RadioButton by lazy { findViewById(R.id.presentsRadio) }
    val absentsRadio : RadioButton by lazy { findViewById(R.id.absentsRadio) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tousRadio.isChecked = true

        var students = arrayListOf<Student>(
            Student(0,"skander", "skander", "M", true),
            Student(1,"nada", "nada", "F", true),
            Student(2,"chaima", "chaima", "F", false),
            Student(3,"Ahmed", "Ahmed", "M", true),
            Student(4,"Ahmed", "Iheb", "M", false),

            )

        var studentsAdapter = StudentsAdapter(students)

        presentsRadio.setOnCheckedChangeListener{ view , value ->
            if(value == true){
                studentsAdapter.filter.filter(value.toString())
            }
        }

        absentsRadio.setOnCheckedChangeListener{ view , value ->
            if(value == true){
                studentsAdapter.filter.filter((!value).toString())
            }
        }

        tousRadio.setOnCheckedChangeListener{ view , value ->
            if(value == true){
                studentsAdapter.filter.filter("")
            }
        }

        recycler.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = studentsAdapter
        }
    }
}