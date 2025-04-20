package object Anagramas {
  type Palabra = String
  type Frase = List[Palabra]
  type Occurrencias = List[(Char, Int)]

  val diccionario: List[Palabra] = List("cosas", "como", "yo", "y", "ocasos", "cayo", "mocosos", "roca", "moco", "sos")

  def lOcPal(p: Palabra): Occurrencias = {
    (for {
      (char, cadena) <- p.groupBy((caracter:Char) => caracter)
    } yield (char, cadena.length)).toList
  }

  def lOcFrase(f: Frase): Occurrencias = {
    lOcPal((for {
      p <- f
    } yield p).mkString)
  }

  lazy val diccionarioPorOcurrencias: Map[Occurrencias, List[Palabra]] = {
    diccionario.groupBy(palabra => lOcPal(palabra))
  }

  def anagramaDePalabra(pal: Palabra): List[Palabra]= {
    diccionarioPorOcurrencias.getOrElse(lOcPal(pal),Nil)
  }


  def combinaciones(lOcurrencias: Occurrencias): List[Occurrencias] = {
    lOcurrencias.foldLeft(List[Occurrencias](Nil)) { (combinacionesAcumuladas, ocurrencia) =>
      val (caracter, maximo) = ocurrencia
      val opciones = for {
        k <- 0 to maximo
      } yield if (k == 0) Nil else List((caracter, k))
      for {
        combinacionExistente <- combinacionesAcumuladas
        opcion <- opciones
      } yield combinacionExistente ::: opcion
    }

  }

  def complemento(lOc: Occurrencias, slOc: Occurrencias): Occurrencias = {
    val slMap: Map[Char, Int] = slOc.toMap
    for {
      (c, count) <- lOc
      newCount = count - slMap.getOrElse(c, 0)
      if newCount > 0
    } yield (c, newCount)
  }

  def anagramasDeFrase(frase: Frase): List[Frase] = {
    val occFrase: Occurrencias = lOcFrase(frase)
    def recursion(occs: Occurrencias): List[Frase] = {
      occs match
        case Nil => List(Nil)
        case occs =>
          for {
            subset <- combinaciones(occs)
            palabra <- diccionarioPorOcurrencias.getOrElse(subset, Nil)
            resto   = complemento(occs, subset)
            anasResto <- recursion(resto)
          } yield palabra :: anasResto
    }
    recursion(occFrase)
  }

}
