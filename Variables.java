/**
 * Developer: Dennis Dao
 * Date: Jan 16, 2021
 * Version 1.1
 */

 /**
  * This makes a Variables class operator for the calculator
  */
public class Variables {
    // Instance variables
    double varA = 0;
    double varB = 0;
    double varC = 0;
    double varD = 0;
    double varE = 0;

    // Methods
    /**
     * Get the value of the variable
     * @param input A variable input
     * @return The value of the variable
     */
    public double getVariable(String input){
        if(input.toLowerCase().equals("a")){
            return this.varA;
        }
        else if(input.toLowerCase().equals("b")){
            return this.varB;
        }
        else if(input.toLowerCase().equals("c")){
            return this.varC;
        }
        else if(input.toLowerCase().equals("d")){
            return this.varD;
        }
        else if(input.toLowerCase().equals("e")){
            return this.varE;
        }
        else{
            return -1;
        }
    }

    /**
     * Set the value of a variable
     * @param input The variable input
     * @param num The number to store
     */
    public void setVariable(String input, double num){
        if(input.toUpperCase().equals("A")){
            this.varA = num;
        }
        else if(input.toUpperCase().equals("B")){
            this.varB = num;
        }
        else if(input.toUpperCase().equals("C")){
            this.varC = num;
        }
        else if(input.toUpperCase().equals("D")){
            this.varD = num;
        }
        else if(input.toUpperCase().equals("E")){
            this.varE = num;
        }
    }
}
