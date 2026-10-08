# Clothify 👕🛒

<p align="center">
  <img src="ScreenShots/Home%20Page.png" alt="Clothify Home Screen" width="700" />
</p>

<p align="center">
  <strong>A Modern Point-of-Sale (POS) & Store Inventory Management Desktop System for Clothing Retailers built with JavaFX & JFoenix.</strong>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-11%2B-orange?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/JavaFX-17-blue?style=for-the-badge" alt="JavaFX" />
  <img src="https://img.shields.io/badge/UI-JFoenix%20Material%20Design-teal?style=for-the-badge" alt="JFoenix" />
  <img src="https://img.shields.io/badge/Database-SQLite%20%2F%20MySQL-lightgrey?style=for-the-badge&logo=sqlite&logoColor=white" alt="SQLite" />
  <img src="https://img.shields.io/badge/Build-Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven" />
</p>

---

## 📖 Overview

**Clothify** is an enterprise-grade desktop POS and inventory management application designed specifically for garment and fashion boutiques. It streamlines day-to-day retail operations, from fast item barcode scanning and receipt generation to supply tracking and employee management.

Built upon a robust **Layered Enterprise Architecture** (Controller, Service, DAO/Repository, Entity, DTO) and utilizing **JavaFX 17** paired with **JFoenix Material Design**, Clothify delivers a fluid, responsive, and intuitive desktop experience.

---

## ✨ Features

- **🛒 Point-of-Sale (POS) Checkout**:
  - Intuitive order processing and cart management.
  - Automatic discount calculations, item sub-totals, and grand totals.
  - Instant order confirmation and receipt generation.
- **📦 Inventory & Stock Control**:
  - Product catalog management with sizes, categories, and unit pricing.
  - Real-time stock levels with quantity-on-hand tracking.
- **🚚 Supplier & Supply Management**:
  - Comprehensive supplier profiles and vendor directory.
  - Supply purchase orders and restock shipment tracking.
- **👥 Role-Based Access Control**:
  - **Admin Dashboard**: System oversight, staff accounts management, inventory management, reports, and financial visibility.
  - **Staff Dashboard**: Cashier operations, order processing, and customer checkouts.
- **🔒 Security & Authentication**:
  - Secure credential management with password hashing.
  - Active session handling for Admin and Staff operators.
- **💾 Zero-Configuration Out-of-the-Box Database**:
  - Pre-configured with an embedded **SQLite** database (`Clothify.db`) that auto-initializes all tables and default administrator credentials on first launch.
  - Optional enterprise MySQL configuration supported.

---

## 🖼️ User Interface & Screenshots

| Admin Dashboard | Staff Dashboard |
|:---:|:---:|
| <img src="ScreenShots/Admin%20Dashboard%20Page.png" width="400" /> | <img src="ScreenShots/Staff%20Dashboard%20Page.png" width="400" /> |

| Order Management (POS) | Product Inventory Management |
|:---:|:---:|
| <img src="ScreenShots/Order%20Management%20Page.png" width="400" /> | <img src="ScreenShots/Product%20Management%20Staff.png" width="400" /> |

| Supplier Management | Supply Order Management |
|:---:|:---:|
| <img src="ScreenShots/Supplier%20Management%20Page.png" width="400" /> | <img src="ScreenShots/Supply%20Management%20Page.png" width="400" /> |

---

## 🏗️ Architecture

Clothify adheres to the **Layered Architectural Pattern** with complete decoupling:

```
src/main/java/
├── controller/              # JavaFX FXML Form Controllers
│   ├── admin/               # Admin dashboard and staff management controllers
│   ├── order/               # POS order processing controller
│   ├── product/             # Inventory and product form controller
│   ├── staff/               # Staff portal controllers
│   ├── supplier/            # Vendor management controllers
│   └── supply/              # Restocking controllers
├── db/                      # Database connection manager (SQLite auto-init)
├── dto/                     # Data Transfer Objects
├── entity/                  # Persistent entities
├── repository/              # DAO (Data Access Object) Layer
│   ├── custom/              # DAO interfaces
│   └── custom/impl/         # DAO SQL implementations
├── service/                 # Business logic service layer
│   ├── custom/              # Service interfaces
│   └── custom/impl/         # Service business rules
└── util/                    # Alert, Session, and BCrypt Encryption helpers
```

---

## 🛠️ Tech Stack & Dependencies

| Category | Technology |
|---|---|
| **Language & JDK** | Java 11+ |
| **GUI Framework** | JavaFX 17 (Controls, FXML) |
| **Material UI** | JFoenix (9.0.10) |
| **Database** | SQLite JDBC (`sqlite-jdbc: 3.46.0.0`) & MySQL Connector |
| **Object Mapping** | ModelMapper (3.2.1) |
| **Boilerplate Reduction**| Project Lombok |
| **Build & Dependency Tool** | Apache Maven |

---

## 🚀 Getting Started

### Prerequisites

- [JDK 11+](https://www.oracle.com/java/technologies/downloads/) (JDK 17 recommended)
- [Apache Maven](https://maven.apache.org/download.cgi) installed (`mvn -version`)

### Installation & Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/floskam300-eng/Clothify.git
   cd Clothify
   ```

2. **Build the project:**
   ```bash
   mvn clean compile
   ```

3. **Run the application:**
   ```bash
   mvn javafx:run
   ```

### Default Credentials

Upon first execution, the SQLite database is automatically generated with a default administrator account:
- **Username:** `admin`
- **Password:** `admin123`

---

## 👤 Author

- **Omar Shamy** - [GitHub Profile](https://github.com/floskam300-eng)
