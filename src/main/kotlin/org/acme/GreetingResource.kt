package org.acme

import com.sksamuel.hoplite.ConfigLoader
import org.slf4j.LoggerFactory
import java.nio.file.Path.of
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello-resteasy")
class GreetingResource {

    private final val log = LoggerFactory.getLogger(this::class.java.simpleName)

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): String {
        Config::class.constructors.forEach { constructor ->
            constructor.parameters.map { parameter ->
                log.info("constructor parameter type: " + (parameter.type).toString())
                log.info("constructor parameter type classifier: " + (parameter.type.classifier).toString())
            }
        }
        val config = ConfigLoader().loadConfigOrThrow<Config>(of("application.yaml"))
        return config.greetingText
    }
}
