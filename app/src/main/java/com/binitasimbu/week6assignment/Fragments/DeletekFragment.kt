package com.binitasimbu.week6assignment.Fragments

import android.content.Intent
import android.content.Intent.getIntent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.binitasimbu.week6assignment.HomePageActivity
import com.binitasimbu.week6assignment.Model.students
import com.binitasimbu.week6assignment.R
import com.binitasimbu.week6assignment.StudentData
import de.hdodenhof.circleimageview.CircleImageView


class DeletekFragment : Fragment() {
    private lateinit var imgp: CircleImageView
    private lateinit var StdCid: TextView
    private lateinit var StdName: TextView
    private lateinit var StdAddress: TextView
    private lateinit var StdGender: TextView
    private lateinit var imgDel: ImageButton

    var Student=ArrayList<students>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view= inflater.inflate(R.layout.fragment_home, container, false)
        imgDel=view.findViewById(R.id.imgDel)
        StdName=view.findViewById(R.id.StdName)
        StdCid=view.findViewById(R.id.StdCid)
        StdAddress=view.findViewById(R.id.StdAddress)
        StdGender=view.findViewById(R.id.StdGender)
        imgp=view.findViewById(R.id.imgp)

        imgDel.setOnClickListener {
            var image = imgp.toString();
            var cid=StdCid.text.toString().toInt();
            var name = StdName.text.toString();
            var gender = StdGender.toString();
            var address = StdAddress.text.toString();
            var studentdata = students(image, cid, name, gender, address)

            Student.remove(studentdata);
            StudentData.get().List().remove(studentdata);
            val i = Intent(activity, HomePageActivity::class.java)
            i.putExtra("data", "yourdata")
            activity!!.startActivity(i)
            
        }


        return view
    }




}


