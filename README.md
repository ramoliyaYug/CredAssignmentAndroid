# The Recursive Grid - Android Assignment

This project is an Android application built as part of a **CRED Assignment**.  
The app demonstrates grid interaction logic, state handling, and modern Android UI development using **Jetpack Compose** and **MVVM architecture**.

---

## Tech Stack

- **Language:** Kotlin
- **UI Toolkit:** Jetpack Compose (No XML)
- **Architecture:** MVVM (ViewModel)
- **State Management:** Compose State + ViewModel

---

## App Overview

The application displays a **3 × 3 interactive grid** where each box holds a numeric value.  
Users can tap boxes to trigger value changes along with special ripple rules affecting neighboring cells.

The app icon has been set to the **CRED logo** as this project was created specifically for the CRED assignment.

---

## Features

### 1. Interactive Grid
- 9 boxes arranged in a centered 3×3 grid.
- Every box starts with the number **0**.
- Clicking a box increments its value.

### 2. Styling Rules
- **Even Numbers:** Light Gray background.
- **Odd Numbers:** Navy Blue background with White text.
- **Locked Boxes:** Red background.
- Rounded corners and shadow styling for a modern UI feel.

### 3. Ripple Logic
When a box is clicked and its value updates:

- **Rule A - Divisible by 3**
  - Decrements the box immediately to the **right** by 1.
  - No action if the box is in the last column.

- **Rule B - Divisible by 5**
  - Increments the box immediately **below** by 2.
  - No action if the box is in the bottom row.

### 4. Locked State
- If any box reaches **15 or higher**:
  - It turns **Red**.
  - It becomes **Locked**.
  - Locked boxes cannot be clicked or modified by neighbors.

### 5. Reset Functionality
- A reset button restores all grid values back to **0** instantly.

---

## Architecture

The app follows **MVVM (Model–View–ViewModel)** principles:

- **View (Compose UI):** Displays grid and buttons.
- **ViewModel:** Handles all business logic and state updates.
- **State:** Managed using `mutableStateListOf` for automatic UI recomposition.