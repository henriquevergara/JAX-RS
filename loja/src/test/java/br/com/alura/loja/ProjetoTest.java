package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.modelo.Projeto;
import br.com.alura.loja.servidor.Servidor;
import junit.framework.Assert;

public class ProjetoTest {

	private HttpServer server;

	@Before
	public void before() {

		server = Servidor.inicializaServidor();

	}

	@After
	public void after() {
		server.stop();
	}
	
	@Test
	public void testaRetornoDoServidorParaProjetos() {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("/projetos").request().get(String.class);
		System.out.println(conteudo);
		Projeto projeto = (Projeto) new XStream().fromXML(conteudo);
		Assert.assertEquals(2014, projeto.getAnoDeInicio());
	}
	
}
