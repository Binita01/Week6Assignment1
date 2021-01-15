package com.binitasimbu.week6assignment.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.binitasimbu.week6assignment.R
import com.binitasimbu.week6assignment.StudentData
import com.binitasimbu.week6assignment.Adapter.StudentAdapter
import com.binitasimbu.week6assignment.Adapter.ViewPageAdapter
import com.binitasimbu.week6assignment.Model.students


class Home : Fragment() {
    var lstStudent=ArrayList<students>()
    private lateinit var recyclerView: RecyclerView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView=view.findViewById(R.id.recyclerView)

        if(StudentData.get().List().size==0){
            loadStudents();

        }


        val adapter=StudentAdapter(StudentData.get().List(),context!!)
        recyclerView.layoutManager=LinearLayoutManager(context)
        recyclerView.adapter=adapter


        return view;

    }
    private fun loadStudents(){
        StudentData.get().List().add(students("https://scontent.fktm8-1.fna.fbcdn.net/v/t1.0-9/132995348_3664876390274070_2656694039904710984_o.jpg?_nc_cat=107&ccb=2&_nc_sid=09cbfe&_nc_ohc=IgJG-qHKQaYAX8qHB6c&_nc_ht=scontent.fktm8-1.fna&oh=672548f64d3d8998452a7bcf88f4af51&oe=60274081",
                10251621,"Binita Simbu","Bafal","Female"))

        StudentData.get().List().add(students("https://scontent.fktm8-1.fna.fbcdn.net/v/t1.0-9/123191009_789660098518779_90415475176227567_o.jpg?_nc_cat=106&ccb=2&_nc_sid=09cbfe&_nc_ohc=TP5YTZy4kMgAX-ZhThh&_nc_ht=scontent.fktm8-1.fna&oh=997e997a6de17256c8ec4433ccc4d293&oe=6024BF2B",
        10252312,"Aakshana Chettri","Nakhu","Female"))

        StudentData.get().List().add(students("https://scontent.fktm8-1.fna.fbcdn.net/v/t1.0-9/56296898_410369416206247_3461579663019606016_o.jpg?_nc_cat=101&ccb=2&_nc_sid=09cbfe&_nc_ohc=M5i7CkKVxlAAX-Z-zBD&_nc_ht=scontent.fktm8-1.fna&oh=1b85643dffc66c1b4a92a20545775ed4&oe=6027B00B",
        10232215,"Kim Hyung Jung","Bhaktapur","Male"))

    }


}

