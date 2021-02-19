/**
 * Developer: Dennis Dao
 * Date: Nov 29, 2020
 * Version 1.1
 */

// Imports
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * This makes a Calculator class
 * EDIT: Jan 16, 2021 - Revised necessity of some classes, turned some into functions, and fully finished version 1.1
 * Memory class allows storing and erasing of results of calculator use
 * Variable class allows use of variables
 * Menu class allows displaying of options and some results
 */
public class Calculator{
    // Functions
    /**
     * Function to perform binary operations
     * @param num1 First number inputted by the user
     * @param operator Operator inputted by the user according to the menu
     * @param num2 Second number inputted by the user
     * @return The answer of the operation
     */
    private static double binaryMath(double num1, String operator, double num2){
        // Helper variable
        double answer = 0;
        
            // Addition
            if(operator.equals("+")){
                answer = num1 + num2;
            }
            // Subtraction
            else if(operator.equals("-")){
                answer = num1 - num2;
            }
            // Multiplication
            else if(operator.equals("*")){
                answer = num1 * num2;                    
            }
            // Division
            else if(operator.equals("/")){
                answer = num1 / num2;
            }
            // Modulus
            else if(operator.equals("%")){
                answer = (int)num1 % (int)num2;
            }
            // Power
            else if(operator.toUpperCase().equals("P")){
                answer = Math.pow(num1, num2);
            }
            // Max
            else if(operator.toUpperCase().equals("X")){
                answer = Math.max(num1, num2);
            }
            // Min
            else if(operator.toUpperCase().equals("I")){
                answer = Math.min(num1, num2);
            }
            return answer;
    }

    /**
     * Function to do unary functions
     * @param num A number inputted by the user
     * @param operator A unary operator according to the list of options
     * @return The answer of the operation
     */
    private static double unaryMath(double num, String operator){
        // Helper variable
        double answer = 0;
        
        // Square root
        if(operator.toUpperCase().equals("S")){
            answer = Math.sqrt(num);
        }
        // Log
        else if(operator.toUpperCase().equals("L")){
            answer = Math.log(num);
        }
    
        // Exponentiation
        else if(operator.toUpperCase().equals("E")){
            answer = Math.exp(num);
        }
    
        // Ceiling function
        else if(operator.toUpperCase().equals("C")){
            answer = Math.exp(num);
        }
    
        // Floor function
        else if(operator.toUpperCase().equals("F")){
            answer = Math.exp(num);
        }
        return answer;
    }

    /**
     * Function to validate input for advanced operations
     * @param numEntered The numbered the user entered that should be validated
     * @param variable The current set of variables as an object
     * @return The value to be assigned
     */
    private static double checkInput(String numEntered, Variables variable){
        double num;
        // Check if a double can be parsed from the string
        try{
            num = Double.parseDouble(numEntered);
        }
        // Check if the string matches a valid variable
        catch(NumberFormatException exception){
            if(numEntered.toLowerCase().equals("a")){
                num = variable.getVariable("a");
            }
            else if(numEntered.toLowerCase().equals("b")){
                num = variable.getVariable("b");
            }
            else if(numEntered.toLowerCase().equals("c")){
                num = variable.getVariable("c");
            }
            else if(numEntered.toLowerCase().equals("d")){
                num = variable.getVariable("d");
            }
            else if(numEntered.toLowerCase().equals("e")){
                num = variable.getVariable("e");
            }
            else{
                System.out.println("The input was invalid. Assuming an input of 0");
                num = 0;
            }
        }
        return num;
    }

