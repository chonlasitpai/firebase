package com.example.firebase1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clear.setOnClickListener {
            name.setText("")
            pass.setText("")
        }
        ok.setOnClickListener {
            val firstn = name.text.toString()
            val lastn = pass.text.toString()
            val firebase = FirebaseDatabase.getInstance()
            val ref = firebase.getReference("Employee")
            val id:String? = ref.push().key
            val Employee = Employee(id.toString(),firstn,lastn)
            ref.child(id.toString()).setValue(Employee).addOnCompleteListener{
                Toast.makeText(applicationContext,"Complete",Toast.LENGTH_LONG).show()
                name.setText("")
                pass.setText("")
            }
        }
    }
}