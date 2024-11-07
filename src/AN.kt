import java.io.File

//ADIVINA UN NUMERO
/* MIGUEL BOBILLO PÉREZ */

const val BG_BLACK = "\u001B[40m"
const val BG_WHITE = "\u001B[47m"
const val RESET = "\u001B[0m"
const val BOLD = "\u001B[1m"
const val RED = "\u001B[31m"
const val BLACK = "\u001B[30m"

fun guessAnumber() {

    val archivoIntentos = "C:\\Users\\Miguel\\IdeaProjects\\Adivinanumero\\AdivinanumeroIntentos.txt"

        do {
        println("${BG_WHITE}${BLACK}${BOLD}MENU")
        println("1.Jugar")
        println("2.Ver último Intento")
        println("3.Salir")
        println("Seleccione una opción: ")

        val menu = readln().toIntOrNull()
        when (menu) {

            1 -> {
                val aleatorio = (0..9).shuffled().take(4)
                var contador = 1
                val fichero = File(archivoIntentos)
                if(fichero.exists()) {
                    fichero.writeText("")
                    File(archivoIntentos).appendText("EL NUMERO SECRETO ERA: $aleatorio \n")
                }

                println("Juguemos a adivinar un número: ")
                println("Acabo de generar un número aleatorio de 4 cifras que no se repiten, debes adivinarlo en un máximo de 10 intentos ")


                loop1@ while (contador <= 10) {
                    println("Introduce tu número $contador")
                    val entrada: String = readln()
                    val sAleatorio = aleatorio.toString().replace(", ", "").replace("[", "").replace("]", "")
                    val sEntrada = entrada.padStart(4, '0')
                    var coincidencias = 0
                    var aciertos = 0





                    if (entrada.length > 4 || entrada.length < 4) {
                        println("${BG_WHITE}${BLACK}${BOLD}Te he pedido un numero entero de 4 cifras, no desperdicies tus intentos${RESET}")
                        continue@loop1

                    }

                        loop2@ for (i in 0..3) {
                            if (sEntrada[i] == sAleatorio[i]) {
                                aciertos += 1
                            } else {
                                if (sEntrada[0] == sAleatorio[i] ||
                                    sEntrada[1] == sAleatorio[i] ||
                                    sEntrada[2] == sAleatorio[i] ||
                                    sEntrada[3] == sAleatorio[i]
                                ) {
                                    coincidencias += 1
                                }
                            }
                        }

                        if (sEntrada == (sAleatorio)) {
                            println("${BG_WHITE}${BLACK}${BOLD}Enhorabuena, has acertado, 4/4 aciertos.")
                            val miString = "Intento $contador: $sEntrada Enhorabuena has acertado 4/4 aciertos "
                            File(archivoIntentos).appendText("$miString \n")
                            return
                        } else {
                            val miString = "Intento $contador: $sEntrada = Aciertos: $aciertos, Coincidencias: $coincidencias "
                            println("${BG_WHITE}${BLACK}${BOLD}Tienes ${RESET} ${BG_BLACK}${RED}${BOLD}$coincidencias ${RESET}${BG_WHITE}${BLACK}${BOLD} coincidencias y ${RESET}${BG_BLACK}${RED}${BOLD} $aciertos ${RESET}${BG_WHITE}${BLACK}${BOLD} aciertos, sigue intentandolo.")
                            File(archivoIntentos).appendText("$miString \n")
                        }
                        contador+=1
                    }

                println("Has agotado tus intentos.")
            }

            2 -> {
                val fichero = File(archivoIntentos)
                if(fichero.exists()) {
                val contenido =
                    File(archivoIntentos).readText()
                println (contenido) }

            else {
                println("Primero debes realizar un intento")
            }
        }
            3 -> { println("Fin del programa")
                val fichero = File("C:\\Users\\Miguel\\IdeaProjects\\Adivinanumero\\AdivinanumeroIntentos.txt")
                if(fichero.exists()) {
                    fichero.writeText("")
                }

            }
        }
    } while (menu !=3)
}

    fun main() {
        guessAnumber()
    }
