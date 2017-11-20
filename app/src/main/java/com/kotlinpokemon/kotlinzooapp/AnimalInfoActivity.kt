package com.kotlinpokemon.kotlinzooapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal_info.*

class AnimalInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)

        val bundle:Bundle = intent.extras
        val name = bundle.getString("name")
        val desc  = bundle.getString("desc")
        val img = bundle.getInt("img")

        img_animal.setImageResource(img)
        tx_animalName.text = name
        tx_desc.text = desc

    }
}
