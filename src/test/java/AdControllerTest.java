import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;


public class AdControllerTest {

    private static final String url = "http://localhost:8090";

    @Before
    public void setUp() {
        // prepare DB
    }

    @Test
    public void TestGetAd() throws Exception {

        String query = "/ad/1";

        // GET
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(url + query);
        Response res = webTarget.request(MediaType.TEXT_PLAIN)
                .accept(MediaType.APPLICATION_JSON)
                .get();
        String str = res.readEntity(String.class);
        Gson gson = new GsonBuilder().serializeNulls().create();
        Ad refAd = new Ad();
        refAd.setAdId(1);
        refAd.setUser(12);
        refAd.setDescription("Nails not included");
        refAd.setTitle("Hammer");
        refAd.setCategory("Manual");
        refAd.setDuration(null);

        assertEquals(gson.toJson(refAd), str);
    }

    @Test
    public void TestAddAd() throws Exception {

        // POST example
        /*
        Gson gson = new Gson();
        String obj = gson.toJson(new Object());
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(url);
        Response res = webTarget
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.json(obj));
        */

        //assertEquals("unimplemented", true, false);
    }

    @Test
    public void TestGetALlAds() throws Exception {
        String query = "/ad/getads/0";

        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(url + query);
        Response res = webTarget.request(MediaType.TEXT_PLAIN)
                .accept(MediaType.APPLICATION_JSON)
                .get();
        String str = res.readEntity(String.class);

        assertTrue(str.length() >= 2);

    }
}

