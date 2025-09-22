package com.projectcode.moneymanager.di

import com.projectcode.moneymanager.AndroidLogger
import com.projectcode.moneymanager.EssentialsStringProviderImpl
import com.projectcode.moneymanager.essentials.exceptions.mapper.DefaultExceptionToMessageMapper
import com.projectcode.moneymanager.essentials.exceptions.mapper.ExceptionToMessageMapper
import com.projectcode.moneymanager.essentials.logger.Logger
import com.projectcode.moneymanager.essentials.resources.EssentialsStringProvider
import com.projectcode.moneymanager.essentials.resources.StringProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
interface CommonAndroidModule {

    @Binds
    fun bindLogger(
        logger: AndroidLogger
    ): Logger

    @Binds
    @IntoMap
    @ClassKey(EssentialsStringProvider::class)
    fun bindEssentialsStringProvider(
        impl: EssentialsStringProviderImpl
    ): StringProvider


    @Binds
    fun bindExceptionToMessageMapper(
        impl: DefaultExceptionToMessageMapper
    ): ExceptionToMessageMapper


}