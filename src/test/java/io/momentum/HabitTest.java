package io.momentum;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
class HabitTest {
 @Test void countsStreak(){Habit h=new Habit("Read",10);LocalDate d=LocalDate.of(2026,10,29);h.complete(d.minusDays(1));h.complete(d);assertEquals(2,h.streak(d));}
 @Test void duplicateCompletionDoesNotInflateStreak(){Habit h=new Habit("Read",10);LocalDate d=LocalDate.now();h.complete(d);h.complete(d);assertEquals(1,h.streak(d));}
 @Test void validatesMinutes(){assertThrows(IllegalArgumentException.class,()->new Habit("Read",0));}
}
