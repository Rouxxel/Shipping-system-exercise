# 📦 Shipping Cost Calculator

## 📝 Project Description

This project is a homework i did in my second semester and my first true approach to OOP. It is a JavaScript-based application developed to calculate the most cost-effective shipping method for transporting products from **China to Germany** on a regular basis. It has been refactored because after so much time, i cannot stand it how it looks so i wanted to improve it a little

### 🚚 Objective

Given a set of products and available container types, the application determines the **optimal shipping configuration** (in terms of cost) based on **volume and weight constraints** of the containers.

### 📦 Products

Each product has predefined **dimensions** (in cm) and **weight**:

| Product      | Dimensions (cm)     | Weight  |
|--------------|----------------------|---------|
| Laptop       | 60 × 50 × 50         | 6.5 kg  |
| Mouse        | 30 × 30 × 20         | 0.2 kg  |
| Desktop      | 100 × 150 × 50       | 20 kg   |
| LCD Screen   | 120 × 140 × 80       | 2.6 kg  |

### 🚢 Shipping Containers

Two container options are available for shipping:

#### 1. Small Container
- Dimensions: 2.59 m (H) × 2.43 m (W) × 6.06 m (L)
- Volume: 38.21 m³
- Cost:
  - **€1000** if total shipment weight ≤ 500 kg
  - **€1200** if total shipment weight > 500 kg

#### 2. Big Container
- Dimensions: 2.59 m (H) × 2.43 m (W) × 12.01 m (L)
- Volume: 75.76 m³
- Cost: **€1800** flat rate (regardless of weight)
 
