package control;

import entity.Place;
import entity.Plan;

/**
 * Created by dbakti7 on 10/20/2015.
 * This class implements PlanGenerator control class that generates a plan based on places selected
 * by the user.
 */

public class PlanGenerator {
    Plan generatedPlan = new Plan();

    /**
     * calculate the total time of the travel
     * @return total time
     */
    public int calculateTime() {
        return 0;
    }

    /**
     * calculate the total cost of the travel
     * @return total cost
     */
    public double calculateCost(){
        return 0.0;
    }

    /**
     * calculate the estimated time of arrival for each place
     * @return ETA
     */
    public int calculateETA() {
        return 0;
    }

    /**
     * return the plan generated by this control class
     * @return generated plan in the form of Plan entity
     */
    public Plan getGeneratedPlan() {
        return generatedPlan;
    }

    /**
     * generates the plan based on given places
     * @param listPlace
     */
    public void generatePlan(Place[] listPlace) {

    }
}