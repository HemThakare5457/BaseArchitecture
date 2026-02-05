package com.example.data.repository.outfits

import com.example.core.dto.OperationResult
import com.example.core.repository.Repository
import com.example.data.datasource.remote.outfits.OutfitsRemoteDataSource
import com.example.domain.repository.outfit.OutfitsRepository
import javax.inject.Inject

class OutfitsRepositoryImpl @Inject constructor(
    private val outfitsRemoteDataSource: OutfitsRemoteDataSource
): OutfitsRepository, Repository() {

    override fun getOutfits(outfitId: Int): OperationResult<List<String>> {
        return outfitsRemoteDataSource.getOutfits(outfitId)
    }
}