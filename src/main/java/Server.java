import java.io.IOException;

import com.sun.jersey.simple.container.SimpleServerFactory;

public class Server {
	public static void main(String[] args) throws IllegalArgumentException, IOException {
		SimpleServerFactory.create("http://localhost:8080/");
	}
}
