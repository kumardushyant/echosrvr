package tut.dushyant.echosrvr

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EchosrvrApplication

fun main(args: Array<String>) {
    runApplication<EchosrvrApplication>(*args)
}
