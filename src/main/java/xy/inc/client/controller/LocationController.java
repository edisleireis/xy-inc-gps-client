package xy.inc.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import xy.inc.client.model.Location;
import xy.inc.client.model.LocationDistance;

@Controller
public class LocationController
{
    @RequestMapping(value = "*", method = RequestMethod.GET)
    public String findall(Model model)
    {
		try
		{
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target("https://xy-inc-gps-server.herokuapp.com/v1/locations/findall");
			Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
			Response response = builder.get();
			String body = response.readEntity(String.class);

			verifyBody(body, model);
		}
		catch (IOException e)
		{
			model.addAttribute("filter_error", "");
			e.printStackTrace();
		}

		return "locations";
    }

    @RequestMapping(value = "/filtered", method = RequestMethod.POST)
    public String finddistance(@Valid LocationDistance locationdistance, Model model)
    {
    	try
		{
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target("https://xy-inc-gps-server.herokuapp.com/v1/locations/findbydistance").queryParam("coordinate_x", locationdistance.getCoordinate_x()).queryParam("coordinate_y", locationdistance.getCoordinate_y()).queryParam("distance", locationdistance.getDistance());
			Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
			Response response = builder.get();
			String body = response.readEntity(String.class);

			verifyBody(body, model);

			model.addAttribute("filter", "Filtro aplicado: Coordenada X = " + locationdistance.getCoordinate_x() + " Coordenada Y = " + locationdistance.getCoordinate_y() + " Distância = " + locationdistance.getDistance());
			model.addAttribute("filter_error", "");
		}
		catch (Exception e)
		{
			model.addAttribute("filter", "");
			model.addAttribute("filter_error", "Erro ao consultar a lista de Pontos de Interesse pela Distância!");
			model.addAttribute("locations", "");
			e.printStackTrace();
		}

		return "filtered";
    }

    @RequestMapping(value = "/new-poi", method = RequestMethod.GET)
    public String new_poi()
    {
		return "new-location";
    }


    @RequestMapping(value = "/save-poi", method = RequestMethod.POST)
    public String save_poi(@Valid Location location, Model model)
    {
		try
		{
	    	Client client = ClientBuilder.newClient();
			WebTarget target = client.target("https://xy-inc-gps-server.herokuapp.com/v1/locations/register");
			Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
			Response response = builder.post(Entity.entity(location, MediaType.APPLICATION_JSON));
			String body = response.readEntity(String.class);

			if (!body.isEmpty())
			{
				model.addAttribute("filter", "Novo Ponto de Interesse cadastrado!");
			}
			else
			{
				model.addAttribute("filter", "Erro ao cadastro o novo Ponto de Interesse!");
			}
		}
		catch (Exception e)
		{
			model.addAttribute("filter_error", "");
			e.printStackTrace();
		}

		return findall(model);
    }

    private void verifyBody(String body, Model model) throws JsonParseException, JsonMappingException, IOException
    {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Location> locations = objectMapper.readValue(body, objectMapper.getTypeFactory().constructCollectionType(List.class, Location.class));
		if (!locations.isEmpty())
		{
			model.addAttribute("locations", locations);
		}
		else
		{
			model.addAttribute("nolocation", "Nenhum ponto de interesse localizado!");
		}
    }
}