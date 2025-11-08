# End-to-End Digital Vaccination System for Bangladesh

## Overview

This project aims to automate and digitize the vaccination workflow for Bangladesh, addressing inefficiencies in manual record-keeping, vaccine wastage, stock management, and citizen engagement. Built with Spring Boot, the system provides dedicated portals for citizens, vaccination centers, and health administrators to ensure transparency, accountability, and accessibility across Bangladesh’s vaccination ecosystem.


## Tech Stack

- SpringBoot
- React
- Gsap
- Python Fast API
- Shadcn
- Perplexity AI

---

## Problem Addressed

- Manual data entry and mismatches
- Difficulty tracking vaccine stock and wastage
- Inefficient scheduling and long queues
- Limited analytics and supply chain visibility
- Low accessibility for citizens, especially in remote areas

---

## Key Features

### Citizen Portal
- View vaccination history and pending doses
- Automatic dose and schedule suggestions
- Vaccine appointment booking & cancellation
- Interactive center selection on a map (with real-time capacity)
- Push/email notifications and reminders
- Vaccination certificate download (QR-enabled)
- Upload vaccine cards for automatic OCR data entry
- Wishlist for unavailable vaccines at preferred centers

### Vaccination Center Dashboard
- Real-time stock and daily appointment tracking
- Per-hour appointments overview
- Demand forecasting based on data and wishlist
- Daily and anomalous wastage/damage reporting
- Request vaccines from admins; receive and validate vaccine lots
- Staff management and role assignment
- Secure, OTP-validated vaccine record entry

### Health Admin Panel
- Comprehensive analytics: demographic, geographic, and trend dashboards
- Control vaccine batch movement (including center-to-center)
- Smart supply and demand forecasting (ML-powered)
- Anomaly detection in center operations
- Mass notifications and campaign management

---

## System Architecture

- **Backend:** Spring Boot (Java), RESTful API
- **Frontend:** (React/Angular — update as per your UI)
- **Database:** MySQL/PostgreSQL (JPA/Hibernate ORM)
- **Integrations:** Maps API, SMS/Email, Push notifications, OCR/AI microservices
- **Security:** JWT, OTP (Spring Security), data encryption, audit logs

---

## Entity Design (Sample)

- **User:** National ID, name, profile, credentials, contact
- **Staff:** Center linkage, roles (nurse, doctor, admin)
- **VaccineInfo:** Dose schedule, constraints, age/gender reqs
- **Appointment:** Date, slot, center, status
- **VaccinationRecord:** Linked to user, vaccine, staff, center
- **VaccineStock:** By center, detailed by dose
- **Admin:** Credentials, activity logs

---

## Installation & Setup

1. Clone repository  
2. Configure `application.properties` with your database credentials:
