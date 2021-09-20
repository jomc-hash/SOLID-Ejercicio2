import java.time.LocalTime

interface ITolerancia{
    val toleranciaRetraso:Long
    val toleranciaInasistencia:Long
    fun horaRetraso(horaAsignada: LocalTime): LocalTime {
        return horaAsignada.plusMinutes(toleranciaRetraso)
    }
    fun horaInasistencia(horaAsignada: LocalTime): LocalTime {
        return horaAsignada.plusMinutes(toleranciaInasistencia)
    }
}

data class ToleranciaEstandar(override val toleranciaRetraso: Long = 10, override val toleranciaInasistencia: Long = 20):ITolerancia


