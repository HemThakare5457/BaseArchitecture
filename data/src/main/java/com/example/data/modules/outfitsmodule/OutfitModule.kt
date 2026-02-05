package com.example.data.modules.outfitsmodule

import com.example.data.apidao.OutfitsDao
import com.example.data.datasource.remote.outfits.OutfitsRemoteDataSource
import com.example.data.datasource.remote.outfits.OutfitsRemoteDataSourceImpl
import com.example.data.repository.outfits.OutfitsRepositoryImpl
import com.example.domain.repository.outfit.OutfitsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class OutfitModule {

    @Provides
    fun provideOutfitsRemoteDataSource(
        outfitsDao: OutfitsDao
    ): OutfitsRemoteDataSource {
        return OutfitsRemoteDataSourceImpl(outfitsDao)
    }

    @Provides
    fun provideOutfitsRepository(
        outfitsRemoteDataSource: OutfitsRemoteDataSource
    ): OutfitsRepository {
        return OutfitsRepositoryImpl(outfitsRemoteDataSource)
    }
}