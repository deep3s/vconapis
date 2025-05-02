-- Businesses Table
CREATE TABLE Businesses (
    business_id INT PRIMARY KEY AUTO_INCREMENT,
    business_name VARCHAR(255) NOT NULL,
    owner_id INT, -- Foreign Key to Users table
    contact_email VARCHAR(255),
    contact_phone VARCHAR(20),
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    other_business_details TEXT
);

-- Users Table (for system users)
CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    role ENUM('owner', 'manager', 'staff', 'customer') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Alter Businesses Table to add the foreign key after Users table creation
ALTER TABLE Businesses
ADD FOREIGN KEY (owner_id) REFERENCES Users(user_id);

-- Locations Table
CREATE TABLE Locations (
    location_id INT PRIMARY KEY AUTO_INCREMENT,
    business_id INT NOT NULL,
    location_name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    zip_code VARCHAR(20),
    contact_phone VARCHAR(20),
    opening_hours TEXT,
    other_location_details TEXT,
    location_type ENUM('men', 'ladies', 'unisex', 'other') DEFAULT 'unisex',
    latitude DECIMAL(10, 8),
    longitude DECIMAL(11, 8),
    image_urls JSON,
    primary_image_url VARCHAR(255),
    FOREIGN KEY (business_id) REFERENCES Businesses(business_id)
);

-- Categories Table
CREATE TABLE Categories (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    business_id INT NOT NULL,
    category_name VARCHAR(100) UNIQUE NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (business_id) REFERENCES Businesses(business_id)
);

-- Services Table
CREATE TABLE Services (
    service_id INT PRIMARY KEY AUTO_INCREMENT,
    business_id INT NOT NULL,
    category_id INT NOT NULL,
    service_name VARCHAR(255) NOT NULL,
    description TEXT,
    duration_minutes INT,
    base_price DECIMAL(10, 2),
    is_active BOOLEAN DEFAULT TRUE,
    commission_percentage DECIMAL(5, 2) DEFAULT 0.00,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (business_id) REFERENCES Businesses(business_id),
    FOREIGN KEY (category_id) REFERENCES Categories(category_id)
);

-- Location_Services Table (Linking Services to Locations with Overrides)
CREATE TABLE Location_Services (
    location_service_id INT PRIMARY KEY AUTO_INCREMENT,
    location_id INT NOT NULL,
    service_id INT NOT NULL,
    is_available BOOLEAN DEFAULT TRUE,
    price_override DECIMAL(10, 2),
    commission_percentage_override DECIMAL(5, 2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (location_id) REFERENCES Locations(location_id),
    FOREIGN KEY (service_id) REFERENCES Services(service_id),
    UNIQUE KEY unique_location_service (location_id, service_id)
);

-- Products Table
CREATE TABLE Products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    business_id INT NOT NULL,
    product_name VARCHAR(255) NOT NULL,
    description TEXT,
    purchase_price DECIMAL(10, 2),
    selling_price DECIMAL(10, 2),
    stock_quantity INT DEFAULT 0,
    supplier VARCHAR(255),
    is_active BOOLEAN DEFAULT TRUE,
    commission_percentage DECIMAL(5, 2) DEFAULT 0.00,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (business_id) REFERENCES Businesses(business_id)
);

-- Staff Table
CREATE TABLE Staff (
    staff_id INT PRIMARY KEY AUTO_INCREMENT,
    business_id INT NOT NULL,
    location_id INT,
    user_id INT UNIQUE,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) UNIQUE,
    phone_number VARCHAR(20),
    hire_date DATE,
    job_title VARCHAR(100),
    specializations TEXT,
    is_active BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (business_id) REFERENCES Businesses(business_id),
    FOREIGN KEY (location_id) REFERENCES Locations(location_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Customers Table
CREATE TABLE Customers (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    business_id INT NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255),
    phone_number VARCHAR(20) UNIQUE,
    address VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    zip_code VARCHAR(20),
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    notes TEXT,
    FOREIGN KEY (business_id) REFERENCES Businesses(business_id)
);

-- Transactions Table
CREATE TABLE Transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    business_id INT NOT NULL,
    location_id INT NOT NULL,
    customer_id INT,
    staff_id INT,
    transaction_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(10, 2) NOT NULL,
    payment_method VARCHAR(50),
    notes TEXT,
    FOREIGN KEY (business_id) REFERENCES Businesses(business_id),
    FOREIGN KEY (location_id) REFERENCES Locations(location_id),
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
    FOREIGN KEY (staff_id) REFERENCES Staff(staff_id)
);

