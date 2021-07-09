package com.dynamicdevz.rxjavadynamic.di.component

import com.dynamicdevz.rxjavadynamic.model.RickyRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface RickyComponent {
    fun getRepository(): RickyRepository
}