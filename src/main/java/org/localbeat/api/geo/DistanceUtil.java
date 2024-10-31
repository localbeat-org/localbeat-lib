package org.localbeat.api.geo;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/****************************************************************************
 * <b>Title:</b> DistanceUtil.java <br>
 * <b>Project:</b> Entertainment <br>
 * <b>Description:</b> creates a bounding box from the provided lat/long and radius <br>
 * <b>Copyright:</b> Copyright (c) 2023 <br>
 * <b>Company:</b> Local Beats
 * 
 * @author etewa
 * @version 1.x
 * @since Mar 27, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class DistanceUtil {
	
	// Semi-axes of WGS-84 geoidal reference
	private static final double WGS84_A = 6378137.0; // Major semiaxis [m]
	private static final double WGS84_B = 6356752.3; // Minor semiaxis [m]
	
	/**
	 * Returns a bounding box with the min/max coordinate of the box
	 * @param point
	 * @param halfSideInMiles
	 * @return
	 */
	public BoundingBox getBoundingBox(Coordinate point, double widthInMiles) {
	    // Bounding box surrounding the point at given coordinates,
	    // assuming local approximation of Earth surface as a sphere
	    // of radius given by WGS84
	    var lat = deg2rad(point.getLatitude());
	    var lon = deg2rad(point.getLongitude());
	    var halfSide = (widthInMiles) * 1609.344;
	    
	    // Radius of Earth at given latitude
	    var radius = earthRadius(lat);
	    
	    // Radius of the parallel at given latitude
	    var pradius = radius * Math.cos(lat);

	    var latMin = lat - halfSide / radius;
	    var latMax = lat + halfSide / radius;
	    var lonMin = lon - halfSide / pradius;
	    var lonMax = lon + halfSide / pradius;
	    
		return new BoundingBox(
			new Coordinate(rad2deg(latMin), rad2deg(lonMin)),
			new Coordinate(rad2deg(latMax), rad2deg(lonMax))
		);
	}
	
	/**
	 * Gives the distance between 2 points
	 * @param start
	 * @param end
	 * @return
	 */
	public double getDistanceBetweenPoints(Coordinate start, Coordinate end) {
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.HALF_UP);
		var radius = 6371; // Radius of the earth in km
		var dLat = deg2rad(end.getLatitude() - start.getLatitude()); // deg2rad below
		var dLon = deg2rad(end.getLongitude() - start.getLongitude());
		var a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(deg2rad(start.getLatitude()))
				* Math.cos(deg2rad(end.getLatitude())) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
		
		var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return Double.valueOf(df.format((radius * c) * .6213712));
	}
	
	/**
	 * Earth radius at a given latitude, according to the WGS-84 ellipsoid [m]
	 * http://en.wikipedia.org/wiki/Earth_radius
	 * @param lat
	 * @return
	 */
	protected double earthRadius(double lat) {
	    var an = WGS84_A * WGS84_A * Math.cos(lat);
	    var bn = WGS84_B * WGS84_B * Math.sin(lat);
	    var ad = WGS84_A * Math.cos(lat);
	    var bd = WGS84_B * Math.sin(lat);
	    return Math.sqrt((an*an + bn*bn) / (ad*ad + bd*bd));
	}
	
	/**
	 * degrees to radians
	 * @param degrees
	 * @return
	 */
	protected double deg2rad(double degrees) {
	    return Math.PI * degrees / 180.0;
	}

	/**
	 * radians to degrees
	 * @param radians
	 * @return
	 */
	protected double rad2deg(double radians) {
	    return 180.0 * radians / Math.PI;
	}

}