-- Appointments Table
CREATE TABLE Appointments (
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    business_id INT NOT NULL,
    location_id INT NOT NULL,
    customer_id INT NOT NULL,
    staff_id INT,
    service_id INT NOT NULL,
    appointment_datetime DATETIME NOT NULL,
    end_datetime DATETIME,
    notes TEXT,
    status VARCHAR(50) DEFAULT 'Scheduled',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    transaction_id INT, -- Link to the transaction if the appointment was completed and paid
    FOREIGN KEY (business_id) REFERENCES Businesses(business_id),
    FOREIGN KEY (location_id) REFERENCES Locations(location_id),
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
    FOREIGN KEY (staff_id) REFERENCES Staff(staff_id),
    FOREIGN KEY (service_id) REFERENCES Services(service_id),
    FOREIGN KEY (transaction_id) REFERENCES Transactions(transaction_id)
);

-- Transaction_Items Table
CREATE TABLE Transaction_Items (
    item_id INT PRIMARY KEY AUTO_INCREMENT,
    transaction_id INT NOT NULL,
    item_type ENUM('service', 'product') NOT NULL,
    item_id_ref INT NOT NULL, -- Foreign key to either Services or Products
    quantity INT DEFAULT 1,
    unit_price DECIMAL(10, 2) NOT NULL,
    discount DECIMAL(5, 2) DEFAULT 0.00,
    subtotal DECIMAL(10, 2) NOT NULL,
    commission_amount DECIMAL(10, 2) DEFAULT 0.00, -- For service and product commissions
    FOREIGN KEY (transaction_id) REFERENCES Transactions(transaction_id)
    -- Note: Application logic to ensure item_id_ref points to the correct table based on item_type
);

-- Sales_Targets Table
CREATE TABLE Sales_Targets (
    target_id INT PRIMARY KEY AUTO_INCREMENT,
    staff_id INT NOT NULL,
    business_id INT NOT NULL,
    target_period_start DATE NOT NULL,
    target_period_end DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (staff_id) REFERENCES Staff(staff_id),
    FOREIGN KEY (business_id) REFERENCES Businesses(business_id),
    UNIQUE KEY unique_staff_period (staff_id, target_period_start, target_period_end)
);

-- Sales_Target_Slabs Table
CREATE TABLE Sales_Target_Slabs (
    slab_id INT PRIMARY KEY AUTO_INCREMENT,
    target_id INT NOT NULL,
    slab_order INT NOT NULL,
    sales_amount_from DECIMAL(10, 2) NOT NULL,
    sales_amount_to DECIMAL(10, 2),
    commission_rate DECIMAL(5, 2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (target_id) REFERENCES Sales_Targets(target_id),
    UNIQUE KEY unique_target_order (target_id, slab_order),
    CONSTRAINT amount_check CHECK (sales_amount_from < sales_amount_to OR sales_amount_to IS NULL)
);

-- Staff_Sales_Summary Table (Optional for efficiency)
CREATE TABLE Staff_Sales_Summary (
    summary_id INT PRIMARY KEY AUTO_INCREMENT,
    staff_id INT NOT NULL,
    business_id INT NOT NULL,
    sales_period_start DATE NOT NULL,
    sales_period_end DATE NOT NULL,
    total_sales_amount DECIMAL(10, 2) DEFAULT 0.00,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    UNIQUE KEY unique_staff_period (staff_id, sales_period_start, sales_period_end),
    FOREIGN KEY (staff_id) REFERENCES Staff(staff_id),
    FOREIGN KEY (business_id) REFERENCES Businesses(business_id)
);

-- Sales_Target_Commissions Table (for tracking paid commissions)
CREATE TABLE Sales_Target_Commissions (
    commission_id INT PRIMARY KEY AUTO_INCREMENT,
    staff_id INT NOT NULL,
    business_id INT NOT NULL,
    target_id INT NOT NULL,
    target_slab_id INT,
    commission_period_start DATE NOT NULL,
    commission_period_end DATE NOT NULL,
    achieved_sales_amount DECIMAL(10, 2) NOT NULL,
    target_commission_rate DECIMAL(5, 2) NOT NULL,
    commission_amount DECIMAL(10, 2) NOT NULL,
    paid_status BOOLEAN DEFAULT FALSE,
    payment_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (staff_id) REFERENCES Staff(staff_id),
    FOREIGN KEY (business_id) REFERENCES Businesses(business_id),
    FOREIGN KEY (target_id) REFERENCES Sales_Targets(target_id),
    FOREIGN KEY (target_slab_id) REFERENCES Sales_Target_Slabs(slab_id)
);