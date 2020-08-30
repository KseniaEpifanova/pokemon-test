package ru.ksuta.pokemonowltest.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import ru.ksuta.pokemonowltest.R


@BindingAdapter("android:src")
fun imageLoader(imageView: ImageView, url: String?) {
    Picasso.get()
        .load(url)
        .placeholder(R.drawable.pokeball)
        .error(R.drawable.pokeball)
        .into(imageView)
}