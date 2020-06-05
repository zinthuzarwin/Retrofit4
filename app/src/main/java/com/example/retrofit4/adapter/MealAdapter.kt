package com.example.retrofit4.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit4.R
import com.example.retrofit4.model.Category
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_meal.view.*

class MealAdapter(var categoryList: List<Category> = ArrayList()) :
      RecyclerView.Adapter<MealAdapter.MealViewHolder>()   {

    inner class MealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(category: Category){

            itemView.strCategory.text = category.strCategoryDescription
            itemView.txtFoodTitle.text = category.strCategory

            Picasso.get().load(category.strCategoryThumb).placeholder(R.drawable.ic_launcher_background).into(itemView.imgFood)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_meal,parent,false)
        return MealViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.bind(categoryList[position])
    }

    fun updateList(category : List<Category>){
        this.categoryList = category
        notifyDataSetChanged()
    }

}