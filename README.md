ATM Simulator System
📌 Overview
A Java-based ATM Simulator desktop application that replicates core ATM functionalities such as account login, balance inquiry, deposits, withdrawals, and mini statements — built using Java Swing for the GUI and MySQL as the backend database.
🛠️ Tech Stack

Language: Java
IDE: Eclipse / NetBeans
GUI: Java Swing + JCalendar (jcalendar-1.4)
Database: MySQL (mysql-connector-j-9.7.0)
Build Tool: Apache Ant (build.xml)

✨ Features

User registration and login with card number & PIN
Deposit and withdrawal operations
Balance enquiry
Mini statement / transaction history
PIN change functionality

⚙️ Prerequisites

Java JDK 8 or higher
MySQL Server
Eclipse IDE (or any Java IDE)
JCalendar 1.4 JAR
MySQL Connector/J 9.7.0 JAR

🚀 Setup & Installation

Clone the repository

bash   git clone https://github.com/rishitasingh49/ATM-Simulator-System.git

Import into Eclipse

Go to File > Import > Existing Projects into Workspace
Select the cloned folder


Add external JARs

Right-click project → Build Path > Configure Build Path
Add jcalendar-1.4.jar and mysql-connector-j-9.7.0.jar


Set up the MySQL database

Create a database (e.g., atm_simulator)
Import the provided SQL file (if included) or manually create the required tables
Update DB credentials in the source code (connection URL, username, password)


Run the project

Right-click on the main class → Run As > Java Application



📁 Project Structure
ATM-Simulator-System/
├── src/              # Java source files
├── build/            # Compiled class files
├── build.xml         # Ant build script
├── manifest.mf       # JAR manifest
└── README.md
🤝 Contributing
Pull requests are welcome! For major changes, please open an issue first to discuss what you'd like to change.
