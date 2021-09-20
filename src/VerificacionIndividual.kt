class VerificacionIndividual(val registroIndividual: RegistroIndividual,
                             val horario:Horario, val tolerancia: ITolerancia){
    var inasistencias=0
    var permisos=0
    var retardos=0

    fun contarAsistencias(){
        val  entradaHorario= horario.horaEntrada
        val salidaHorario= horario.horaSalida
        val horaRetraso= tolerancia.horaRetraso(entradaHorario)
        val horaInasistencia= tolerancia.horaInasistencia(salidaHorario)
        registroIndividual.dias.forEach{
                dia->
           // println("registrada ${dia.entrada}, esperada: ${entradaHorario}")
            if (dia.tienePermiso){
                permisos++
            } else if (dia.entrada<=entradaHorario && dia.salida>=salidaHorario)
            {//Asistió en el horario asignado
            }
            else if(dia.entrada> horaRetraso && dia.entrada< horaInasistencia){
                retardos++
            }
            else if(dia.entrada>horaInasistencia || dia.salida<salidaHorario){
                inasistencias++
            }
            else if (dia.entrada==dia.salida){
                println("No había datos ${dia.fecha}")
                inasistencias++
            }
        }
    }

    fun resumenIndividual(): ResumenIndividual {
        contarAsistencias()
        return ResumenIndividual(retardos, permisos,inasistencias )
    }
}