package com.kotlinpokemon.kotlinzooapp
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.ticket_animal.view.*

/**
 * Created by marcus on 27/10/17.
 */
class AnimalAdapter :BaseAdapter {

    var animals = ArrayList<Animal>()
    var context:Context? = null
    constructor(context:Context, animals: ArrayList<Animal>):super(){
        this.animals = animals
        this.context = context
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val animal = animals[position]

        if(animal.isKiller){
            var layoutInflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView = layoutInflater.inflate(R.layout.ticket_killer_animal, null)
            myView.tv_animalName.text = animal.name
            myView.tv_animalDesc.text = animal.desc
            myView.img_animal.setImageResource(animal.img)

            myView.img_animal.setOnClickListener { loadAnimal(animal) }

            return myView
        }
        else {
            var layoutInflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView = layoutInflater.inflate(R.layout.ticket_animal, null)

            myView.tv_animalName.text = animal.name
            myView.tv_animalDesc.text = animal.desc
            myView.img_animal.setImageResource(animal.img)

            myView.img_animal.setOnClickListener { loadAnimal(animal) }

            return myView
        }
    }

    override fun getItem(position: Int): Any {
        return animals[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return animals.size
    }

    private fun loadAnimal(animal:Animal){
        val intent = Intent(context, AnimalInfoActivity::class.java)
        intent.putExtra("name", animal.name)
        intent.putExtra("desc", animal.desc)
        intent.putExtra("img", animal.img)
        context!!.startActivity(intent)
    }
}
