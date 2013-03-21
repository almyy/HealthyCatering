/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logikk;

/**
 *
 * @author Rino
 */
public enum Status {

    PENDING(1, "The order is waiting to be made"),
    UNDER_PREPARATION(2, "The order is currently being made by the chefs"),
    PENDING_DELIVERY(3, "The food is waiting for a driver"),
    ON_THE_ROAD(4, "The food is currently on it's way"),
    FINISHED(5, "The order has been successfully delivered"),
    MISSING(6, "No one knows what happened to the order"),
    NEEDS_APPROVAL(7, "A salesman must approve or disapprove this order"),
    NULL(0, "There is no registered order");
    private int code;
    private String description;

    private Status(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return this.toString();
    }
}