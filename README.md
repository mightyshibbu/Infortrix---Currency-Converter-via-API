# Currency Converter

This Java class `CurrencyConverter` is a simple currency conversion tool that uses an external API to convert currencies.

## Features

- Converts currencies based on user input.
- Supports conversion between various currencies such as USD, CAD, EUR, HKD, and INR.
- Fetches conversion rates from an API to perform the conversion.

## How to Use

1. **Running the Currency Converter:**
    - Compile the Java code using a Java compiler (e.g., `javac CurrencyConverter.java`).
    - Run the compiled class using Java (e.g., `java CurrencyConverter`).

2. **Input Format:**
    - Upon running the program, it will prompt the user to select the currency they want to convert from and to, and enter the amount they want to convert.

3. **API Usage:**
    - The program accesses an external API (`https://api.api-ninjas.com/v1/convertcurrency`) to fetch the conversion rate.
    - It then displays the converted amount based on the user's input.

