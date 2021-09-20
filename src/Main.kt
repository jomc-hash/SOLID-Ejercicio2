import java.time.LocalDate
import java.time.LocalTime

fun main() {
    var personal1=Personal("Jose Carrizosa Bustamante","1", Bachillerato(),
        "CABM980212HOCRSN00", LocalDate.of(2017,1,1), "M", "CABM980212")

    var personal2=Personal("Martina Altamarino Calderon","2", Maestria(),
        "AACM651123MTSLLR06", LocalDate.of(2005,1,1), "M", "AACM651123")

    var personal3=Personal("Francisco Castillo Ledezma","3", Licenciatura(),
        "CALF631005HTSSDR02", LocalDate.of(2019,1,1), "M", "CALF631005")

    var horariosAsignados= HorariosAsignados();

    var horarioJose= Horario(personal1.identificador, LocalTime.of(8,0),LocalTime.of(16,0),
        LocalDate.of(2021,1,1), LocalDate.of(2022,1,1))
    var horarioMartina= Horario(personal2.identificador, LocalTime.of(9,0),LocalTime.of(18,30),
        LocalDate.of(2021,1,1), LocalDate.of(2022,6,1))

    var horarioFrancisco= Horario(personal3.identificador, LocalTime.of(9,0),LocalTime.of(18,30),
        LocalDate.of(2021,1,1), LocalDate.of(2022,6,1))

    horariosAsignados.agregarHorario(horarioJose)
    horariosAsignados.agregarHorario(horarioMartina)
    horariosAsignados.agregarHorario(horarioFrancisco)


    var registroJose= RegistroIndividual(personal1)
    var registroMartina= RegistroIndividual(personal2)
    var registroFrancisco= RegistroIndividual(personal3)


    for (dia in 1..15){
        //El personal llegó tarde los primeros 7 dias, 6 de sus retardos se convierten e 2 faltas
        if (dia<8){
            registroJose.registrarEntrada(RegistroDia(LocalDate.of(2021, 9, dia), LocalTime.of(8, 13)))
            registroJose.registrarSalida(LocalTime.of(16, 1))
        }
        else {
            registroJose.registrarEntrada(RegistroDia(LocalDate.of(2021, 9, dia), LocalTime.of(8, 1)))
            registroJose.registrarSalida(LocalTime.of(16, 1))
        }
    }

    for (dia in 1..15){
        //El personal llegó tarde los primeros 6 dias
        if (dia<7){
            registroMartina.registrarEntrada(RegistroDia(LocalDate.of(2021, 9, dia), LocalTime.of(9, 13)))
            registroMartina.registrarSalida(LocalTime.of(18, 33))
        }
        else {
            registroMartina.registrarEntrada(RegistroDia(LocalDate.of(2021, 9, dia), LocalTime.of(9, 4)))
            registroMartina.registrarSalida(LocalTime.of(18, 33))
        }
    }

    for (dia in 1..15){
        //El personal llegó muy tarde el primer dia
        if (dia==1){
            registroFrancisco.registrarEntrada(RegistroDia(LocalDate.of(2021, 9, dia), LocalTime.of(9, 33)))
            registroFrancisco.registrarSalida(LocalTime.of(18, 33))
        }
        else if(dia==3){//el personal registró salida antes de la hora que marca su horario
            registroFrancisco.registrarEntrada(RegistroDia(LocalDate.of(2021, 9, dia), LocalTime.of(9, 3)))
            registroFrancisco.registrarSalida(LocalTime.of(17, 50),)
        }
        else if(dia==5){//el personal no registró entrada este dia
            registroFrancisco.registrarEntrada(RegistroDia(LocalDate.of(2021,9, dia)))
        }
        else if(dia==10){//el personal solicitó un permiso
            registroFrancisco.registrarEntrada(RegistroDia(LocalDate.of(2021,9, dia ), tienePermiso = true))
        }
        else {
            registroFrancisco.registrarEntrada(RegistroDia(LocalDate.of(2021, 9, dia), LocalTime.of(9, 3)))
            registroFrancisco.registrarSalida(LocalTime.of(18, 30))
        }
    }

    var registroGeneral= RegistroGeneral()
    registroGeneral.agregarRegistro(registroJose)
    registroGeneral.agregarRegistro(registroMartina)
    registroGeneral.agregarRegistro(registroFrancisco)

    var verificador= VerificadorAsistencia(horariosAsignados, registroGeneral, ToleranciaEstandar())
  //  UtilesDebug.mostrarRegistroCompleto(verificador.datos)

      verificador.verificacionGeneral(PrivilegioAntiguedad())
      UtilesDebug.mostrarResumen(verificador)

}
