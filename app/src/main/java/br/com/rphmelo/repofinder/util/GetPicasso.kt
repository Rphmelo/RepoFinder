package br.com.rphmelo.repofinder.util

import android.content.Context
import br.com.rphmelo.repofinder.di.components.DaggerPicassoComponent
import br.com.rphmelo.repofinder.di.modules.ContextModule
import com.squareup.picasso.Picasso

fun getPicasso(context: Context): Picasso {
    return DaggerPicassoComponent.builder()
            .contextModule( ContextModule(context)).build().getPicasso()
}