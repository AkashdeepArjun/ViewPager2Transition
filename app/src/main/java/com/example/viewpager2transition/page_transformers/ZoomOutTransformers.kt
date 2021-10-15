package com.example.viewpager2transition.page_transformers

import android.view.View
import androidx.viewpager2.widget.ViewPager2



private const val MIN_SCALE=0.85F
private const val MIN_ALPHA=0.5F

class ZoomOutTransformers:ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {

        page.apply {
            val page_width=width
            val page_height=height
            when{

                position <-1 ->{

                    alpha=0f

                }
                position <=1->{

                    val scaleFactor=Math.max(MIN_SCALE,1-Math.abs(position))
                    val vert_margin=page_height*(1-scaleFactor)/2
                    val horz_margin=page_width*(1-scaleFactor)/2

                    translationX=if(position<0){
                        horz_margin-vert_margin/2
                    }else horz_margin+vert_margin/2

                    scaleX=scaleFactor
                    scaleY=scaleFactor

                    alpha=(MIN_ALPHA+((scaleFactor- MIN_SCALE)/(1- MIN_SCALE))*(1- MIN_ALPHA))
                }
                else->{alpha=0f}
            }
        }

    }
}