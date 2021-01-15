package com.binitasimbu.week6assignment.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.binitasimbu.week6assignment.Model.students
import com.binitasimbu.week6assignment.R
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView


class StudentAdapter (
        val lstStudents:ArrayList<students>,
        val context: Context
): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(){
    class StudentViewHolder(view: View): RecyclerView.ViewHolder(view){

        val imgp: CircleImageView
        val StdCid:TextView
        val StdName:TextView
        val StdAddress:TextView
        val StdGender:TextView
        val imgDel:ImageView
        init{
            imgp=view.findViewById(R.id.imgp)
            StdCid=view.findViewById(R.id.StdCid)
            StdName=view.findViewById(R.id.StdName)
            StdAddress=view.findViewById(R.id.StdAddress)
            StdGender=view.findViewById(R.id.StdGender)
            imgDel=view.findViewById(R.id.imgDel)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view=LayoutInflater.from(parent.context)
                .inflate(R.layout.new_student,parent, false)
        return  StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student=lstStudents[position]
        holder.StdCid.text=student.coventryId.toString()
        holder.StdName.text=student.studentName
        holder.StdAddress.text=student.studentAddress
        holder.StdGender.text=student.studentGender

        Glide.with(context)
                .load(student.studentImg)
                .into(holder.imgp)

        holder.imgDel.setOnClickListener {
            lstStudents.removeAt(position)
            notifyItemRemoved(position)
            notifyDataSetChanged()
            notifyItemRangeChanged(position, lstStudents.size)
        }
    }
    override fun getItemCount():Int{
        return lstStudents.size
    }

}