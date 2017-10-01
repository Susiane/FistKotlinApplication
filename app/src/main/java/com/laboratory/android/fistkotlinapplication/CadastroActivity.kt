package com.laboratory.android.fistkotlinapplication

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        btnSave.setOnClickListener {
            val name = edtName.text.toString()
            val age = edtAge.text.toString().toInt()
            val person = Person(name, age)

            val intent = Intent()
            intent.putExtra(EXTRA_PERSON, person)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    companion object {
        val EXTRA_PERSON = "preson"
    }
}
