package xy.inc.client.model;

import javax.validation.constraints.Min;

public class LocationDistance
{
	@Min(0)
	private Integer coordinate_x;

	@Min(0)
	private Integer coordinate_y;

	@Min(0)
	private Double distance;

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

	public Double getDistance()
	{
		return distance;
	}

	public void setDistance(Double distance)
	{
		this.distance = distance;
	}
}