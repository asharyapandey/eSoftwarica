package com.asharya.esoftwarica.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.asharya.esoftwarica.DataStore
import com.asharya.esoftwarica.R
import com.asharya.esoftwarica.models.Student

class AddStudentFragment : Fragment() {
    private lateinit var etFullName : EditText
    private lateinit var etAge : EditText
    private lateinit var etAddress : EditText
    private lateinit var etProfileLink : EditText
    private lateinit var rgSex : RadioGroup
    private lateinit var btnSubmit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_student, container, false)

        etFullName = view.findViewById(R.id.etFullName)
        etAddress= view.findViewById(R.id.etAddress)
        etAge = view.findViewById(R.id.etAge)
        etProfileLink = view.findViewById(R.id.etProfilePicture)
        rgSex = view.findViewById(R.id.rgSex)

        btnSubmit = view.findViewById(R.id.btnSave)

        btnSubmit.setOnClickListener {
            if(validate()) {
                val checkedRadioButton = rgSex.checkedRadioButtonId
                val radioButton : RadioButton = view.findViewById(checkedRadioButton)
                DataStore.studentList.add(
                    Student(
                        etFullName.text.toString(),
                        etAge.text.toString().toInt(),
                        radioButton.text.toString(),
                        etAddress.text.toString(),
                        etProfileLink.text.toString().trim()
                    )
                )
                Toast.makeText(activity, "Student Added", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

    private fun validate() : Boolean {
        when {
            TextUtils.isEmpty(etFullName.text) -> {
                etFullName.error = "Enter Your Full Name"
                etFullName.requestFocus()
                return false
            }
            TextUtils.isEmpty(etAge.text) -> {
                etAge.error = "Enter Your Age"
                etAge.requestFocus()
                return false
            }
            TextUtils.isEmpty(etAddress.text) -> {
                etAddress.error = "Enter Your Address"
                etAddress.requestFocus()
                return false
            }
            TextUtils.isEmpty(etProfileLink.text) -> {
                etProfileLink.error = "Enter Your Profile Picture Link"
                etProfileLink.requestFocus()
                return false
            }
        }
        return true
    }
}