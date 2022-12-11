package com.example.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCreateUser.setOnClickListener{
            val email = editTextEmail.text.toString()
            val password = editTextPassword.toString()

            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "შეავსეთ ველები", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }else{
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        task.isSuccessful
                        Toast.makeText(this, "წარმატებით შეიქმნა", Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }
}