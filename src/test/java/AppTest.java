import io.dropwizard.Configuration;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

public class AppTest {
	@ClassRule
	public static final DropwizardAppRule<Configuration> app = new DropwizardAppRule<Configuration>(
			App.class, ResourceHelpers.resourceFilePath("test.yml"));

	private Client client;

	@Before
	public void setup() {
		client = new JerseyClientBuilder(app.getEnvironment())
				.build("test client");
	}

	@Test
	public void testImpl() {
		WebTarget webTarget = client.target(String.format(
				"http://localhost:%d/", app.getLocalPort()));

		Entity response = webTarget.request().get(Entity.class);
	}
}
