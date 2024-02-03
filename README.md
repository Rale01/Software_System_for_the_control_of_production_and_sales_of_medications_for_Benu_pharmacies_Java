# Java Client-Server Software System with MySQL Integration for controlling production and sales in Benu pharmacies

## Overview

Welcome to the Java-based Client-Server System with MySQL Integration project. This application is designed to facilitate client-server communication with a MySQL database backend. The project is structured into three main components: ServerskiProgram (Server-side), KlijentskiProgram (Client-side), and Zajednicki (Shared classes).

## Project Organization

### ServerskiProgram (Server-side)
- Manages communication threads with clients.
- Implements controllers for server operations.
- Includes a generic database class for MySQL integration.
- Provides server forms for startup and displaying connected users.

### KlijentskiProgram (Client-side)
- Features forms for employee tasks.
- Utilizes a socket for communication with the server.

### Zajednicki (Shared classes)
- Contains shared classes used by both client and server projects.
- Includes domain classes, KlijentskiZahtev, ServerskiOdgovor classes, and the Operacije_radna_memorija interface.
- Defines the StatusOdgovora enum for standardized response statuses.

## Conceptual model
- Using the conceptual model, we describe the structure of the system. The conceptual model includes conceptual classes (domain objects) and associations between conceptual classes.
  ![image](https://github.com/Rale01/Software_System_for_the_control_of_production_and_sales_of_medications_for_Benu_pharmacies_Java/assets/117539174/6bb68c58-4cfa-4664-b887-15af8af0db19)
  
