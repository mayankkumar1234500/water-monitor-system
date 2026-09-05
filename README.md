# 💧 Water Monitor — Smart Water Usage & Billing Administration Platform

[![React](https://img.shields.io/badge/Frontend-React.js-61DAFB?logo=react&logoColor=black)](https://reactjs.org/)
[![Java](https://img.shields.io/badge/Backend-Java%20%2F%20Spring%20Boot-ED8B00?logo=openjdk&logoColor=white)](https://spring.io/)
[![Payment](https://img.shields.io/badge/Gateway-Razorpay-02042B?logo=razorpay&logoColor=3395FF)](https://razorpay.com/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

An enterprise-grade, full-stack water usage tracking and automated utility billing platform built to monitor apartment community water networks, eliminate residential water wastage, and ensure fair tier-based cost allocation.

---

## 📌 Project Overview

**Water Monitor** provides digital utility infrastructure for modern housing societies by offering role-based operational dashboards for three distinct user personas:
1. **Super Admin (Root System Control):** Global administration across multiple housing societies, Community Admin onboarding approvals, and system-wide leak alerts.
2. **Community Admin (Society Level - Community A22):** Flat onboarding, sub-meter reading entries, tiered tariff setup, bulk water tanker procurement logging, and resident issue resolution.
3. **Resident Portal (Household - FLAT B402):** Real-time consumption tracking, automated billing statements, online fee settlement via Razorpay, downloadable PDF invoices, and interactive conservation tips.

---

## ✨ Key Features

- **Multi-Role Dashboards:** Distinct views tailored for Super Admins, Community Admins, and Household Residents.
- **Configurable Tiered Billing Engine:** Multi-slab rate calculations based on minimum usage thresholds and overuse penalties.
- **Bulk Water Purchase Apportionment:** Logs external tanker deliveries and apportions procurement costs across community flats.
- **Integrated Razorpay Payments:** Simulated real-time online checkout modal for settlement of monthly water bills.
- **Automated PDF Invoices & Reports:** Client-side generation of itemized receipts and administrative audit ledgers.
- **AI Smart Assistant (Buddy AI):** Interactive floating assistant with quick-action chips for automated query handling and billing support.
- **Multi-Language Support (i18n):** Global dictionary switcher (English, Hindi, Tamil, Telugu, Kannada) integrated with Google Translate widget.

---

## 🛠️ Technology Stack

| Layer | Technology |
| :--- | :--- |
| **Frontend** | React.js, Context API, CSS3 (Claymorphism UI), Recharts |
| **Backend** | Java, Spring Boot, RESTful APIs |
| **Database** | PostgreSQL / Relational Schema |
| **Payment Gateway** | Razorpay Integration |
| **Reporting** | Client-side PDF Exporter, CSV Logs |
| **Version Control** | Git, GitHub |

---

## 🚀 Getting Started

### Prerequisites
- Node.js (v16+ recommended)
- Java Development Kit (JDK 17 or 21)
- Git

### 1. Clone the Repository
```bash
git clone [https://github.com/mayankkumar1234500/water-monitoring-project.git](https://github.com/mayankkumar1234500/water-monitoring-project.git)
cd water-monitoring-project

Frontend Application Setup:
cd frontend
npm install
npm start

Backend Service Initialization:
cd ../backend
./mvnw clean compile
./mvnw spring-boot:run

Author & Maintainer
Mayank Dwivedi — Java Intern

GitHub: @mayankkumar1234500
