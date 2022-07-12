package com.example.fampayassignment.ui.card_groups

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fampayassignment.databinding.ItemCardGroupsBinding
import com.example.lib.models.CardGroup
import javax.inject.Inject

class CardGroupsAdapter : ListAdapter<CardGroup, CardGroupsAdapter.ViewHolder>(diffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCardGroupsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    inner class ViewHolder(
        private val binding: ItemCardGroupsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var cardsAdapter: CardsAdapter

        fun bind(item: CardGroup, position: Int) = binding.apply {
            var cardList = item.cards
            cardsAdapter = CardsAdapter(
                item.designType ?: "HC3",
                onRemindLaterClick = {
                    // Removing item at given position
                    if (!cardList.isNullOrEmpty()) {
                        cardList.removeAt(it)
                        cardsAdapter.submitList(cardList)
                        cardsAdapter.notifyDataSetChanged()
                    }
                },
                onDismissClick = {
                    // Removing item at given position
                    if (!cardList.isNullOrEmpty()) {
                        cardList.removeAt(it)
                        cardsAdapter.submitList(cardList)
                        cardsAdapter.notifyDataSetChanged()
                    }
                }
            )
            rvCards.setHasFixedSize(true)
            rvCards.adapter = cardsAdapter
            cardsAdapter.submitList(item.cards)
        }
    }

}

private val diffUtilCallback = object : DiffUtil.ItemCallback<CardGroup>() {
    override fun areItemsTheSame(oldItem: CardGroup, newItem: CardGroup): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: CardGroup, newItem: CardGroup): Boolean =
        oldItem.equals(newItem)
}