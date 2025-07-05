# E-Commerce System – Fawry Internship Challenge

## Table of Contents
- [Introduction](#introduction)
- [Examples of System in Action](#examples-of-system-in-action)
- [Design and Thought Process](#design-process)
- [Testing (Planned)](#testing-planned)
- [Conclusion & Internship Note](#conclusion--internship-note)

---

## Introduction

Hello!  
This repository contains my implementation of the **E-Commerce System** challenge as described in the provided PDF.

The system is designed to simulate key e-commerce features such as managing products (some expirable or shippable), handling carts, customer balances, and integrating with services.

---

## Examples of System in Action

Below are sample cases demonstrating how the system handles various real-world scenarios:

### 1. Normal Case
- Customer has sufficient funds  
- No expired items  
- Cart contains both shippable and non-shippable products  
- Checkout proceeds successfully

 <img src="https://github.com/AbdallahGasem/Fawry-Challenge/blob/main/planning/NormalScenario.png" alt="NormalScenario" />

---

### 2. Insufficient Balance
- Customer tries to checkout with less balance than required

<img src="https://github.com/AbdallahGasem/Fawry-Challenge/blob/main/planning/UnsuffBalance.png" alt="UnsuffBalance" />

---

### 3. Empty Cart
- Customer attempts to checkout with an empty cart

<img src="https://github.com/AbdallahGasem/Fawry-Challenge/blob/main/planning/EmptyCart.png" alt="EmptyCart" />

---

### 4. Expired Item
- One or more items in the cart are expired
- System automatically detects and removes them from the cart

<img src="https://github.com/AbdallahGasem/Fawry-Challenge/blob/main/planning/Expired.png" alt="Expired" />

---

### 5. Out of Stock
- A product in the cart has zero quantity available

<img src="https://github.com/AbdallahGasem/Fawry-Challenge/blob/main/planning/outOfStock.png" alt="outOfStock" />

---

### 6. Shippable Product with Weight 0
- A product is flagged as shippable but has no weight
- ShippingService handles it gracefully

<img src="https://github.com/AbdallahGasem/Fawry-Challenge/blob/main/planning/wZero.png" alt="wZero" />

---

### 7. Nothing Shippable
- All items in the cart are non-shippable
- ShippingService is skipped

<img src="https://github.com/AbdallahGasem/Fawry-Challenge/blob/main/planning/Noship.png" alt="Noship" />

---

## Design Process

### Understanding the Requirements
Before coding, I reformulated the requirements in my own words to ensure I understood every functional detail.

---

### First Design Draft
- `Cart` handled the entire checkout process
- `Product` had all possible attributes (expiration, weight)
- This design was **simple but rigid**, forcing all products to carry unnecessary attributes and implement irrelevant methods

<img src="https://github.com/AbdallahGasem/Fawry-Challenge/blob/main/planning/DD1.jpg" alt="DD1" />

---

### Second Design Draft
I moved toward a **trait-based design** using interfaces — inspired by the "SimUDuck" pattern!  
- Introduced `Shippable` and `Expirable` interfaces
- Initially, each product would subclass `Product` and implement the traits it needs

However, this approach required a separate class for every product — overkill if there are 100+ products!

### Final Design with Categories
To simplify:
- Introduced **product categories**:
  - `Electronic`: shippable only
  - `Edible`: shippable and expirable
  - `Other`: neither
- Each category implements the interfaces it needs
- Avoided redundant class creation

To achieve **single responsibility and full decoupling**:
- Created a `CheckoutService` that coordinates:
  - `Customer`
  - `Cart`
  - `ShippingService`

<img src="https://github.com/AbdallahGasem/Fawry-Challenge/blob/main/planning/DD2.jpg" alt="DD2" />
---

## Testing (Planned)

- JUnit 5 setup is complete using Maven  
- Test cases are currently being written to cover:
  - Product creation
  - Cart logic
  - Balance validation
  - ShippingService behavior  
  - CheckoutService behavior  
- Test coverage will be committed soon

---

## Conclusion & Internship Note

This was a fun and rewarding challenge!  
I had a great time exploring clean design, object-oriented principles, and seeing the system take shape over the past 24 hours.

I’m genuinely excited about the opportunity to join your internship program, and I hope this submission reflects both my technical skills and my enthusiasm for building real-world solutions.

Thank you for your time and consideration!

— *Sincerly, Abdallah*
