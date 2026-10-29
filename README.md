# Momentum
A Java habit consistency coach designed to help users restart gently rather than abandon goals.

## Run
```bash
mvn clean test
mvn exec:java -Dexec.mainClass=io.momentum.Main
```
Commands: `add Chinese 10`, `done Chinese`, `list`, `quit`. Habit names are single words in this first CLI.

## Included
Streaks, a seven-day completion rate, adaptive rule-based recommendations, and unit tests.

## Honest status
This is a command-line MVP. Data is held in memory and is lost when the program exits. Recommendations are deterministic rules, **not a trained ML model or an LLM**. No network connection or API key is needed.

## Roadmap
SQLite persistence, JavaFX dashboard, calendar/history, user-consented behavior-pattern analysis, and optional AI coaching with privacy controls.
