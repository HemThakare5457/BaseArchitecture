package com.example.data.datasource.remote.outfits

import com.example.core.dto.OperationResult
import com.example.data.network.HttpApiInf

interface OutfitsRemoteDataSource: HttpApiInf {
    fun getOutfits(outfitId: Int): OperationResult<List<String>>
}