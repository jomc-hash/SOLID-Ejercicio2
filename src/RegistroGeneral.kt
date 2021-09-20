class RegistroGeneral(){
    var arrayRegistrosIndividuales= arrayListOf<RegistroIndividual>()

    fun agregarRegistro(registroIndividual: RegistroIndividual){
        arrayRegistrosIndividuales.add(registroIndividual)
    }
}
