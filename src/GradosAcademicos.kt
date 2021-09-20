//se crean distintos cursos por si estos tendrán más funciones específicas O/C
//Además cada grado especifico deberá poderse usar como un gradoAcademico Liskov
abstract class AGradoAcademico(){
    open fun evaluarGrado() {}
    open val nombre:String = ""
}

class Bachillerato(): AGradoAcademico() {
    override val nombre:String = "Bachillerato"
    override fun evaluarGrado() {
        //Todo
    }
}

class Licenciatura(): AGradoAcademico() {
    override val nombre:String = "Licenciatura"
    override fun evaluarGrado() {
        //Todo
    }
}

class Maestria(): AGradoAcademico() {
    override val nombre:String = "Maestria"
    override fun evaluarGrado() {
        //Todo
    }
}

class Doctorado(): AGradoAcademico() {
    override val nombre:String = "Doctorado"
    override fun evaluarGrado() {
        //Todo
    }
}