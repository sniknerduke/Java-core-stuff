# Java Core Mini-Course

This project includes a tiny set of runnable lessons to learn/practice core Java.

## What's inside
- `LessonRunner` entry point
- Lessons under `com.example.reviewjava.lessons`:
  - `lesson01_basics` — variables, types, strings, arrays, loops
  - `lesson02_controlflow` — if/else, switch, loops, methods
  - `lesson03_oop` — classes, encapsulation, inheritance, polymorphism
  - `lesson04_collections` — List, Set, Map, sorting
  - `lesson05_streams` — streams map/filter/reduce, Optional
  - `lesson06_generics` — type params, bounds, wildcards (PECS), generic methods
  - `lesson07_exceptions` — checked vs unchecked, try-with-resources, wrapping
  - `lesson08_datetime` — LocalDate/Time, Instant/ZonedDateTime, Period/Duration, format/parse
  - `lesson09_files_nio` — Path/Files: read/write text, list directory, delete
  - `lesson10_streams_advanced` — groupingBy, partitioningBy, flatMap, summarizing, joining
  - `lesson11_optionals` — map/flatMap/filter, orElse vs orElseGet vs orElseThrow

## Prerequisites
- Java 17+
- Maven 3.8+

## How to list lessons (PowerShell)
```powershell
cd "D:\Java Makeitout\java"
mvn -q compile exec:java "-Dexec.args=--list"
```

## How to run a lesson (PowerShell)
```powershell
mvn -q compile exec:java "-Dexec.args=lesson01_basics"
```
Replace `lesson01_basics` with any of:
- `lesson02_controlflow`
- `lesson03_oop`
- `lesson04_collections`
- `lesson05_streams`
 - `lesson06_generics`
 - `lesson07_exceptions`
 - `lesson08_datetime`
 - `lesson09_files_nio`
 - `lesson10_streams_advanced`
 - `lesson11_optionals`

## Notes
- The old `Main` class still exists and prints "Hello world!"; you can ignore it.
- You can open and read each lesson's source to follow along.

Enjoy learning!