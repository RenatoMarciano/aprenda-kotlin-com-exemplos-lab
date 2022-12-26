// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario (val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun imprimirListaInscritos() {
        for (user in inscritos) {
            println(user.nome)
        }
    }
    fun imprimirGradeFormacao() {
        for (cont in conteudos) {
            println("${cont.nome} - ${cont.duracao}")
        }
    }
}

fun main() {
    //cursos individuais
    val modJava = ConteudoEducacional("Curso Java", 135)
    val modKotlin = ConteudoEducacional("Curso Kotlin", 80)

    val listConteudos = mutableListOf<ConteudoEducacional>()
    listConteudos.add(modJava)
    listConteudos.add(modKotlin)

    //formação completa com todos os cursos
    val formAndroid = Formacao("Formação Android Developer", listConteudos, Nivel.INTERMEDIARIO)

    //Criar lista de usuarios
    val pedro = Usuario("Pedro", "pedro@hotmail.com")
    val carol = Usuario("Carol", "carol@gmail.com")

    //matriculando usuarios na formação
    formAndroid.matricular(pedro)
    formAndroid.matricular(carol)

    println("======================================")
    println("Dados da formação")
    println("${formAndroid.nome} - ${formAndroid.nivel}")
    println("Grade formação")
    println(formAndroid.imprimirGradeFormacao())
    println("=======================================")
    println("Lista de inscritos")
    println(formAndroid.imprimirListaInscritos())
}
