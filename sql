CREATE DATABASE IF NOT EXISTS `travelcase` ;
USE `travelcase`;

-- Dumping structure for table travelcase.users
CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `role` varchar(50) NOT NULL,
  `country` varchar(100) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
-- Dumping data for table travelcase.users: ~2 rows (approximately)
INSERT INTO `users` (`username`, `password`, `full_name`, `role`, `country`, `enabled`) VALUES
	('mukesh', '$2a$10$N0eqNiuikWCy9ETQ1rdau.XEELcyEO7kukkfoiNISk/9F7gw6eB0W', 'Mukesh Sharma', 'ROLE_ADMIN', 'India', 1),
	('tarun', '$2a$10$QifQnP.XqXDW0Lc4hSqEg.GhTqZHoN2Y52/hoWr4I5ePxK7D2Pi8q', 'Tarun Singh', 'ROLE_USER', 'India', 1);


drop table suppliers;
drop table supplier_contents;
drop table supplier_contacts;
drop table supplier_facilities;


-- Dumping structure for table travelcase.suppliers
	CREATE TABLE IF NOT EXISTS `suppliers` (
      `supplier_id` int(5) NOT NULL AUTO_INCREMENT,
      `code` varchar(50) NOT NULL,
      `name` varchar(200) NOT NULL,
      `postal_code` varchar(50),
      `street` varchar(100),
      `city` varchar(100) NOT NULL,
      `country` varchar(100) NOT NULL,
      `currency` varchar(10) NOT NULL,
      `star_rating` varchar(20) NOT NULL,
      `geo_codeX` varchar(50),
      `geo_codeY` varchar(50),
      `amendment_schema` varchar(100) NOT NULL,
      `cancellation_chema` varchar(100) NOT NULL,
      `deposit_schema` varchar(100) NOT NULL,
      PRIMARY KEY (`supplier_id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
    -- Dumping data for table travelcase.suppliers: ~3 rows (approximately)
    INSERT INTO `suppliers` (`supplier_id`, `code`, `name`,`postal_code`,`street`,`city`,`country`,`currency`,`star_rating`,`geo_codeX`,`geo_codeY`,`amendment_schema`,`cancellation_chema`,`deposit_schema`) VALUES
    	(1, 'SUP01', 'Test Supplier Name','10101','Test Street','test city','test country','USD','5 star','1.23456','3.21345','test_AMD','test_CNX','test_DEP'),
    	(2, 'HTL01', 'Hilton Supplier','E16 2RD','Brans Street','London','United Kindom','GBP','5 star','9.23456','7.21345','HT_AMD','HT_CNX','HT_DEP'),
    	(3, 'SHA01', 'Shangilla Supplier','D55 R23','Gibert Ave','Paris','France','EUR','5 star','9.23456','4.21345','AMD','CNX','DEP');

-- Dumping structure for table travelcase.supplier_contents
	CREATE TABLE IF NOT EXISTS `supplier_contents` (
	 `content_id` int(5) NOT NULL AUTO_INCREMENT,
	 `supplier_id` int(5) NOT NULL,
     `product_name` varchar(500) NOT NULL,
     `product_description` varchar(1000) NOT NULL,
     `product_image` varchar(100),
     `other_image` varchar(100),
    PRIMARY KEY (`content_id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
-- Dumping data for table travelcase.supplier_contents: ~2 rows (approximately)
INSERT INTO `supplier_contents` (`content_id`, `supplier_id`, `product_name`, `product_description`, `product_image`, `other_image`) VALUES
	('1', '1', 'Test Supplier Name', 'Test supplier description', 'main Image', 'other image'),
	('2', '1', 'Hilton Hotel', 'Hilton hotel chaim supplier', 'main image details', 'other image details'),
	('3', '2', 'Hilton Hotel', 'Hilton hotel chaim supplier', 'main image details', 'other image details');

    -- Dumping structure for table travelcase.supplier_contacts
    	CREATE TABLE IF NOT EXISTS `supplier_contacts` (
    	 `contact_id` int(5) NOT NULL AUTO_INCREMENT,
    	 `supplier_id` int(5) NOT NULL,
         `contact_category` varchar(50) NOT NULL,
         `value` varchar(200) NOT NULL,
         `main_contact` char(1) Default '0'',
        PRIMARY KEY (`contact_id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

   -- Dumping structure for table travelcase.supplier_facilities
    	CREATE TABLE IF NOT EXISTS `supplier_facilities` (
    	 `facility_id` int(5) NOT NULL AUTO_INCREMENT,
    	 `supplier_id` int(5) NOT NULL,
         `facility_type` varchar(50) NOT NULL,
         `description` varchar(500),
        PRIMARY KEY (`facility_id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;



        	ALTER TABLE `sql12211746`.`supplier_contacts`
            ADD INDEX `supplier_fk_idx` (`supplier_id` ASC);
            ALTER TABLE `sql12211746`.`supplier_contacts`
            ADD CONSTRAINT `supplier_cont_fk`
            FOREIGN KEY (`supplier_id`)
            REFERENCES `sql12211746`.`suppliers` (`supplier_id`)
            ON DELETE CASCADE
            ON UPDATE NO ACTION;

            ALTER TABLE `sql12211746`.`supplier_contents`
            ADD INDEX `supplier_fk_idx` (`supplier_id` ASC);
            ALTER TABLE `sql12211746`.`supplier_contents`
            ADD CONSTRAINT `supplier_cnten_fk`
            FOREIGN KEY (`supplier_id`)
            REFERENCES `sql12211746`.`suppliers` (`supplier_id`)
            ON DELETE CASCADE
            ON UPDATE NO ACTION;

            ALTER TABLE `sql12211746`.`supplier_facilities`
            ADD INDEX `supplier_fk_idx` (`supplier_id` ASC);
            ALTER TABLE `sql12211746`.`supplier_facilities`
            ADD CONSTRAINT `supplier_facil_fk`
            FOREIGN KEY (`supplier_id`)
            REFERENCES `sql12211746`.`suppliers` (`supplier_id`)
            ON DELETE CASCADE
            ON UPDATE NO ACTION;


-- Dumping structure for table travelcase.customer
	CREATE TABLE IF NOT EXISTS `customer` (
      `customer_id` int(5) NOT NULL AUTO_INCREMENT,
      `reference` varchar(50) NOT NULL,
      `name` varchar(200) NOT NULL,
      `postal_code` varchar(50),
      `street` varchar(100),
      `city` varchar(100) NOT NULL,
      `country` varchar(100) NOT NULL,
      `website` varchar(200) NOT NULL,
      `commision_group` varchar(20) NOT NULL,
      `status` varchar(50),
      PRIMARY KEY (`customer_id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
    -- Dumping data for table travelcase.customer: ~3 rows (approximately)
    INSERT INTO `customer` (`customer_id`, `reference`, `name`,`postal_code`,`street`,`city`,`country`,`website`,`commision_group`,`status`) VALUES
    	(1, 'EXP001', 'Test Customer Name','10101','Test Street','test city','test country','www.abc.com','10%','ACTIVE'),
    	(2, 'CUS001', 'Travel Customer','E16 4RD','Test Street','test city','test country','www.abc.com','15%','DISABLE');


-- Dumping structure for table travelcase.customer_credentials
	CREATE TABLE IF NOT EXISTS `customer_credentials` (
	 `credential_id` int(5) NOT NULL AUTO_INCREMENT,
	 `customer_id` int(5) NOT NULL,
     `user_name` varchar(100) NOT NULL,
     `password` varchar(200) NOT NULL,
     `status` varchar(100),
     `question` varchar(300),
     `answer` varchar(500),
    PRIMARY KEY (`credential_id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
-- Dumping data for table travelcase.customer_credentials: ~2 rows (approximately)
INSERT INTO `customer_credentials` (`credential_id`, `customer_id`, `user_name`, `password`, `status`, `question`, `answer`) VALUES
	('1', '1', 'test', 'password', 'active', 'First phone no', '123456789'),
	('2', '2', 'travelcustomer', 'travel', 'active', 'Name of the country', 'Sri Lanka');

    -- Dumping structure for table travelcase.customer_contacts
    	CREATE TABLE IF NOT EXISTS `customer_contacts` (
    	 `contact_id` int(5) NOT NULL AUTO_INCREMENT,
    	 `customer_id` int(5) NOT NULL,
         `contact_category` varchar(50) NOT NULL,
         `value` varchar(200) NOT NULL,
         `main_contact` char(1) Default '0',
        PRIMARY KEY (`contact_id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


            ALTER TABLE `sql12211746`.`customer_credentials`
            ADD INDEX `customer_fk_idx` (`customer_id` ASC);
            ALTER TABLE `sql12211746`.`customer_credentials`
            ADD CONSTRAINT `customer_credi_fk`
            FOREIGN KEY (`customer_id`)
            REFERENCES `sql12211746`.`customer` (`customer_id`)
            ON DELETE CASCADE
            ON UPDATE NO ACTION;

            ALTER TABLE `sql12211746`.`customer_contacts`
            ADD INDEX `customer_fk_idx` (`customer_id` ASC);
            ALTER TABLE `sql12211746`.`customer_contacts`
            ADD CONSTRAINT `customer_cont_fk`
            FOREIGN KEY (`customer_id`)
            REFERENCES `sql12211746`.`customer` (`customer_id`)
            ON DELETE CASCADE
            ON UPDATE NO ACTION;



-- Dumping structure for table travelcase.currency
	CREATE TABLE IF NOT EXISTS `currency` (
          `id` int(5) NOT NULL AUTO_INCREMENT,
          `code` varchar(50) NOT NULL,
          `name` varchar(200) NOT NULL,
          `symbol` char(1),
          PRIMARY KEY (`id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
        -- Dumping data for table travelcase.suppliers: ~3 rows (approximately)
        INSERT INTO `currency` (`id`, `code`, `name`,`symbol`) VALUES
        	(1, 'USD', 'US Dollar','$'),
        	(2, 'GBP', 'British Pound','#'),
        	(3, 'AED', 'United Arab Emirates Dirham','$');


-- Dumping structure for table travelcase.room_type
	CREATE TABLE IF NOT EXISTS `room_type` (
          `id` int(5) NOT NULL AUTO_INCREMENT,
          `code` varchar(50) NOT NULL,
          `name` varchar(200) NOT NULL,
          `description` varchar(500),
          PRIMARY KEY (`id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
        -- Dumping data for table travelcase.room_type: ~3 rows (approximately)
        INSERT INTO `room_type` (`id`, `code`, `name`,`description`) VALUES
        	(1, 'STD', 'Standard Room','Standard View room has consist all basic facilities'),
        	(2, 'SVR', 'Sea View Room','Sea view room consist all basic facility and nice view'),
        	(3, 'GVR', 'Garden View Room','Garden view room consist all basic facility and nice view');



-- Dumping structure for table travelcase.meal_plan
	CREATE TABLE IF NOT EXISTS `meal_plan` (
          `id` int(5) NOT NULL AUTO_INCREMENT,
          `code` varchar(50) NOT NULL,
          `name` varchar(200) NOT NULL,
          `description` varchar(500),
          PRIMARY KEY (`id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
        -- Dumping data for table travelcase.meal_plan: ~3 rows (approximately)
        INSERT INTO `room_type` (`id`, `code`, `name`,`description`) VALUES
        	(1, 'HB', 'Half Board','Including breakfast and lunch/dinner'),
        	(2, 'F', 'Full Board','Including breakfast, lunch and dinner');



-- Dumping structure for table travelcase.occupancy_code
	CREATE TABLE IF NOT EXISTS `occupancy_code` (
          `id` int(5) NOT NULL AUTO_INCREMENT,
          `code` varchar(50) NOT NULL,
          `name` varchar(200) NOT NULL,
          `description` varchar(500),
          PRIMARY KEY (`id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
        -- Dumping data for table travelcase.occupancy_code: ~3 rows (approximately)
        INSERT INTO `occupancy_code` (`id`, `code`, `name`,`description`) VALUES
        	(1, 'SNG', 'Single','Accommodating single occupancy type'),
        	(2, 'DBL', 'Double','Accommodating double occupancy type'),
        	(3, 'TRP', 'Triple','Accommodating triple occupancy type');



-- Dumping structure for table travelcase.occupancies
	CREATE TABLE IF NOT EXISTS `occupancies` (
          `id` int(5) NOT NULL AUTO_INCREMENT,
          `occupancy_code` varchar(20) NOT NULL,
          `occupancy_name` varchar(100) NOT NULL,
          `adult` int(10) not null default 0,
          `child` int(10) not null default 0,
          `infant` int(10) not null default 0,
          `prefered` char(1) not null default '0',
          PRIMARY KEY (`id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
        -- Dumping data for table travelcase.occupancies: ~3 rows (approximately)
        INSERT INTO `occupancies` (`id`, `occupancy_code`, `occupancy_name`,`adult`,`child`,`infant`,`prefered`) VALUES
        	(1, 'SNG', 'Single',1,0,0,'1'),
        	(2, 'DBL', 'Double',2,0,0,'1'),
        	(3, 'TRP', 'Triple',3,0,0,'1');


-- Dumping structure for table travelcase.star_rating
	CREATE TABLE IF NOT EXISTS `star_rating` (
          `id` int(5) NOT NULL AUTO_INCREMENT,
          `code` varchar(20) NOT NULL,
          `name` varchar(100) NOT NULL,
          `description` varchar(500),
          PRIMARY KEY (`id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
        -- Dumping data for table travelcase.star_rating: ~3 rows (approximately)
        INSERT INTO `star_rating` (`id`, `code`, `name`,`description`) VALUES
        	(1, '3Star', 'Three Star Rating','Three star hotel rating'),
        	(2, '4Star', 'Four Star Rating','Four star hotel rating'),
        	(3, '5Star', 'Five Star Rating','Five star hotel rating');

-- Dumping structure for table travelcase.contract_status
	CREATE TABLE IF NOT EXISTS `contract_status` (
          `id` int(5) NOT NULL AUTO_INCREMENT,
          `code` varchar(20) NOT NULL,
          `name` varchar(100) NOT NULL,
          `valid` boolean not null default false,
          `valid_sale` boolean not null default false,
          `description` varchar(500),
          PRIMARY KEY (`id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
        -- Dumping data for table travelcase.contract_status: ~3 rows (approximately)
        INSERT INTO `contract_status` (`id`, `code`, `name`,`valid`,`valid_sale`,`description`) VALUES
        	(1, 'VC', 'Vaild Contract',true,false,'Contract valid for loading'),
        	(2, 'VS', 'Vaild For Sales',true,true,'Contract valid for sales'),
        	(3, 'IC', 'In-Vaild Contract',false,false,'Contract not valid'),
        	(4, 'LC', 'Contract Loading',false,false,'Contract is in loading stage');





-- Dumping structure for table travelcase.accom_contract
	CREATE TABLE IF NOT EXISTS `accom_contract` (
      `contract_id` int(5) NOT NULL AUTO_INCREMENT,
      `reference` varchar(50) NOT NULL,
      `vaild_from` Date NOT NULL,
      `vaild_to` Date NOT NULL,
      `sales_from` Date NOT NULL,
      `sales_to` Date NOT NULL,
      `rate_type` varchar(10),
      `supplier_id` int(5) NOT NULL,
      `supplier_name` varchar(200) NOT NULL,
      `status` varchar(20) NOT NULL,
      `stage` varchar(20) NOT NULL,
      `currency` varchar(50),
      PRIMARY KEY (`contract_id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
    -- Dumping data for table travelcase.customer: ~3 rows (approximately)
    INSERT INTO `accom_contract` (`contract_id`, `reference`, `vaild_from`,`vaild_to`,`sales_from`,`sales_to`,`rate_type`,`supplier_id`,`supplier_name`,`status`,`stage`,`currency`) VALUES
    	(1, 'ACC_HILTON_18_19', '2018-01-01','2019-12-31','2017-11-01','2019-12-31','NG','1','Hilton supplier','VS','VC','USD'),
    	(2, 'ACC_Shangrila_17_18', '2018-01-01','2018-12-31','2017-11-01','2018-12-31','NG','1','Shangri la supplier','VS','VC','USD');

