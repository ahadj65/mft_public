package com.mft.mftproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // views
        val loginTv = findViewById<TextView>(R.id.loginTv)
        val signupTv = findViewById<TextView>(R.id.signUpTv)
        val usernameTIL = findViewById<TextInputLayout>(R.id.userNameTIL)
        val usernameTIET = findViewById<TextInputEditText>(R.id.userNameTIET)
        val passwordTIL = findViewById<TextInputLayout>(R.id.passwordTIL)
        val passwordTIET = findViewById<TextInputEditText>(R.id.passwordTIET)


        // actions
        loginTv.setOnClickListener {
            // وقتی روی دکمه ثبت نام کلیک میشود اول چک میشود که همه موارد به درستی وارد شده اند یا نه
            var validate = true
            if (usernameTIET.text.toString().isEmpty()) {
                validate = true
                usernameTIL.error = getString(R.string.username_cannot_be_empty)
            }
            if (passwordTIET.text.toString().isEmpty()) {
                validate = false
                passwordTIL.error = getString(R.string.password_cannot_be_empty)
            }

            // در این مرحله اطلاعات وارد شده کاربر با اطلاعات ذخیره شده در صفحه ثبت نام چک میشود
            if (validate) {
                val sharedPreferences = getSharedPreferences("Login", Context.MODE_PRIVATE)
                val saveUsername = sharedPreferences.getString("username", null)
                val savedPassword = sharedPreferences.getString("password", null)
                if (saveUsername == usernameTIET.text.toString() && savedPassword == passwordTIET.text.toString()) {



                } else {
                    // در صورتی که نام کاربری یا کلمه عبور اشتباه وارد شده باشند پیغام مناسب به کاربر نشان داده میشوند
                    val view = findViewById<ConstraintLayout>(R.id.main)
                    val snackBar = Snackbar.make(view, R.string.incorrext_username_or_password, Snackbar.LENGTH_LONG)
                    snackBar.setActionTextColor(R.color.red)
                    snackBar.setAction(R.string.undo) {

                    }
                    snackBar.show()
                }
            }
        }
        signupTv.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }


        // text changes events


        // remember me

    }
}