package com.example.viewpager2transition.page_transformers

import android.view.View
import androidx.viewpager2.widget.ViewPager2


private const val MIN_SCALE=0.75f
class DepthPageTransformers:ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
       page.apply {

           val page_width=width
           when{
               position <-1->{alpha=0f}     // -infinity to -i exclusive
               position <=0->{              // including -1 to position 0
                alpha=1f
                   translationX=0f
                   translationZ=0f
                   scaleY=1f
                    scaleX=1f

               }
               position<=1->{

                   alpha=1-position

                   translationX=page_width*-position
                   translationZ= -1f
                    val scale_factor= MIN_SCALE+(1- MIN_SCALE)*(1-Math.abs(position))
                   scaleX=scale_factor
                   scaleY=scale_factor

               }

               else->{
                   alpha=0f
               }
           }



       }
    }
}