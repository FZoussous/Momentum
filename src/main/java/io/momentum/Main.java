package io.momentum;
import java.time.LocalDate;
import java.util.*;
public class Main {
 public static void main(String[] args) {
  Map<String,Habit> habits=new LinkedHashMap<>();
  System.out.println("Momentum — consistency over perfection");
  System.out.println("Commands: add <single-word-name> <minutes> | done <name> | list | quit");
  try(Scanner in=new Scanner(System.in)){while(true){
   System.out.print("\n> "); if(!in.hasNextLine())break; String line=in.nextLine().trim();
   if(line.equalsIgnoreCase("quit"))break;
   if(line.equalsIgnoreCase("list")){
    if(habits.isEmpty())System.out.println("No habits yet. Try: add Chinese 10");
    for(Habit h:habits.values())System.out.printf("%s — %d min, streak %d day(s)%n  %s%n",h.name(),h.minutes(),h.streak(LocalDate.now()),h.recommendation(LocalDate.now()));
   } else if(line.startsWith("add ")){
    String[] p=line.split("\\s+"); if(p.length!=3){System.out.println("Usage: add Chinese 10");continue;}
    try{Habit h=new Habit(p[1],Integer.parseInt(p[2]));habits.put(h.name().toLowerCase(),h);System.out.println("Added "+h.name());}
    catch(Exception e){System.out.println("Could not add: "+e.getMessage());}
   } else if(line.startsWith("done ")){
    Habit h=habits.get(line.substring(5).trim().toLowerCase());
    if(h==null)System.out.println("Habit not found; use list or add it first.");else{h.complete(LocalDate.now());System.out.println("Logged today. Small steps count.");}
   } else System.out.println("Unknown command.");
  }}
 }
}
