package appdenga.onlinerubnakartu.data.repository

import appdenga.onlinerubnakartu.data.mapper.mapToLoan
import appdenga.onlinerubnakartu.data.remote.ApiTa
import appdenga.onlinerubnakartu.domain.model.Loan
import appdenga.onlinerubnakartu.domain.repository.TaRepository
import appdenga.onlinerubnakartu.domain.utils.Resource
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