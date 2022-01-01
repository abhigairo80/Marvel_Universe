package com.example.marveluniverse.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marveluniverse.R
import com.example.marveluniverse.domain.model.CharacterModel
import com.example.marveluniverse.ui.Character.CharacterActivity
import kotlinx.coroutines.*

import java.util.*
import kotlin.collections.ArrayList

class CharacterListAdapter(private val context: Context, var itemList:ArrayList<CharacterModel>) : RecyclerView.Adapter<
        CharacterListAdapter.CharacterListViewHolder>() {
    inner class CharacterListViewHolder(view: View):RecyclerView.ViewHolder(view)
    {
        val characterName : TextView = view.findViewById(R.id.txtCharacterName)
        val thumbnail : ImageView = view.findViewById(R.id.imgCharacterImage)
        val cardCharacter : LinearLayout = view.findViewById(R.id.charactersLinearLayout)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_grid,parent,false)
        return CharacterListViewHolder(view)
    }
    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        val list = itemList[position]
        holder.characterName.text = list.name
        val imageUrl = "${list.thumbnail}/portrait_xlarge.${list.thumbnailExt}"
        val listofImages = listOf<Int>(R.drawable.image1,R.drawable.image2,
                            R.drawable.image3,R.drawable.image4,
                            R.drawable.image6,R.drawable.image7,
                            R.drawable.image8,R.drawable.image5,R.drawable.marvel,
                            R.drawable.batman,R.drawable.avengers,R.drawable.characters,
                            R.drawable.studios)
        Glide.with(context).load(imageUrl).placeholder(listofImages[(0..12).random()]).into(holder.thumbnail)
        holder.cardCharacter.setOnClickListener{
            val intent = Intent(context, CharacterActivity::class.java)
            intent.putExtra("id",list.id)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setData(characterList:ArrayList<CharacterModel>)
    {
        this.itemList.addAll(characterList)
        notifyDataSetChanged()
    }
}