package net.ouftech.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import net.ouftech.jokesprovider.JokesProvider;

import java.util.Random;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.ouftech.net",
                ownerName = "backend.builditbigger.ouftech.net",
                packagePath = ""
        )
)
public class MyEndpoint {

    JokesProvider jokesProvider;

    // Kept for the webpage use but not relevant to the project
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);

        return response;
    }

    @ApiMethod(name = "getJoke")
    public MyBean getJoke() {
        MyBean response = new MyBean();

        String joke = retrieveJoke();

        response.setData(joke);

        return response;
    }

    private String retrieveJoke() {
        if (jokesProvider == null)
            jokesProvider = new JokesProvider();

        Random rand =  new Random();
        return jokesProvider.getJoke(rand.nextInt(10));
    }

}
