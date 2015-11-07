package control;

import java.util.List;

import entity.Location;
import entity.Plan;

/**
 * Created by dbakti7 on 10/20/2015.
 * This class implements PlanGenerator control class that generates a plan based on places selected
 * by the user.
 */

public class PlanGenerator {
    private Plan generatedPlan = new Plan();

    /**
     * generate a travel plan based on locations selected by the user, the locations will be listed
     * from West to East direction
     * @param currentPlacesList Locations selected by the user
     * @param year year of travel plan
     * @param month month of travel plan
     * @param dateofMonth date of travel plan
     */
    public void generatePlan(List<Location> currentPlacesList, int year, int month, int dateofMonth) {
        generatedPlan.setDate(String.valueOf(year) + String.valueOf(month) + String.valueOf(dateofMonth));
        String[] locationList = new String[currentPlacesList.size()];

        // sorting based on longitude
        for(int i = 1;i<currentPlacesList.size();++i) {
            for(int j = i-1;j>=0;--j) {
                if(currentPlacesList.get(i).getLongitude() >= currentPlacesList.get(j).getLongitude())
                    break;
                Location temp = currentPlacesList.get(i);
                currentPlacesList.set(i, currentPlacesList.get(j));
                currentPlacesList.set(j, temp);
            }
        }
        for(int i = 0;i<currentPlacesList.size();++i) {
            locationList[i] = currentPlacesList.get(i).getName();
            Location l = new Location();
            l.setName(locationList[i]);
            generatedPlan.addLocation(l);
        }
    }

    /**
     * @return the travel plan that has been generated
     */
    public Plan getGeneratedPlan() {
        return generatedPlan;
    }
}
