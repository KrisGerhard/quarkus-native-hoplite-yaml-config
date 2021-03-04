package org.acme

import com.sksamuel.hoplite.ConfigLoader
import java.nio.file.Path.of
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello-resteasy")
class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): String {
        val config = ConfigLoader().loadConfigOrThrow<Config>(of("application.yaml"))
        return config.greetingText
    }
}
