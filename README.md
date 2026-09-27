# COSC 251 — Arrays Assignment

This project implements two classes:

- `OrderedArray`
- `UnorderedArray`

The goal is to build a deeper understanding of their implementations, their respective advantages and disadvantages, and — most importantly — how they differ in time complexity for common operations.

---

## Prerequisites

Before you begin, make sure you have both the **Java Development Kit** and **Maven** installed on your local machine.

### 1. Installing Amazon Corretto JDK 21

This project strictly requires **Amazon Corretto JDK 21** to compile and run. Install it using your operating system's package manager:

**Windows**

```bash
# Using Winget (Windows Package Manager)
winget install Amazon.Corretto.21

# Using Chocolatey
choco install corretto21jdk
```

**macOS**

```bash
# Using Homebrew
brew install --cask corretto@21
```

**Linux (Ubuntu/Debian)**

```bash
# Add the Corretto APT repository and install
wget -O - https://apt.corretto.aws/corretto.key | sudo gpg --dearmor -o /usr/share/keyrings/corretto-keyring.gpg
echo "deb [signed-by=/usr/share/keyrings/corretto-keyring.gpg] https://apt.corretto.aws stable main" | sudo tee /etc/apt/sources.list.d/corretto.list
sudo apt-get update
sudo apt-get install -y java-21-amazon-corretto-jdk
```

### 2. Installing Apache Maven

Apache Maven is required to manage dependencies, run tests, and build the project.

**Windows**

```powershell
# Using Chocolatey
choco install maven

# Using Scoop
scoop install main/maven
```

**macOS**

```bash
# Using Homebrew
brew install maven
```

**Linux (Ubuntu/Debian)**

```bash
sudo apt install maven -y
```

**Linux (Fedora/RHEL)**

```bash
sudo dnf install maven -y
```

> **Note:** After installing both tools, restart your terminal and verify the installation:
>
> ```bash
> java -version
> mvn -v
> ```

---

## Dependencies

This project is intentionally lightweight and includes only one external dependency:

- **JUnit 5** (for unit testing)

---

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/yourusername/your-repo-name.git
cd your-repo-name
```

### 2. Build the project

Use Maven to download the JUnit 5 dependency and compile the source code:

```bash
mvn clean install
```

### 3. Run the tests

To execute the JUnit 5 test suite and verify everything is working correctly:

```bash
mvn test
```
