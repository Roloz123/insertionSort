/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.insertionsortproject.sorting;
import java.util.Scanner;

/**
 *
 * @author matt
 */
public class mainClass {
    
    
    public static void main(String[] args) {
        
        //Variables
        boolean asc;
        boolean random;
        int length;
        Scanner scan = new Scanner(System.in);
        
        //Construction of array
        System.out.println("How long is your list?");
        length = scan.nextInt();
        int[] intArray = new int[length];
        System.out.println("Would you like the list to have random values?");
        random = scan.nextBoolean();
        
        
        //If values are manually input
        if(!random){
            System.out.println("Please enter your values: ");
            int x = 0;
            while(x < length){
                System.out.println("Next Value:");
                intArray[x] = scan.nextInt();
                x++;
            }
            
        }
        
        //If values are random
        if(random){
            int x = 0;
            while(x < length){
                int rando = (int)Math.floor(Math.random() * (100 - 1 + 1) + 1);
                intArray[x] = rando;
                x++;
            }
        }
        
        //Ascending/descending
        System.out.println("Would you like the list to be sorted in an ascending order or descedning?");
        System.out.println("T = asc, F = desc");
        asc = scan.nextBoolean();
        if(asc){
            insertSortAsc(intArray);
        } else {
            insertSortDesc(intArray);
        }
        
    }
    
    
    public static int[] insertSortAsc(int[] intArray){
        int[] numList = intArray;
        int n = numList.length;
        for(int i = 1; i<n; i++){
            //Key to hold current value
            int key = numList[i];
            
            //Previous value index
            int j = i - 1;
            
            //Move elements of the array backwards
            //Comparing key to the previous value
            while(j >= 0 && numList[j] > key){
                //Move values greater than the key forward one value
                numList[j + 1] = numList[j];
                j--;
            }
            
            numList[j + 1] = key;
            
            //Print current array
            System.out.println(printMethod(numList));
        }
        
        return numList;
        
    }
    
    public static int[] insertSortDesc(int[] intArray){
        int[] numList = intArray;
        int n = numList.length;
        for(int i = n - 2; i>= 0; i--){
            //Key to hold current value
            int key = numList[i];
            
            //Previous value
            int j = i + 1;
            
            //Move elements of the array backwards
            //Comparing key to the previous value
            while(j < n && numList[j] < key){
                //Move values greater than the key backwards one value
                numList[j - 1] = numList[j];
                j++;
            }
            
            numList[j - 1] = key;
            
            //Print current array
            System.out.println(printMethod(numList));
        }
        
        return numList;
    }
    
    public static String printMethod(int[] numList){
        String list = "Current Array: ";
        
        for(int i = 0; i<numList.length; i++){
            list = list + " " + (numList[i]);
        }
        
        return list;
    }
    
}
