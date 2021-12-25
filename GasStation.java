import java.util.Scanner;
/**
 * A class for a gas station. 
 * It has methods that enable cars to refuel
 * and returns the price they should pay for the service.
 * @author Arthur Viegas Eguia and Marco Acero
 * @version 1.0.0 made in 09/23/2021
 */
public class GasStation{
    /**
     * clients is a variable corresopnding to the number
     * of cars who have been to the gas station.
     */
    private static int clients = 0;
    /**
     * priceOfGas is a real number > 0 which
     * represents the price of gas at the gas station.
    */
    private static float priceOfGas;
    /**
     * amountOfGas is a real number >= 0 which
     * represents the amount of fuel a user has in their gas tank.
     */
    private float amountOfGas;
    /**
     * fullCapacity a real number >= amountOfGas which represents the
     * full capacity of an user's gas tank.
     */
    private float fullCapacity;
    /**
     * Creates an instance of the class and adds 1 to the number of clients of the gas station.
     * @param amountOfGas A real number > 0 and less than fullCapacity which represents the amount of gas a car has on its tank
     * @param fullCapacity A real number > 0 and greater than amountOfGas which represents the full capacity of a car's gas tank
     */
    public GasStation(float amountOfGas, float fullCapacity){
        this.amountOfGas = amountOfGas;
        this.fullCapacity = fullCapacity;
        clients++;
    } //end GasStation
    /**
     * Gets the price of gas at the Gas Station
     * @return float representing the price of gas at the gas sttation
     */
    public static float getPriceOfGas(){
        return priceOfGas;
    } //end getPriceOfGas
    /**
     * Gets the number of clients of the Gas Station
     * @return integer representing the number of clients of the gas sttation
     */
    public static int getClients(){
        return clients;
    } //end getClients
    /**
     * Gets the amount of gas in the car's fuel tank.
     * @return a float representing the amount of gas in the car's fuel tank
     */
    public float getAmountOfGas(){
        return this.amountOfGas;
    } //end getAmountOfGas
    /**
     * Gets the full capacity of the car's fuel tank.
     * @return a float representing the full capacity of a car's fuel tank
     */
    public float getFullCapacity(){
        return this.fullCapacity;
    } //end getFullCapacity
    /**
     * Sets the price of gas at the Gas Station
     * @param priceOfGasLocal a real number > 0 representing the price of gas
     */
    public static void setPriceOfGas(float priceOfGasLocal){
        priceOfGas = priceOfGasLocal;
    } //end setPriceOfGas
    /**
     * Sets the amount of gas in the car's fuel tank.
     * @param amountOfGas a real number > 0 and < fullCapacity representing the amount of gas in a car's fuel tank
     */
    public void setAmountOfGas(float amountOfGas){
        this.amountOfGas = amountOfGas;
    } //end setAmountOfGas
    /**
     * Sets the full capacity of the car's fuel tank.
     * @param fullCapacity a real number > fullCapacity that represents the full capacity of the car's fuel tank.
     */
    public void setFullCapacity(float fullCapacity){
        this.fullCapacity = fullCapacity;
    } //end setFullCapacity
    /**
     * Checks if the amount of gas the user wants to buy is more than their fuel tank can hold
     * @param gallonsWanted a real number > 0
     * @return true in case ofoverflow in the tank; otherwise, 
     *         false
     */
    private boolean checkOverflow(float gallonsWanted){
        return gallonsWanted > (getFullCapacity() - getAmountOfGas());
    } //end checkOverflow
    /**
     * Fills the gas tank with the amount of gallons the user wants to buy.
     * Adds the amount of gallons bought to amountOfGas.
     * Prints the total price to pay alongside the number of gallons added to the fuel tank.
     * @param gallonsToFill a real number > 0 representing the number of  gallons the user wants to buy
     */
    public void fillTank(float gallonsToFill){
        if(!(checkOverflow(gallonsToFill))){
            setAmountOfGas(getAmountOfGas() + gallonsToFill);
            System.out.println("You have put " + gallonsToFill + " in your tank. For this you have to pay $" + totalAmountToPay(gallonsToFill));
        } else{
            System.out.println("Error! could not fill tank. this would result in gas overflow");
        }
    } //end fillTank
    /**
     * Completely fills the users's gas tank.
     * Sets the value of amountOfGas to fullCapacity.
     * Prints the amount of gallons added to the tank and the price to pay.
     */
    public void fillTankCompletely(){
        float gallons = getFullCapacity() - getAmountOfGas();
        setAmountOfGas(getFullCapacity());
        System.out.println("You have filled your tank with " + gallons + " Gallons of gas. You have to pay $" + totalAmountToPay(gallons));
    } //end fillTankCompletely
    /**
     * Calculates the price a user should pay for a certain amount of gallons.
     * @param gallons a real number > 0, representing the amount of gallons
     * @return the price a user should pay for buying a certain amount of gallons
     */
    private float totalAmountToPay(float gallons){
        return gallons * getPriceOfGas();
    } //end totalAmountToPay
/**
 * The part were the code is run. 
 *   It creates instances of the class and calls some of the methods.
 * It demonstrates that the operations are performing successfully.
 * @param args a real number > 0 representing the price of gas in the gas station
 */    public static void main(String[] args){
        if (args.length == 0) { 
            System.err.println("Usage: java CommandLine priceOfGas");  
            System.exit(1);
        }
        GasStation.priceOfGas = Float.parseFloat(args[0]);
        Scanner userInput = new Scanner(System.in);
        System.out.println("How much gas do you currently have in your tank?");
        float gasAmount = userInput.nextFloat();
        System.out.println("What is the full capacity of your tank?");
        float tankCapacity = userInput.nextFloat();
        GasStation car1 = new GasStation(gasAmount, tankCapacity);
        System.out.println("Hello you are our client number " + GasStation.getClients());
        car1.fillTankCompletely();
        System.out.println("How much gas do you currently have in your tank?");
        float gasAmount2 = userInput.nextFloat();
        System.out.println("What is the full capacity of your tank?");
        float tankCapacity2 = userInput.nextFloat();
        GasStation car2 = new GasStation(gasAmount2, tankCapacity2);
        System.out.println("Hello you are our client number " + GasStation.getClients());
        System.out.println("How many gallons of gas do you want to put in your tank?");
        float gallonsToBuy = userInput.nextFloat();
        car2.fillTank(gallonsToBuy);
        userInput.close();
        
    } //end main
}