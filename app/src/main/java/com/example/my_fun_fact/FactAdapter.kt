package com.example.my_fun_fact

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class FactAdapter(context:Context, facts: List<FactModel>) : ArrayAdapter<FactModel>(context, 0 , facts) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView // gets the view we are to return
        val fact = getItem(position) // gets the object of Factmodel we have in facts list resource

        // if view is empty, then in the context of the parent root viewGroup, inflate fact_item using the layout parameters of the root element in fact_item
        if (view == null) view = LayoutInflater.from(parent.context).inflate(R.layout.fact_item, parent, false)


        val logo = view?.findViewById<ImageView>(R.id.imageLogo)   //locate the ImageView with id imageLogo in the fact item layout
        val name = view?.findViewById<TextView>(R.id.nameTextView) //locate the TextView with id nameTextView in the fact_item


        fact?.logo?.let{
            logo?.setImageResource(fact.logo)                      //when fact.logo is not empty, then set the ImageView in the fact_item layout to the fact.logo
        }

        name?.text = fact?.name                                    // set the TextView in fact_item layout to fact.name if it is not empty

        view?.setOnClickListener(){
            val intent = Intent(parent.context, DetailActivity::class.java)
            intent.putExtra(LOGO_EXTRA, fact?.logo)
            intent.putExtra(NAME_EXTRA, fact?.name)
            intent.putExtra(FACT_EXTRA, fact?.fact)
            parent.context.startActivity(intent)

        }
        view?.setBackgroundColor(Color.TRANSPARENT)

        return view!!
    }

    companion object{
        val LOGO_EXTRA = "logo_extras"
        val NAME_EXTRA = "name_extras"
        val FACT_EXTRA = "fact_extras"
    }

}