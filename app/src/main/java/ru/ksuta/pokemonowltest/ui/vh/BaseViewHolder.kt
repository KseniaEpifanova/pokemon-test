package ru.ksuta.pokemonowltest.ui.vh

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<D>(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun setData(data: D)
}