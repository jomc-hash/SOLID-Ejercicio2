import java.time.LocalDate
import java.time.LocalTime

data class RegistroDia(
    val fecha: LocalDate, val entrada: LocalTime = LocalTime.of(0,0), var salida: LocalTime =entrada, var tienePermiso:Boolean=false
)
