package appdenga.onlinerubnakartus.data.repository

import appdenga.onlinerubnakartus.data.mapper.mapToLoan
import appdenga.onlinerubnakartus.data.remote.ApiTa
import appdenga.onlinerubnakartus.domain.model.Loan
import appdenga.onlinerubnakartus.domain.repository.TaRepository
import appdenga.onlinerubnakartus.domain.utils.Resource
import javax.inject.Inject

class TaRepositoryImpl @Inject constructor(private val apiTa: ApiTa) : TaRepository {
    override suspend fun getRemoteData(): Resource<List<Loan>> {
        return try {
            val result = apiTa.getData()
            Resource.Success(
                result.mapToLoan()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error")
        }
    }
}