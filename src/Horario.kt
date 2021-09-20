import java.time.LocalDate
import java.time.LocalTime

data class Horario(
    val idPersonal:String, val horaEntrada: LocalTime, val horaSalida: LocalTime,
    var fechaInicial: LocalDate, var fechaFinal: LocalDate
)
