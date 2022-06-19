package br.com.companyname.helloworldapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyListAdapter(val items: List<Aluno>) :
    RecyclerView.Adapter<MyListAdapter.MyListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_name_list, parent, false)

        return MyListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyListViewHolder, position: Int) {
        holder.nameText.text = items[position].name
        Picasso.get().load(items[position].imagePath).into(holder.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class MyListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameText = itemView.findViewById<TextView>(R.id.item_name)
        var image = itemView.findViewById<ImageView>(R.id.item_image)
    }
}