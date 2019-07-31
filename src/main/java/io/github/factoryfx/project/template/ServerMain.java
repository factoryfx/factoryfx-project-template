package io.github.factoryfx.project.template;

//import ch.qos.logback.classic.Level;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.status.StatusLogger;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Application start
 */
public class ServerMain {
  public static void main(String[] args) {
    StatusLogger.getLogger().setLevel(Level.OFF);
    Configurator.setRootLevel(Level.INFO);

    new ServerBuilder().builder().microservice().build().start();

    HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build();
    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080")).GET().build();
    try {
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      System.out.println("Server responded: "+response.body());
    } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
