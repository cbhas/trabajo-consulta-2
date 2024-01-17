import scala.concurrent.{ExecutionContext, Future} // Importa clases para Futures
import scala.util.{Failure, Success} // Importa clases para manejar resultados

object ProgramaFutbol { // Define un objeto

  implicit val ec: ExecutionContext = ExecutionContext.global // Crea un ExecutionContext global

  def main(partidos: List[String]): Unit = { // Define el método main
    // Obtenemos resultados de forma asíncrona
    val resultados: Future[List[(Int, String, String, Int, Int)]] = Future {
      // Simula llamada asíncrona
      Thread.sleep(1000)
      val partidos: List[(Int, String, String, Int, Int)] = List(
        (5, "Real Madrid", "Barcelona", 4, 1),
        (4, "Barcelona", "Osasuna", 2, 0),
        (3, "Barbastro", "Barcelona", 2, 3),
        (2, "Las Palmas", "Barcelona", 1, 2),
        (1, "Barcelona", "América", 2, 3)
      )
      partidos // Retorna resultados

    }

    // Escuchamos los resultados cuando estén listos
    resultados.onComplete {
      case Success(partidos) =>
        // Código cuando es exitoso
        println("Los resultados de los partidos de fútbol de hoy son:")
        for (partido <- partidos) {
          println(s"\tPartido ${partido._1}: ${partido._2} \tvs\t ${partido._3} \t(${partido._4} - ${partido._5})")
        }

      case Failure(e) =>
        // Código cuando falla
        println("Se ha producido un error al obtener los resultados de los partidos:")
        e.printStackTrace()
    }

    // Esperamos a que se obtengan los resultados
    Thread.sleep(2000)
  } // Cierra el método main

} // Cierra el objeto

// Sebastián "cbhas" Calderón
