/**
 * Developer: Dennis Dao
 * Date: Jan 16, 2021
 * Version 1.0
 */

// Imports
import java.util.ArrayList;

/**
 * This makes a Memory class to perform memory functions
 */
public class Memory {
    // Methods
    /**
     * Get a number from the calculator memory
     * @param memory The list of answers performed by the calculator
     * @param slotNum The slot number of memory to get
     * @return The value of the memory position
     */
    public double getMemory(ArrayList<Double> memory, int slotNum){
        return memory.get(slotNum -1);
    }

    /**
     * Clear the calculator's memory.
     * @param memory The list of answers performed by the calculator
     */
    public void eraseMemory(ArrayList<Double> memory){
        memory.clear();
    }
}
