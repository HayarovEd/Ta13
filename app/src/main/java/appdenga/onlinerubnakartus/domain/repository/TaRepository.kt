package appdenga.onlinerubnakartus.domain.repository

import appdenga.onlinerubnakartus.domain.model.Loan
import appdenga.onlinerubnakartus.domain.utils.Resource

interface TaRepository {
    suspend fun getRemoteData(): Resource<List<Loan>>
}