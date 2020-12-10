package tareaFinal;

import java.io.*; 
import java.util.*; 
  
public class Solution { 
      
    
    public static class Job { 
        String id; 
        int deadline; 
        int profit; 
        // Constructor 
        Job(String name, int deadline, int profit) 
        { 
            this.id = name; 
            this.deadline = deadline; 
            this.profit = profit; 
        } 
    } 
    public static class Sorted implements Comparator { 
     
        // Function to implementar comparador
        public int compare(Object o1, Object o2) 
        { 
            Job j1 = (Job)o1; 
            Job j2 = (Job)o2; 
  
            if (j1.profit != j2.profit) 
                return j2.profit - j1.profit; 
            else
                return j2.deadline - j1.deadline; 
        } 
    } 
      
    // Function to print job scheduling 
    public static void printJobScheduling(Job jobs[], int n) 
    {   
        Sorted sorter = new Sorted();           
        //Algoritmo para odenar el array  
        Arrays.sort(jobs, sorter);    
        TreeSet<Integer> ts = new TreeSet<>(); 
  
        for (int i = 0; i < n; i++) 
            ts.add(i); 
  
        for (int i = 0; i < n; i++) { 
            Integer x = ts.floor(jobs[i].deadline - 1); 
  
            if (x != null) { 
                System.out.print(jobs[i].id + " -> "); 
                ts.remove(x); 
            } 
        } 
    } 
    
    public static void main(String[] args) 
    { 
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de tareas :");
        int cantidad = sc.nextInt();
    	
        Job[] jobs = new Job[cantidad]; 
        for (int i = 0; i < jobs.length; i++) {
        	System.out.println("Ingrese el nombre de la tarea ["+(i+1)+"]");
        	String name = sc.next();
        	System.out.println("Ingrese el tiempo de la tarea ["+(i+1)+"]");
        	int tiempo = sc.nextInt();
        	System.out.println("Ingrese el valor de la tarea ["+(i+1)+"]");
        	int valor = sc.nextInt();
			jobs[i]=new Job(name,tiempo,valor);
		}
        
  
        printJobScheduling(jobs, cantidad); 
    } 
    
} 