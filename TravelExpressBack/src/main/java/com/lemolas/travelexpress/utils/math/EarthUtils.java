package com.lemolas.travelexpress.utils.math;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class EarthUtils {

	public static final Integer EARTH_RADIUS = 6371;

	@Cacheable(value = "defaultCache")
	public Double computeDistance(double latA, double lonA, double latB, double lonB) {

		double latAR = Math.toRadians(latA);
		double latBR = Math.toRadians(latB);
		double lonAR = Math.toRadians(lonA);
		double lonBR = Math.toRadians(lonB);

		double distance = Math
				.acos(Math.sin(latAR) * Math.sin(latBR) + Math.cos(latAR) * Math.cos(latBR) * Math.cos(lonBR - lonAR))
				* EARTH_RADIUS;

		return distance;
	}
}
