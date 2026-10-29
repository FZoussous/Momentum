package io.momentum;
import java.time.LocalDate;
import java.util.*;
public final class Habit {
 private final String name; private final int minutes; private final Set<LocalDate> done = new HashSet<>();
 public Habit(String name, int minutes) {
  if (name == null || name.isBlank()) throw new IllegalArgumentException("Name is required.");
  if (minutes < 1 || minutes > 600) throw new IllegalArgumentException("Minutes must be 1–600.");
  this.name = name.strip(); this.minutes = minutes;
 }
 public String name(){return name;} public int minutes(){return minutes;}
 public void complete(LocalDate day){if(day==null) throw new IllegalArgumentException("Date required."); done.add(day);}
 public int streak(LocalDate day){int n=0; for(LocalDate d=day; done.contains(d); d=d.minusDays(1)) n++; return n;}
 public double rate7(LocalDate day){return done.stream().filter(d->!d.isAfter(day)&&!d.isBefore(day.minusDays(6))).count()/7.0;}
 public String recommendation(LocalDate day){
  double rate=rate7(day);
  if(rate>=.7) return "Keep the routine; increase only if it still feels easy.";
  if(rate>=.3) return "Protect the habit with a 5-minute version next time.";
  return "Restart with just 2 minutes today. Small steps count.";
 }
}
