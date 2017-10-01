package com.laboratory.android.fistkotlinapplication

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val people : MutableList<Person> by lazy { mutableListOf<Person>()}
    private var adapter : ArrayAdapter<Person>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPlus.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivityForResult(intent, REQUEST_INSERT)
        }

        adapter = ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, people)
        listtPerson.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_INSERT && resultCode == Activity.RESULT_OK){
            val person = data?.getSerializableExtra(CadastroActivity.EXTRA_PERSON) as? Person
            if(person != null){
                people.add(person)
                adapter?.notifyDataSetChanged()
            }
        }
    }
    companion object {
        val REQUEST_INSERT = 0
    }
}
