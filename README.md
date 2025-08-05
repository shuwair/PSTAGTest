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

- Java 17 or higher
- Maven 3.x

---

## 🚀 Installation

### 1. Clone the Repository

```bash
git clone https://github.com/yourname/PSTAGTest.git
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
│
├── Main.java                    → Application entry point
│
├── util
│   └── CLIArgsReader.java       → Handles CLI input
│   └── UserOptions.java         → Stores user input
│
├── parser
│   └── CarDataParser.java       → Parses XML + CSV
│
├── model
│   └── Car.java                 → Car data structure
│
├── filter
│   ├── CarFilter.java           → Main filter processor
│   └── strategies/              → Brand, Price, Date filters
│
├── sort
│   ├── SortField.java           → Enum + factory
│   └── strategies/              → Sorting logic
│
└── output
    ├── CarOutputPrinter.java    → Interface
    ├── TableOutputPrinter.java  → Table output
    ├── JsonOutputPrinter.java   → JSON output
    ├── XmlOutputPrinter.java    → XML output
    └── OutputPrinterFactory.java→ Output strategy factory
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

MIT © 2025 Your Name