    /**
     * Test the methods of the class
     * @param args not used
     */
    public static void main(String args[]){
        // Variable definitions
        String option, optionAdvanced, input, operator, varInput, advancedInput;
        boolean exit = false, advancedExit = false, memoryExit = false;
        ArrayList<Double> calcMemory = new ArrayList<Double>();
        String[] binaryOperators = {"+", "-", "*", "/", "%", "P", "X", "I"}, unaryOperators = {"S", "L", "E", "C", "F"};
        Set<String> validBinary = new HashSet<>(), validUnary = new HashSet<>();
        Scanner in = new Scanner(System.in);
        double num1, num2, answer;
        int memInput;

        // Some concepts of a calculator as objects
        Variables variableOperator = new Variables();
        Memory calculatorMemory = new Memory();
        Menu menus = new Menu();

        // Set up the sets to be used to check for valid operators
        for(String validOp : binaryOperators){
            validBinary.add(validOp);
        }
        for(String validOp : unaryOperators){
            validUnary.add(validOp);
        }

        // Welcome message
        System.out.println("----------------------------------------------");
        System.out.println("Welcome to my Command Line Calculator!");
        System.out.println("Developer: Dennis Dao");
        System.out.println("Date: January 16, 2021");
        System.out.println("Version: 1.1");
        System.out.println("----------------------------------------------");

        // While the user doesn't want to exit yet, check for input
        while(exit == false){
            advancedExit = false;
            memoryExit = false;

            // Print the main options
            System.out.println(menus.mainMenu());
            // Take input
            option = in.next();
            System.out.println();

            // Binary mathematics
            if(option.toUpperCase().equals("B")){
                // Check for numbers and operation
                System.out.println("Enter the first number: ");
                try{
                    num1 = Double.parseDouble(in.next());
                }
                catch(NumberFormatException exception){
                    System.out.println("Invalid input.\n");
                    continue;
                }
            
                System.out.println("Enter the operator: ");
                System.out.println(menus.binaryOptions());
                operator = in.next();

                // Invalid operator entered
                while(validBinary.contains(operator.toUpperCase()) == false){
                    System.out.println("Enter a valid operator: ");
                    System.out.println(menus.binaryOptions());
                    operator = in.next();
                }

                System.out.println("Enter the second number: ");
                try{
                    num2 = Double.parseDouble(in.next());
                }
                catch(NumberFormatException exception){
                    System.out.println("Invalid input.\n");
                    continue;
                }

                // Attempting to divide by 0
                while((operator.equals("/") || operator.equals("%")) && num2 == 0){
                    System.out.println("Please enter a non-zero number: ");
                    try{
                        num2 = Double.parseDouble(in.next());
                    }
                    catch(NumberFormatException exception){
                        continue;
                    }
                }
                
                // Perform the operation 
                answer = binaryMath(num1, operator, num2);
                calcMemory.add(answer);
                System.out.printf(menus.displayBinaryAnswer(num1, operator, num2, answer));
            }

            // Unary mathematics
            else if(option.toUpperCase().equals("U")){
                // Check for number and operation
                System.out.println("Enter the first number: ");
                try{
                    num1 = Double.parseDouble(in.next());
                }
                catch(NumberFormatException exception){
                    System.out.println("Invalid input.\n");
                    continue;
                }
                System.out.println("Enter the operator: ");
                System.out.println(menus.unaryOptions());
                operator = in.next();

                // Inalid operator
                while(validUnary.contains(operator.toUpperCase()) == false){
                    System.out.println("Enter a valid operator: ");
                    System.out.println(menus.unaryOptions());
                    operator = in.next();
                }

                // Invalid inputs: negative and zero log, negative roots
                while((operator.toUpperCase().equals("L") && num1 <= 0) || (operator.toUpperCase().equals("S") && num1 < 0)){
                    System.out.println("The inputted number is invalid for the operation");
                    System.out.println("You are either: "); 
                    System.out.println("* Trying to take the logarithm of a number less than or equal to 0");
                    System.out.println("* Trying to take the square root of a negative number");
                    System.out.println("Please enter a valid number");
                    try{
                        num1 = Double.parseDouble(in.next());
                    }
                    catch(NumberFormatException exception){
                        continue;
                    }
                }
                
                // Perform the operation 
                answer = unaryMath(num1, operator);
                calcMemory.add(answer);
                System.out.printf(menus.displayUnaryAnswer(num1, operator, answer));
            }

            // Advanced mathematics
            else if(option.toUpperCase().equals("A")){
                // Get the user's option again.
                while(advancedExit == false){
                    System.out.println(menus.advancedOptions());
                    optionAdvanced = in.next();

                    // Binary mathematics
                    if(optionAdvanced.toUpperCase().equals("B")){
                        // Get the first number
                        System.out.println("Enter a number or variable");
                        advancedInput = in.next();
                        num1 = checkInput(advancedInput, variableOperator);

                        // Get the operator
                        System.out.println("\nEnter the operator: ");
                        System.out.println(menus.binaryOptions());
                        operator = in.next();

                        // Invalid operator entered
                        while(validBinary.contains(operator.toUpperCase()) == false){
                            System.out.println("Enter a valid operator: ");
                            System.out.println(menus.binaryOptions());
                            operator = in.next();
                        }

                        // Get the second number
                        System.out.println("Enter the second number: ");
                        advancedInput = in.next();
                        num2 = checkInput(advancedInput, variableOperator);

                        // Attempting to divide by 0 - ask for the 2nd number again until valid
                        while((operator.equals("/") || operator.equals("%")) && num2 == 0){
                            System.out.println("Please enter a non-zero number: ");
                            advancedInput = in.next();
                            num2 = checkInput(advancedInput, variableOperator);
                        }

                        // Perform the operation
                        answer = binaryMath(num1, operator, num2);
                        calcMemory.add(answer);
                        System.out.printf(menus.displayBinaryAnswer(num1, operator, num2, answer));            
                    }

                    // Unary mathematics
                    else if(optionAdvanced.toUpperCase().equals("U")){
                        System.out.println("Enter a number or variable");
                        advancedInput = in.next();
                        num1 = checkInput(advancedInput, variableOperator);

                        // Get the operator
                        System.out.println();
                        System.out.println("Enter the operator: ");
                        System.out.println(menus.unaryOptions());
                        operator = in.next();

                        // Invalid operator entered
                        while(validUnary.contains(operator.toUpperCase()) == false){
                            System.out.println("Enter a valid operator: ");
                            System.out.println(menus.unaryOptions());
                            operator = in.next();
                        }

                        // Invalid inputs: negative and zero log, negative roots
                        while((operator.toUpperCase().equals("L") && num1 <= 0) || (operator.toUpperCase().equals("S") && num1 < 0)){
                            System.out.println("The inputted number is invalid for the operation");
                            System.out.println("You are either: "); 
                            System.out.println("* Trying to take the logarithm of a number less than or equal to 0");
                            System.out.println("* Trying to take the square root of a negative number");
                            System.out.println("Please enter a valid number");
                            advancedInput = in.next();
                            num1 = checkInput(advancedInput, variableOperator);
                        }

                        // Perform the operation
                        answer = unaryMath(num1, operator);
                        calcMemory.add(answer);
                        System.out.printf(menus.displayUnaryAnswer(num1, operator, answer));
                    }

                    // Exit to the main menu
                    else if(optionAdvanced.toUpperCase().equals("E")){
                        advancedExit = true;
                        System.out.println("Returning to the main menu.\n");
                    }
                    else{
                        System.out.println("Invalid input.\n");
                    }
                }
            }

            // Defining and setting variables
            else if(option.toUpperCase().equals("V")){
                // Get inputs from user
                System.out.println("Enter a variable name from a-e");
                varInput = in.next();
                System.out.println("Enter a number");
                try{
                    num1 = Double.parseDouble(in.next());
                }
                catch(NumberFormatException exception){
                    System.out.println("Invalid input.\n");
                    continue;
                }

                // Check for variable inputted.
                if(varInput.toLowerCase().equals("a")){
                    variableOperator.setVariable(varInput, num1);
                    System.out.printf("Variable %s has been set to %f\n\n", varInput.toLowerCase(), num1);
                }
                else if(varInput.toLowerCase().equals("b")){
                    variableOperator.setVariable(varInput, num1);
                    System.out.printf("Variable %s has been set to %f\n\n", varInput.toLowerCase(), num1);
                }
                else if(varInput.toLowerCase().equals("c")){
                    variableOperator.setVariable(varInput, num1);
                    System.out.printf("Variable %s has been set to %f\n\n", varInput.toLowerCase(), num1);
                }
                else if(varInput.toLowerCase().equals("d")){
                    variableOperator.setVariable(varInput, num1);
                    System.out.printf("Variable %s has been set to %f\n\n", varInput.toLowerCase(), num1);
                }
                else if(varInput.toLowerCase().equals("e")){
                    variableOperator.setVariable(varInput, num1);
                    System.out.printf("Variable %s has been set to %f\n\n", varInput.toLowerCase(), num1);
                }
                else{
                    System.out.println("That is not a valid variable.\n\n");
                }
            }

            // Check the memory
            else if(option.toUpperCase().equals("M")){
                while(memoryExit == false){
                    // Check the size of the list before deciding to print
                    if(calcMemory.size() == 0){
                        System.out.println("There is nothing in the memory to print.");
                    }
                    else{
                        // Get memory slot number from user
                        System.out.println(menus.memoryOptions(calcMemory.size()));
                        try{
                            memInput = Integer.parseInt(in.next());
                        }
                        catch(NumberFormatException exception){
                            System.out.println("Invalid input.\n");
                            continue;
                        }

                        // Invalid input
                        while(memInput < 0 || memInput > calcMemory.size()){
                            System.out.println(menus.memoryOptions(calcMemory.size()));
                            try{
                                memInput = Integer.parseInt(in.next());
                            }
                            catch(NumberFormatException exception){
                                continue;
                            }
                        }
                        if(memInput == 0){
                            System.out.println("The calculator memory contains: ");
                            for(int i = 0; i < calcMemory.size(); i++){
                                System.out.printf(calcMemory.get(i) + ", ");
                            }
                        }
                        else{
                            System.out.println("The number in memory slot " + memInput + " is " + calculatorMemory.getMemory(calcMemory, memInput));
                        }
                    }
                    // Ask if the user wants to stop.
                    System.out.println();
                    System.out.println("Continue looking at the memory? C to continue, E to exit.");
                    input = in.next();

                    while(input.toUpperCase().equals("E") == false && input.toUpperCase().equals("C") == false){
                        System.out.println("Invalid input. Enter C to continue, E to exit.");
                        input = in.next();
                    }

                    // Check user input
                    if(input.toUpperCase().equals("E")){
                        System.out.println("Returning to the main menu.\n");
                        memoryExit = true;
                    }
                    else{
                        continue;
                    }
                }
            }

            // Clear the memory
            else if(option.toUpperCase().equals("R")){
                if(calcMemory.size() == 0){
                    System.out.println("There is nothing to erase.\n");
                }
                else{
                    calculatorMemory.eraseMemory(calcMemory);
                    System.out.println("The memory has been cleared.\n");
                }
            }

            // Exit the calculator
            else if(option.toUpperCase().equals("E")){
                System.out.println("Thank you for using my calculator! Hope to see you soon. :D\n");
                exit = true;
            }

            // Invalid entry
            else{
                System.out.println("Invalid input.\n");
            }
        }
        in.close();
    }
}