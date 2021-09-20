import java.time.LocalTime

class  RegistroIndividual(var personal: Personal) {
    var dias= arrayListOf<RegistroDia>()

    fun registrarEntrada(registroDia:RegistroDia){
        dias.add(registroDia)
    }

    fun registrarSalida(horaSalida: LocalTime){
        dias.last().salida=horaSalida
    }
}
