package tourGuide.domain;

import java.util.UUID;

import gpsUtil.location.Attraction;
import gpsUtil.location.Location;
import tourGuide.service.RewardsService;
import tourGuide.user.User;

public class User_Attraction {
	RewardsService rewardsService;

	String attractionName;
	UUID attractionUUID;
	Location attractionLocation;

	UUID userUUID;
	Location userLocation;

	Double distance;

	int rewardPoints;

	User_Attraction(User user, Attraction attraction) {
		
		//rewardsService = new RewardsService();
		//revoir le constructeur de UUID
		this.userUUID = user.getUserId();
		this.userLocation = user.getLastVisitedLocation().location;

		this.attractionUUID = attraction.attractionId;
		this.attractionLocation = new Location(attraction.latitude, attraction.longitude);

		this.distance = rewardsService.getDistance(userLocation, attractionLocation);
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

}
