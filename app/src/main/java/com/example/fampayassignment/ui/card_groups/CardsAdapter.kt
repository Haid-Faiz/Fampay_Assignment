package com.example.fampayassignment.ui.card_groups

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import coil.load
import com.example.fampayassignment.databinding.*
import com.example.lib.models.Card

class CardsAdapter(
    private val designType: String
) : ListAdapter<Card, CardsAdapter.ViewHolder>(diffUtilCallback) {

    private val Design_HC1 = 1
    private val Design_HC3 = 3
    private val Design_HC4 = 4
    private val Design_HC5 = 5
    private val Design_HC6 = 6
    private val Design_HC9 = 9

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = when (viewType) {
            Design_HC1 -> ItemCardHc1Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            Design_HC3 -> ItemCardHc3Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            Design_HC4 -> ItemCardHc4Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            Design_HC5 -> ItemCardHc5Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            Design_HC6 -> ItemCardHc6Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            Design_HC9 -> ItemCardHc9Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            else -> ItemCardHc1Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        }
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(card: Card) {

            when (binding) {
                is ItemCardHc1Binding -> binding.apply {
                    tvTitle.text = card.title
                    tvName.text = card.name
                    imgProfile.load(card.icon?.imageUrl)
                }
                is ItemCardHc3Binding -> binding.apply {
                    tvTitle.text = card.title
                    tvDescription.text = card.description
                    btnAction.text = card.cta?.get(0)?.text
                    imgBg.load(card.bgImage?.imageUrl)
                }
                is ItemCardHc4Binding -> {}
                is ItemCardHc5Binding -> binding.apply {
                    imgCard.load(card.bgImage?.imageUrl)
                }
                is ItemCardHc6Binding -> binding.apply {
                    tvTitle.text = card.title
                    imgIcon.load(card.icon?.imageUrl)
                }
                is ItemCardHc9Binding -> binding.apply {
                    imgCard.load(card.bgImage?.imageUrl)
                }
            }

        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (designType) {
            "HC1" -> Design_HC1
            "HC3" -> Design_HC3
            "HC4" -> Design_HC4
            "HC5" -> Design_HC5
            "HC6" -> Design_HC6
            "HC9" -> Design_HC9
            else -> Design_HC9
        }
    }

}

private val diffUtilCallback = object : DiffUtil.ItemCallback<Card>() {
    override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean =
        oldItem.equals(newItem)
}