USE `AEB`;

INSERT INTO Categories (`CategoryID`, `CategoryName`) 
VALUES 
	('1', 'Electronics'),
	('2', 'Pets'),
	('3', 'Health');

INSERT INTO Items (`ItemID`, `ItemName`, `MainDescription`, `CategoryDescription`, `Price`, `CategoryID`) 
VALUES 
	('1', 'Blu-ray Disc Player', 'Enjoy Blu-ray Disc movies in Full HD.\n Upscale your DVDs to near HD quality.\n View smartphone content with screen mirroring.\n Easy set-up with included HDMI cord.\n', 'catDesc', '78.00', '1'),
	('2', 'Roku Streaming Stick 4K', 'Hides behind your TV: The stick design plugs right into your TV with a simple setup ', 'Breathtaking picture: Stream in 4K, Dolby Vision, and HDR10 plus with sharp resolution and vivid color', '47.54', '1'),
	('3', 'Milk-Bone MaroSnacks Dog Treats', 'Tap into your dog’s canine heritage and treat them to a few of these savory, crunchy dog treats. ', 'Wheat Flour, Meat and Bone Meal, Sugar, Dried Poultry By-Products Digest, Cooked Bone Marrow Beef Fat (Preserved with Tocopherols), Salt, Corn Starch, Annatto Color, Red Iron Oxide (Color), Red 40, Sodium Metabisulfite (Used as a Preservative).', '11.48', '2'),
	('4', 'Band-Aid Brand Flexible Fabric Adhesive Bandages', '100-count Band-Aid Brand Flexible Fabric Adhesive Bandages for first aid and wound protection of minor wounds, cuts, scrapes and burns', 'Made with Memory Weave fabric for comfort and flexibility, these first-aid wound care bandages stretch and flex as you move.', '8.96', '3');

INSERT INTO Items (`ItemID`, `ItemName`, `MainDescription`, `CategoryDescription`, `Price`, `SalePrice`, `SaleEnds`, `ScheduledPrice`, `CategoryID`) 
VALUES 
	('5', 'Tide Stain Remover', 'Powerful solution breaks stains down; microfiber pad lifts and absorbs them; Doesnt contain bleach.', 'Tide to Go is the portable, instant stain remover that helps eliminate many fresh food and drink stains on the spot.', '7.88', '5.00', '2023-08-01 00:00:00', '7.00', '3');
    
INSERT INTO Pictures(`PictureID`, `Link`, `ItemID`) 
VALUES 
		('1', 'https://m.media-amazon.com/images/I/710EW8nkchL._AC_SL1500_.jpg', '1'),
		('2', 'https://m.media-amazon.com/images/I/71Zan3ZeJhL._AC_SL1500_.jpg', '1'),
		('3', 'https://m.media-amazon.com/images/I/71UHwvvxERL._AC_SL1500_.jpg', '1'),
		('4', 'https://m.media-amazon.com/images/I/81Z7+LBxPKL._AC_SL1500_.jpg', '2'),
		('5', 'https://m.media-amazon.com/images/I/71fayExOx1L._AC_SL1500_.jpg', '2'),
		('6', 'https://m.media-amazon.com/images/I/91dtiigYjoL._AC_SL1500_.jpg', '2'),
		('7', 'https://m.media-amazon.com/images/I/81P6Z2vH2-L._AC_SL1500_.jpg', '3'),
		('8', 'https://m.media-amazon.com/images/I/81YFIrbPq3S._AC_SL1500_.jpg', '3'),
		('9', 'https://m.media-amazon.com/images/I/91nHT-VLyPL._AC_SL1500_.jpg', '4'),
		('10', 'https://m.media-amazon.com/images/I/71c3WFb7KoL._AC_SL1500_.jpg', '4'),
		('11', 'https://m.media-amazon.com/images/I/81Kni71Pt3L._AC_SL1500_.jpg', '4'),
        ('12', 'https://m.media-amazon.com/images/I/815jQzfsMmL._AC_SL1500_.jpg', '5'),
        ('13', 'https://m.media-amazon.com/images/I/71L6z4j6fXL._AC_SL1500_.jpg', '5');
        
INSERT INTO Users(UserID, FirstName, LastName, AddressLineOne, City, State, ZipCode)
VALUES 
		('1', 'fName', 'lName', 'Line 1 Address', 'tCity', 'CA', '94000');
        
INSERT INTO Logins(UserName, `PassWord`, UserID)
VALUES
		('userTest', 'passTest', '1');
        
INSERT INTO ShoppingCarts(UserID, ItemID, ItemCount)
VALUES
		(1, 2, 3),
        (1, 3, 2),
        (1, 5, 2);
        
INSERT INTO Taxes
VALUES
	('AK', '0.00'),
	('AL', '0.04'),
	('AR', '0.07'),
	('AZ', '0.06'),
	('CA', '0.07'),
	('CO', '0.03'),
	('CT', '0.06'),
	('DC', '0.06'),
	('DE', '0.00'),
	('FL', '0.06'),
	('GA', '0.04'),
	('HI', '0.04'),
	('IA', '0.06'),
	('ID', '0.06'),
	('IL', '0.06'),
	('IN', '0.07'),
	('KS', '0.07'),
	('KY', '0.06'),
	('LA', '0.04'),
	('MA', '0.06'),
	('MD', '0.06'),
	('ME', '0.06'),
	('MI', '0.06'),
	('MN', '0.07'),
	('MO', '0.04'),
	('MS', '0.07'),
	('MT', '0.00'),
	('NC', '0.05'),
	('ND', '0.05'),
	('NE', '0.06'),
	('NH', '0.00'),
	('NJ', '0.07'),
	('NM', '0.05'),
	('NV', '0.07'),
	('NY', '0.04'),
	('OH', '0.06'),
	('OK', '0.05'),
	('OR', '0.00'),
	('PA', '0.06'),
	('RI', '0.07'),
	('SC', '0.06'),
	('SD', '0.04'),
	('TN', '0.07'),
	('TX', '0.06'),
	('UT', '0.06'),
	('VA', '0.05'),
	('VT', '0.06'),
	('WA', '0.07'),
	('WI', '0.05'),
	('WV', '0.06'),
	('WY', '0.04');