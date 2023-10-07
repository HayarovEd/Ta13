package appdenga.onlinerubnakartu.domain.repository

import appdenga.onlinerubnakartu.domain.model.Loan
import appdenga.onlinerubnakartu.domain.utils.Resource

interface TaRepository {
    suspend fun getRemoteData(): Resource<List<Loan>>
}