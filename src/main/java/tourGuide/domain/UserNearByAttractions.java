package tourGuide.domain;

import java.util.ArrayList;
import java.util.List;

import gpsUtil.GpsUtil;
import gpsUtil.location.Attraction;
import rewardCentral.RewardCentral;
import tourGuide.user.User;



public class UserNearByAttractions {
	
	private final GpsUtil gpsUtil;
	private final RewardCentral rewardCentral;
	
	public User_Attraction[] items;

	public UserNearByAttractions(User user) {
		List<User_Attraction> user_attractions;
		this.gpsUtil = new GpsUtil();
		this.rewardCentral = new RewardCentral();
		List<Attraction> attractions = gpsUtil.getAttractions();// from rewarsService 41
		user_attractions = new ArrayList<User_Attraction>();
		// ajouter toute les attractions, trier la liste, retenir les 5 premières
		for (Attraction a : attractions) {
			User_Attraction ua = new User_Attraction(user, a);
			user_attractions.add(ua);
		}

		user_attractions.sort((ua1, ua2) -> ((ua1.getDistance())).compareTo((ua2.getDistance())));

		User_Attraction[] items = new User_Attraction[5];

		for (int i = 0; i < 5; i++) {
			items[i] = user_attractions.get(i);
			items[i].rewardPoints = rewardCentral.getAttractionRewardPoints(items[i].attractionUUID, items[i].userUUID);
		}
	}
}
