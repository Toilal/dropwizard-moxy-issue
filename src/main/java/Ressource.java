import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class Ressource {
	@GET
	@Produces("application/json")
	public Entity get() {
		return new Entity();
	}
}
