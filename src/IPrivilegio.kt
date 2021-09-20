import java.time.LocalDate
import java.time.temporal.ChronoUnit

interface IObtenerDatos{
    fun obtenerEdad(personal: Personal): Boolean
    fun asignarFechaDescanso(personal: Personal):LocalDate
}

interface IPrivilegiosPersonal{
    fun recibePrivilegio(personal: Personal): Boolean
}

class PrivilegioAntiguedad():IPrivilegiosPersonal{
    override fun recibePrivilegio(personal:Personal): Boolean {
        ChronoUnit.YEARS.between(LocalDate.now(), personal.fechaIngreso)
        val antiguedad = personal.fechaIngreso.until(LocalDate.now(), ChronoUnit.YEARS )
        return antiguedad>10
    }
}
//Puede haber diferentes clases que dependan de características específicas del personal
//para aplicar un trato diferente, O/C
