package xy.inc.client.model;

public class Location
{
	private Integer id;
	private String location;
	private Integer coordinate_x;
	private Integer coordinate_y;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public Integer getCoordinate_x()
	{
		return coordinate_x;
	}

	public void setCoordinate_x(Integer coordinate_x)
	{
		this.coordinate_x = coordinate_x;
	}

	public Integer getCoordinate_y()
	{
		return coordinate_y;
	}

	public void setCoordinate_y(Integer coordinate_y)
	{
		this.coordinate_y = coordinate_y;
	}
}