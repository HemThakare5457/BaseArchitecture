package com.example.data.datasource.remote.outfits

import com.example.core.dto.OperationResult
import com.example.data.apidao.OutfitsDao
import javax.inject.Inject

class OutfitsRemoteDataSourceImpl @Inject constructor(
    private val outfitsDao: OutfitsDao): OutfitsRemoteDataSource {
    override fun getOutfits(outfitId: Int): OperationResult<List<String>> {
        return makeApiRequest({
            outfitsDao.getOutfits(
                outfitId
            ).execute()
        })
    }
}