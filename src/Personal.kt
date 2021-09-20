import java.time.LocalDate

data class Personal(val nombre: String, val identificador: String, val grado:AGradoAcademico,
                    val curp:String, val  fechaIngreso: LocalDate, val genero:String,
                    val clavePresupuestal:String )
