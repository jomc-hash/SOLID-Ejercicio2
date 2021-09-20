class VerificadorAsistencia(var horarios:HorariosAsignados, var datos:RegistroGeneral,
                            var tolerancia:ITolerancia){
    var asistenciaGeneral= mutableMapOf<Personal, ResumenIndividual>()


    fun verificacionGeneral(privilegio:IPrivilegiosPersonal){
        var horarioPersonal:Horario
        datos.arrayRegistrosIndividuales.forEach { elementoRegistro->
            horarioPersonal= horarios.arrayHorarios.first() {horario-> horario.idPersonal==elementoRegistro.personal.identificador }

            var resumenIndividual= VerificacionIndividual(elementoRegistro, horarioPersonal, tolerancia).resumenIndividual()
           // println("Hora de entrada del personal ${elementoRegistro.personal.nombre} : ${horarioPersonal.horaEntrada}")

            if (!privilegio.recibePrivilegio(elementoRegistro.personal)){
                resumenIndividual.inasistencias+= resumenIndividual.retardos/3
                resumenIndividual.retardos=resumenIndividual.retardos.rem(3)
            }
            asistenciaGeneral.put(elementoRegistro.personal, resumenIndividual)

        }
    }
}
