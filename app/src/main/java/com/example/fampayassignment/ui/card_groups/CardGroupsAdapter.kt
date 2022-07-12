package com.example.fampayassignment.ui.card_groups

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fampayassignment.databinding.ItemCardGroupsBinding
import com.example.lib.models.CardGroup

class CardGroupsAdapter : ListAdapter<CardGroup, CardGroupsAdapter.ViewHolder>(diffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCardGroupsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemCardGroupsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CardGroup) = binding.apply {
            val cardsAdapter = CardsAdapter(item.designType ?: "H3")
            rvCards.setHasFixedSize(true)
            rvCards.adapter = cardsAdapter
            cardsAdapter.submitList(item.cards)
        }
    }

}

private val diffUtilCallback = object : DiffUtil.ItemCallback<CardGroup>() {
    override fun areItemsTheSame(oldItem: CardGroup, newItem: CardGroup): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: CardGroup, newItem: CardGroup): Boolean =
        oldItem.equals(newItem)
}