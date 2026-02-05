package com.example.domain.usecase.outfit

import com.example.core.dto.OperationResult
import com.example.core.dto.Result
import com.example.core.manager.DispatcherProvider
import com.example.domain.repository.outfit.OutfitsRepository
import com.example.domain.usecase.base.UseCase
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class GetOutfitsUseCase @Inject constructor(
    private val outfitsRepository: OutfitsRepository,
    dispatcherProvider: DispatcherProvider,
) : UseCase(dispatcherProvider) {
    operator fun invoke(
        outfitId: Int,
        coroutineScope: CoroutineScope,
    ): Result<OperationResult<List<String>>> {
        return execute(
            { outfitsRepository.getOutfits(outfitId) },
            coroutineScope
        )
    }
}