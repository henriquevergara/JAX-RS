package br.com.alura.loja.servidor;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Servidor {

    public static void main(String[] args) throws IOException {
        HttpServer server = inicializaServidor();
        System.out.println("Servidor Rodando");
        System.in.read();
        server.stop();

    }

	public static HttpServer inicializaServidor() {
		URI uri = URI.create("http://localhost:8080/");
        ResourceConfig config = new ResourceConfig().packages("br.com.alura.loja");
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri,config);
		return server;
	}

}
