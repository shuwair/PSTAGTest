# PSTAGTest

PSTAGTest is a Java command-line application that parses, filters, sorts, and displays car data from XML and CSV files. It is designed using extensible patterns like Strategy and Factory, making it easy to scale and maintain.

---

## 📦 Features

- Interactive CLI input for file paths, filters, sorting, and output.
- XML parsing for car data.
- CSV enrichment for car brand details.
- Filtering based on:
  - Brand
  - Maximum Price
  - Release Date After
- Sorting by:
  - Release Date
  - Price
  - Custom Type + Currency
- Output formats:
  - Table (console)
  - JSON
  - XML

---

## 🛠️ Prerequisites

- Java 21 or higher
- Maven 3.x

---

## 🚀 Installation

### 1. Clone the Repository

```bash
git clone https://github.com/shuwair/PSTAGTest.git
cd PSTAGTest
```

### 2. Build the Project

```bash
mvn clean install
```

### 3. Run the Application

#### Option 1: Run via Command Line

```bash
java -jar target/pstagtest.jar
```

#### Option 2: Run via IDE

Use `org.pstag.Main` as the main class.

---

## ▶️ Usage Guide

The application will prompt you step-by-step:

```text
Please enter XML file path: sample-data/cars.xml
Please enter CSV brand file path: sample-data/brands.csv
Enter brand to filter (optional): Toyota
Enter max price (optional): 30000
Enter release date after (yyyy-MM-dd, optional): 2020-01-01
Select sort field (release_date / price / custom): price
If custom, enter type (SUV/Sedan/Truck): SUV
If custom, enter currency (USD/EUR/JPY): USD
Select output format (table/json/xml): json
```

---

## 🧾 Example Output

### Table Format

```
+--------+--------+--------+----------+--------------+
| Brand  | Model  | Type   | Price    | Release Date |
+--------+--------+--------+----------+--------------+
| Toyota | Camry  | Sedan  | 27000.0  | 2022-01-15   |
+--------+--------+--------+----------+--------------+
```

### JSON Format

```json
[
  {
    "brand": "Toyota",
    "model": "Camry",
    "type": "Sedan",
    "price": 27000.0,
    "releaseDate": "2022-01-15"
  }
]
```

### XML Format

```xml
<cars>
  <car>
    <brand>Toyota</brand>
    <model>Camry</model>
    <type>Sedan</type>
    <price>27000.0</price>
    <releaseDate>2022-01-15</releaseDate>
  </car>
</cars>
```

---

## 📁 Project Structure

```
org.pstag
├── Main.java                        → Application entry point
├── filter
│   ├── BrandFilter.java            → Filters cars by brand
│   ├── CarFilter.java              → Applies all filters to the car list
│   ├── CarFilterStrategy.java      → Interface for filter strategy
│   ├── FilterCriteria.java         → Encapsulates all filter inputs
│   ├── MaxPriceFilter.java         → Filters cars by max price
│   └── ReleaseAfterFilter.java     → Filters cars released after a specific date
├── model
│   ├── Car.java                    → Represents car data
│   └── CurrencyPrice.java          → Holds car price in multiple currencies
├── output
│   ├── CarOutputPrinter.java       → Interface for output formats
│   ├── JsonOutputPrinter.java      → Outputs car data in JSON format
│   ├── OutputPrinterFactory.java   → Returns appropriate output printer
│   ├── TableOutputPrinter.java     → Outputs car data in tabular format
│   └── XmlOutputPrinter.java       → Outputs car data in XML format
├── parser
│   └── CarDataParser.java          → Parses XML and CSV data sources
├── sort
│   ├── CarSortStrategy.java        → Interface for sorting strategy
│   ├── SortByPrice.java            → Sorts cars by price
│   ├── SortByReleaseDate.java      → Sorts cars by release date
│   ├── SortByTypeCurrency.java     → Sorts cars by type and currency
│   └── SortField.java              → Enum to select sorting strategy
├── util
│   ├── CLIArgsReader.java          → Reads CLI arguments and user inputs
│   └── UserOptions.java            → Holds parsed user options
```

---

## 🧱 Design Patterns Used

- **Strategy Pattern** – for filters, sorters, and output formats
- **Factory Pattern** – for output printer and sort strategy creation
- **Enum-based Strategy** – for selecting sort fields

---

## 🤖 Extensibility

This project is designed for easy extension. You can add:

- ✅ New filter criteria (e.g., model, type)
- ✅ New sort strategies (e.g., by model)
- ✅ New output formats (e.g., CSV, YAML)

---

## ✅ Error Handling

- Graceful CLI input validation
- Retry mechanism for file parsing
- Clear error messages for invalid formats or missing files
- Exception handling for parsing, nulls, and formatting issues

---

## 🤝 Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you'd like to improve.

---

## 📄 License

MIT © 2025 Shuwair Sardar
