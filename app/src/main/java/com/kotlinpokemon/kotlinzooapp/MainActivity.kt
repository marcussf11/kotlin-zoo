package com.kotlinpokemon.kotlinzooapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity() : AppCompatActivity(){

    var animals = ArrayList<Animal>()
    var animalsAdapter:AnimalAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        animals.add(Animal("Arctic Fox", "Fox from arctic", R.drawable.arctic_fox))
        animals.add(Animal("Parrot", "Make noise", R.drawable.parrot))
        animals.add(Animal("Pinguin", "From Madagascar", R.drawable.pinguin))
        animals.add(Animal("Rhino", "Extinct", R.drawable.rhino, true))
        animals.add(Animal("Tiger", "Not Woods", R.drawable.tiger, true))

        animalsAdapter = AnimalAdapter(this,animals)

        lv_animals.adapter = animalsAdapter
        lv_animals.setOnItemLongClickListener { parent, view, position, id -> deleteAnimalFromList( position ) }
        lv_animals.setOnItemClickListener { parent, view, position, id -> addAnimalList(position) }

    }

    private fun addAnimalList(index:Int){
        animals.add(index, animals[index])
        animalsAdapter!!.notifyDataSetChanged()
    }

    private fun deleteAnimalFromList(index:Int):Boolean{
        animals.removeAt(index)
        animalsAdapter!!.notifyDataSetChanged()
        return true
    }

}
