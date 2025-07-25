# 💊 Offline Medication Reminder (Terminal-Based Java App)

## 🔥 Overview

This is a simple **terminal-based medication reminder application** written in Java. It allows users to:

- Save and load medication schedules from a CSV file (`medications.csv`)
- Automatically schedule reminders for each medication.
- Receive console notifications when it’s time to take a medication.

---

## 📌 Features

- Stores medication data locally in a **CSV file**
- Uses **multithreading** to schedule multiple reminders concurrently
- Supports daily **recurring reminders**

---

## 🛠️ How It Works

- User can input medication name, dosage and time for it to be taken. 
- Medications are saved to and loaded from a local file called `medications.csv`.
- Each reminder thread sleeps until the medication time, then prints a reminder message, and repeats every day.
- The program runs indefinitely until manually stopped.

---

## 🚀 Future Improvements

- Add a user interface (UI) with Spring Boot + React.
- Add input validation and error handling.
- Support editing and deleting medications.

---

## ⚙️ How to use 
```bash

javac Main.java
java Main 

```
