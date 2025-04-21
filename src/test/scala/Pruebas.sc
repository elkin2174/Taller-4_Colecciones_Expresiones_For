import Anagramas._
/*
* Palabras de prueba
* */
val pal1 = "cemento"
val pal2 = "espiral"
val pal3 = "aaaaaaaaaaaaaaaaallllaaaaaaaaaaaaaaaaaaaa"
val pal4 = "ztztztztztztztzt"
val pal5 = "desoxirribonucleotido"
/*
* Pruebas funcion lOpal()
* */
lOcPal(pal1)
lOcPal(pal2)
lOcPal(pal3)
lOcPal(pal4)
lOcPal(pal5)

lOcPal("salgoconamor") == lOcPal("losgnomoarca")
lOcPal("gnomo")



/*
 Frases a utilizar
 */
val frasetest = List("cosas", "como", "yo")
val frase1 = List("el", "leon", "de", "noel")
val frase2 = List("yo", "camino", "solo")
val frase3 = List("amor", "no", "sale")
val frase4 = List("salgo", "con", "amor")
val frase5 = List("me", "ganan", "los", "dias")
/*
* Pruebas funcion lOcFrase()*/

val occf1 = lOcFrase(frase1)
val occf2 = lOcFrase(frase2)
val occf3 = lOcFrase(frase3)
val occf4 = lOcFrase(frase4)
val occf5 = lOcFrase(frase5)

/*
  Pruebas anagrama de palabra
 */
anagramaDePalabra(pal1)
anagramaDePalabra("sola")
anagramaDePalabra("amor")
anagramaDePalabra("cosas")
anagramaDePalabra("paso")
anagramaDePalabra("loma")

combinaciones(occf1)
combinaciones(occf2)
combinaciones(occf3)
combinaciones(occf4)
combinaciones(occf5)

complemento(occf1, List(('e', 3), ('n',3)))
complemento(occf2, occf2)
complemento(occf3, ('a',5)::occf3)
complemento(occf4, occf4.tail)
complemento(occf5, occf5.head::Nil)

anagramasDeFrase(frasetest)
anagramasDeFrase(frase1)
anagramasDeFrase(frase2)
anagramasDeFrase(frase3)
anagramasDeFrase(frase4)
anagramasDeFrase(frase5)





