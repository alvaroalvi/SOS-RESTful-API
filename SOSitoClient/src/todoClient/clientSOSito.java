package todoClient;

import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.client.ClientConfig;
import java.util.Date;

import rest1.JAXBUserModel;
import rest1.JAXBPostModel;
import rest1.JAXBFriendModel;

public class clientSOSito {

	public static void main (String[] args) {

		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI());

		System.out.println("This will be the path: " + target.path("users"));
		
		JAXBUserModel user = new JAXBUserModel();
		user.setIdUser(8);
		user.setUsername(null);
		user.setPostNumber(30);
		user.setName(null);
		user.setLastname("Ruiz");
		user.setGender(null);
		user.setMail(null);
		user.setPhone("3523");
		// System.out.println(target.path("user").path("add").request().accept(MediaType.TEXT_XML).post(Entity.entity(user, MediaType.TEXT_XML)));
		
		JAXBUserModel userDelete = new JAXBUserModel();
		userDelete.setIdUser(6);
		// System.out.println(target.path("user").path("6").path("delete").request().post(Entity.entity(userDelete, MediaType.TEXT_XML)));
		JAXBPostModel newPost = new JAXBPostModel();
		newPost.setIdPost(10);
		newPost.setPostBody("This is my osom post body");
		newPost.setCreationDate("2016-04-27");
		newPost.setUser(5);
		// System.out.println(target.path("posts").path("add").request().post(Entity.entity(newPost, MediaType.TEXT_XML)));
		JAXBPostModel postDelete = new JAXBPostModel();
		postDelete.setIdPost(10);
		// System.out.println(target.path("posts").path("10").path("delete").request().post(Entity.entity(postDelete, MediaType.TEXT_XML)));
		
		JAXBFriendModel friend = new JAXBFriendModel();
		friend.setIdFriend(4);
		System.out.println(target.path("users").path("3").path("friends").path("add").request().post(Entity.entity(friend, MediaType.TEXT_XML)));
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/SOSito/api/v1").build();
	}
}
