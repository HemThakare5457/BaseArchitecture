package com.example.domain.repository.outfit

import com.example.core.dto.OperationResult

interface OutfitsRepository {
    fun getOutfits(outfitId: Int): OperationResult<List<String>>
}