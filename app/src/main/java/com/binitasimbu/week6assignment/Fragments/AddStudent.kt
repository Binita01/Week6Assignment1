package com.binitasimbu.week6assignment.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.binitasimbu.week6assignment.HomePageActivity
import com.binitasimbu.week6assignment.Model.students
import com.binitasimbu.week6assignment.R
import com.binitasimbu.week6assignment.StudentData


class AddStudent : Fragment(){
    private lateinit var etName:EditText
    private lateinit var etCid:EditText

    private lateinit var rdGroup: RadioGroup
    private lateinit var rdMale:RadioButton
    private lateinit var rdFemale:RadioButton
    private lateinit var rdOthers:RadioButton

    private lateinit var etAddress:EditText
    private lateinit var etimage:EditText

    private lateinit var btnSave:Button

    var newStudent=ArrayList<students>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_add_student, container, false)
        etName=view.findViewById(R.id.etName)
        etCid=view.findViewById(R.id.etCid)
        rdGroup=view.findViewById(R.id.rdGroup)
        rdMale=view.findViewById(R.id.rdMale)
        rdFemale=view.findViewById(R.id.rdFemale)
        rdOthers=view.findViewById(R.id.rdOthers)
        etAddress=view.findViewById(R.id.etAddress)
        etimage=view.findViewById(R.id.etimage)
        btnSave=view.findViewById(R.id.btnSave)


        btnSave.setOnClickListener {
            var image = etimage.text.toString();
            var cid=etCid.text.toString().toInt();
            var name = etName.text.toString();
            var gender = rdGroup.checkedRadioButtonId.toString();
            var address = etAddress.text.toString();
            var studentdata = students(image, cid, name, gender, address)

            newStudent.add(studentdata);
           // var bundle = Bundle()
           // bundle.putString("data", "yourdata");
            //var homeFragment = Home();
            //homeFragment.arguments = bundle
            StudentData.get().List().add(studentdata);

            val i = Intent(activity, HomePageActivity::class.java)
            i.putExtra("data", "yourdata")
            activity!!.startActivity(i)

        }


        return view
    }




}