object UtilesDebug {
    fun mostrarRegistroCompleto(datos:RegistroGeneral) {
        datos.arrayRegistrosIndividuales.forEach {
            println(
                it.personal.nombre
            )
            it.dias.forEach {
                println("Fecha: ${it.fecha}, Entrada: ${it.entrada}  - salida ${it.salida} , permiso: ${it.tienePermiso}")
            }
        }
    }

    fun mostrarResumen(datos: VerificadorAsistencia){

        datos.asistenciaGeneral.forEach{
            println("Datos del personal ${it.component1().nombre}")
            println("Permisos ${it.component2().permisos}")
            println("Retardos del personal ${it.component2().retardos}")
            println("Inasistencias del personal ${it.component2().inasistencias}")
            println("")

        }
    }
    fun mostrarRegistros(arrayRegistrosIndividuales:ArrayList<RegistroIndividual>){
        arrayRegistrosIndividuales.forEach{
                registro->
            println(registro.personal.nombre)
        }
    }
}
