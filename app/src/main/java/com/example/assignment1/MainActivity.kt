package com.example.assignment1

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*
import com.example.assignment1.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val nameEditText: EditText = findViewById(R.id.et_name)
        val emailEditText: EditText = findViewById(R.id.et_email)
        val genderRadioGroup: RadioGroup = findViewById(R.id.rg_gender)
        val occupationSpinner: Spinner = findViewById(R.id.spinner_occupation)
        val physicallyActiveSwitch: Switch = findViewById(R.id.switch_physically_active)
        var selectedOccupation: String = "Student"
        val saveButton: Button = findViewById(R.id.btn_save)

        val occupationAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.occupation_array,
            android.R.layout.simple_spinner_item
        )

        occupationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        occupationSpinner.adapter = occupationAdapter
        occupationSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedOccupation = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val selectedGenderId = genderRadioGroup.checkedRadioButtonId
            val selectedGender = findViewById<RadioButton>(selectedGenderId)?.text.toString()
            val isPhysicallyActive = physicallyActiveSwitch.isChecked
            val saveButton: Button = findViewById(R.id.btn_save)

            val userInfo = "Name: $name\nEmail: $email\nGender: $selectedGender\nOccupation: $selectedOccupation\nPhysically Active: $isPhysicallyActive"

            val intent = Intent(this, DisplayInfoActivity::class.java)
            intent.putExtra("userInfo", userInfo)
            startActivity(intent)
        }

    }
}