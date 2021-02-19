/**
 * Developer: Dennis Dao
 * Date: Jan 16, 2021
 * version 1.1
 */

/**
 * Class for a Menu object for the calculator
 */
public class Menu {
    /**
     * List the main options
     * @return Main options
     */
    public String mainMenu(){
        String bar = ("----------------------------------------------\n");
        String message1 = "Enter a command: \nB - Binary Mathematical Operations, such as addition and multiplication\nU - Unary Mathematical Operations, such as square root and log\n";
        String message2 = "A - Advanced Mathematical Operations, using variables\nV - Define variables and assign them values\nM - To see the memory of operations performed\n";
        String message3 = "R - Clear the memory\nE - Exit\n----------------------------------------------";
        return bar + message1 + message2 + message3;
    }

    /**
     * List the binary options
     * @return Binary options
     */
    public String binaryOptions(){
        String message1 = "----------------------------------------------\n+ - Addition\t\t\t- - Subtraction\n* - Multiplication\t\t/ - Division\n";
        String message2 = "% - Modulus\t\t\tP - Power\nX - Maximum of two numbers\tI - Minimum of two numbers\n----------------------------------------------";
        return message1 + message2;
    }

    /**
     * List the unary options
     * @return Unary options
     */
    public String unaryOptions(){
        String message1 = "----------------------------------------------\nS - Square root\t\t\tL - Natural logarithm\nE - Exponentiation (e^x)\tC - Ceiling function\n";
        String message2 = "F - Floor function\n----------------------------------------------";
        return message1 + message2;
    }

    /**
     * List memory options
     * @return Memory options
     */
    public String memoryOptions(int calcMemory){
        String message1 = "----------------------------------------------\nPlease enter a memory slot number or 0 to see the entire list. (greater than 0 and less than ";
        String message2 = "the memory size)\nThere are " + calcMemory + " slot(s)\n----------------------------------------------";
        return message1 + message2;
    }

    public String advancedOptions(){
        String message1 = "----------------------------------------------\nEnter a command:\nB - Binary Mathematical Operations, such as addition and multiplication\n";
        String message2 = "U - Unary Mathematical Operations, such as square root and log\nE - Exit\n----------------------------------------------";
        return message1 + message2;
    }

    /**
     * Display the answer of binary operations
     * @param num1 First number
     * @param operator Binary operation
     * @param num2 Second number
     * @param answer Answer of the operation
     * @return The message to be displayed
     */
    public String displayBinaryAnswer(double num1, String operator, double num2, double answer){
        // Helper variables
        String message = "";
        String bar = "----------------------------------------------\n";

        // Add to the message depending on operation
        if(operator.toUpperCase().equals("P")){
            message = num1 + " to the power " + num2 + " is " + answer + "\n";
        }
        else if(operator.toUpperCase().equals("X")){
            message = answer + " is the largest number\n";
        }
        else if(operator.toUpperCase().equals("I")){
            message = answer + " is the smallest number\n";
        }
        else{
            message = num1 + " " + operator + " " + num2 + " = " + answer + "\n";
        }
        return bar + message + bar;
    }
    
    /**
     * Display the answer of binary operations
     * @param num1 First number
     * @param operator Unary operation
     * @param answer Answer of the operation
     * @return The message to be displayed
     */
    public String displayUnaryAnswer(double num1, String operator, double answer){
        // Helper variables
        String message = "";
        String bar = "----------------------------------------------\n";
        
        // Add to the message depending on operation
        if(operator.toUpperCase().equals("S")){
            message = "The square root of " + num1 + " is " + answer + "\n";
        }
        else if(operator.toUpperCase().equals("L")){
            message = "The natural logarithm of " + num1 + " is " + answer + "\n";
        }
        else if(operator.toUpperCase().equals("E")){
            message = "The exponentiation of " + num1 + " is " + answer + "\n";
        }
        else if(operator.toUpperCase().equals("C")){
            message = "The ceiling of " + num1 + " is " + answer + "\n";
        }
        else if(operator.toUpperCase().equals("F")){
            message = "The floor of " + num1 + " is " + answer + "\n";
        }
        return bar + message + bar;
    }
}
