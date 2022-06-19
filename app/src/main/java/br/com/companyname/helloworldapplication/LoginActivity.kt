package br.com.companyname.helloworldapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = Firebase.auth


        start_button.setOnClickListener {
            val email = email_field.editText?.text
            val password = password_field.editText?.text

            if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
                Toast.makeText(this@LoginActivity, "Campos necessários não preenchidos", Toast.LENGTH_SHORT).show()
            } else {
                auth.signInWithEmailAndPassword(email.toString(), password.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this@LoginActivity, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@LoginActivity, QuestionActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this@LoginActivity, "erro de login", Toast.LENGTH_SHORT).show()

                        }
                    }

            }
        }

        create_button.setOnClickListener {
            val email = email_field.editText?.text
            val password = password_field.editText?.text

            if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
                Toast.makeText(this@LoginActivity, "Campos necessários não preenchidos", Toast.LENGTH_SHORT).show()
            } else {
                auth.createUserWithEmailAndPassword(email.toString(), password.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this@LoginActivity, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this@LoginActivity, "erro de login", Toast.LENGTH_SHORT).show()

                        }
                    }

            }
        }

        forgot_password_button.setOnClickListener {
            val email = email_field.editText?.text
            if (!email.isNullOrEmpty()) {
                auth.sendPasswordResetEmail(email.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this@LoginActivity, "Email enviado com sucesso", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this@LoginActivity, "erro de envio de email", Toast.LENGTH_SHORT).show()

                        }
                    }
            }
        }
    }
}