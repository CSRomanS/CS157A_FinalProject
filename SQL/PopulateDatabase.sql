USE `AEB`;

INSERT INTO Categories (`CategoryID`, `CategoryName`) 
VALUES 
	('1', 'Electronics'),
	('2', 'Pets'),
	('3', 'Health');

INSERT INTO Items (`ItemID`, `ItemName`, `MainDescription`, `CategoryDescription`, `Price`, `Stock`, `CoverPicture`, `CategoryID`) 
VALUES 
	('1', 'Blu-ray Disc Player', 'Enjoy Blu-ray Disc movies in Full HD.\n Upscale your DVDs to near HD quality.\n View smartphone content with screen mirroring.\n Easy set-up with included HDMI cord.\n', 'catDesc', '78.00', 100, 'https://m.media-amazon.com/images/I/71UHwvvxERL._AC_SL1500_.jpg', '1'),
	('2', 'Roku Streaming Stick 4K', 'Hides behind your TV: The stick design plugs right into your TV with a simple setup ', 'Breathtaking picture: Stream in 4K, Dolby Vision, and HDR10 plus with sharp resolution and vivid color', '47.54', 100, 'https://m.media-amazon.com/images/I/81Z7+LBxPKL._AC_SL1500_.jpg','1'),
	('3', 'Milk-Bone MaroSnacks Dog Treats', 'Tap into your dog’s canine heritage and treat them to a few of these savory, crunchy dog treats. ', 'Wheat Flour, Meat and Bone Meal, Sugar, Dried Poultry By-Products Digest, Cooked Bone Marrow Beef Fat (Preserved with Tocopherols), Salt, Corn Starch, Annatto Color, Red Iron Oxide (Color), Red 40, Sodium Metabisulfite (Used as a Preservative).', '11.48', 100, 'https://m.media-amazon.com/images/I/81YFIrbPq3S._AC_SL1500_.jpg', '2'),
	('4', 'Band-Aid Brand Flexible Fabric Adhesive Bandages', '100-count Band-Aid Brand Flexible Fabric Adhesive Bandages for first aid and wound protection of minor wounds, cuts, scrapes and burns', 'Made with Memory Weave fabric for comfort and flexibility, these first-aid wound care bandages stretch and flex as you move.', '8.96', 100, 'https://m.media-amazon.com/images/I/91nHT-VLyPL._AC_SL1500_.jpg', '3');

INSERT INTO Items (`ItemID`, `ItemName`, `MainDescription`, `CategoryDescription`, `Price`, `SalePrice`, `SaleEnds`, `ScheduledPrice`, `Stock`, `CoverPicture`, `CategoryID`) 
VALUES 
	('5', 'Tide Stain Remover', "Powerful solution breaks stains down; microfiber pad lifts and absorbs them; Doesn't contain bleach.", 'Tide to Go is the portable, instant stain remover that helps eliminate many fresh food and drink stains on the spot.', '7.88', '5.00', '2023-08-01 00:00:00', '7.00', 100, 'https://m.media-amazon.com/images/I/815jQzfsMmL._AC_SL1500_.jpg', '3');
    
INSERT INTO Items (`ItemID`, `ItemName`, `MainDescription`, `CategoryDescription`, `Price`, `Stock`, `CoverPicture`, `CategoryID`) 
VALUES 
	('6', 'HiDREAM Cat Cone Collar', 'Soft waterproof material; large diameter to prevent licking and biting.', 'HiDREAM cat cone is the perfect solution for cats during recovery after surgery.', '17.99', 100, 'https://m.media-amazon.com/images/I/71OfpuhSkBS._AC_SX425_.jpg', '2'),
	('7', 'PureBites Plus Squeezables Cat Treat', 'Every Squeezable pouch contains 113mg of omega-3 and 1065mg of omega-6 to support skin & coat health.', 'Made with only 5 ingredients: 100% pure chicken, water, tapioca starch, sunflower oil, & tuna oil. Proudly sourced and made in Thailand with human grade ingredients.', '26.85', 100, 'https://m.media-amazon.com/images/I/718+hJJy1hL._AC_SX466_.jpg', '2'),
	('8', 'Premier Vanilla Protein Shake', 'Classic and oh-so-dreamy vanilla that tastes like vanilla wafers, Winner of American Masters of Taste Gold Medal.', '30g of protein to help curb your hunger, as a mid-day snack or for post-workout recovery; includes all essential amino acids.', '28.02', 100, 'https://m.media-amazon.com/images/I/815jQzfsMmL._AC_SL1500_.jpg', '2'),
	('9', 'Amazon Aware 100% Bamboo Toilet Paper', 'Climate Pledge Friendly; Includes 24 rolls with 350 3-ply sheets per roll; FSC Certified and USDA BioPreferred.', 'Made from 100% bamboo; Soft, strong absorbent; Fragrance-free; Safe for sensitive skin.', '38.80', 100, 'https://m.media-amazon.com/images/I/71FSMsCa5TL._AC_SX425_.jpg', '3'),
	('10', 'Bruder Moist Heat Eye Compress', 'This warm eye compress emits precision heat, moisture and hydration to provide rejuvenating and soothing relief for tired eyes; Feels like a spa treatment for your eyes.', 'Enjoy effective moist heat therapy, simply microwave the dry eye compress for 20 seconds and apply for 10 minutes for a quick heat therapy with this moist heating pad.', '18.95', 100, 'https://m.media-amazon.com/images/I/71gUQvt2ffL._AC_SX466_.jpg', '3'),
	('11', 'MEWTOGO Large Winter Warm Bird Nest House', 'The bird nest measures about 9.8 x 9.8 x 11in. It has a well-supported and stable design. Perfect for large birds to keep warm and wind out.', 'The birdhouse is made of carefully selected reliable plush material, which is soft and comfortable, weatherproof and warm.', '23.99', 100, 'https://m.media-amazon.com/images/I/71u5jtib3-L._AC_SY355_.jpg', '2'),
    ('12', 'Meta Quest 2 — Advanced All-In-One Virtual Reality Headset — 128 GB', 'Experience total immersion with 3D positional audio, hand tracking, and haptic feedback, working together to make virtual worlds feel real.', 'Meta Quest is for ages 13+. Certain apps, games, and experiences may be suitable for a more mature audience.', '299.00', 100, 'https://m.media-amazon.com/images/I/61tE7IcuLmL._AC_SL1500_.jpg', '1');
    
    
INSERT INTO Items (`ItemID`, `ItemName`, `MainDescription`, `CategoryDescription`, `Price`, `SalePrice`, `SaleEnds`, `ScheduledPrice`, `Stock`, `CoverPicture`, `CategoryID`) 
VALUES 
	('13', 'VESPRO Chew Toys for Small Animals Teeth Care', 'The chew toys are perfect for teeth grinding for rodents, providing a full range of protection, good for digestion and relieving intestinal inflammations and mild pain.', 'Made of 100% natural materials. Grass cakes and grass sticks are rich in nutrients, which can help improve digestion and increase appetite. Screw noodle snacks with high fiber are very suitable for your pets. The taste of rose, calendula, myosotis and timothy bring a variety of tastes to small pets.',
    '9.99', '8.46', '2023-08-13 11:59:59', '9.99', 100, 'https://m.media-amazon.com/images/I/81V9mzCMLLL._AC_SL1500_.jpg', '2'),
    ('14', 'Divoom Ditoo Retro Pixel Art Game Bluetooth Speaker with 16X16 LED App Controlled Front Screen', 'Easy to create pixel art design at your fingertip or you can access over 1000+ designers in our free pixel art community from our Divoom app. You can chat, comment, and make friends with other artists', 'You can use the Bluetooth capabilities to stream your Spotify music through and it actually sounds excellent!',
    '129.99', '84.91', '2023-08-13 11:59:59', '129.99', 100, 'https://m.media-amazon.com/images/I/71i3Xb+kNTL._AC_SL1500_.jpg', '1'),
    ('15', 'MUID Benson Lying Flat Duck Night Light', 'With cute Duck shape and warm light, kids will more easily fall asleep while playing. you can tap the top to adjust the brightness of night lights in the weak, medium, and strong third gear and finally turn off.', 'Made with baby-safe BPA-free silicone to ensure safety, and the soft Duck lamp shade makes it easy to carry around and resist breakage.',
    '17.99', '14.39', '2023-08-13 11:59:59', '17.99', 100, 'https://m.media-amazon.com/images/I/51m15ZnzEbL._AC_SL1500_.jpg', '1'),
    ('16', 'Febreze Air Freshener Spray', "Waterlily, ginger, and hinoki mix together to create the can't-miss cool ambiance of Ocean", "A scented spray with safety in mind, using 100% natural propellant",
    '14.99', '11.91', '2023-08-13 11:59:59', '14.99', 100, 'https://m.media-amazon.com/images/I/61SP3ind1zL._AC_SL1001_.jpg', '3');    

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
        
INSERT INTO Pictures(`PictureID`, `Link`, `ItemID`) 
VALUES 
		('14', 'https://m.media-amazon.com/images/I/81FQtJNXcjL._AC_SY355_.jpg', '6'),
		('15', 'https://m.media-amazon.com/images/I/71cIS220BES._AC_SY355_.jpg', '6'),
		('16', 'https://m.media-amazon.com/images/I/81sGP-HRsOS._AC_SY355_.jpg', '6'),
		('17', 'https://m.media-amazon.com/images/I/81xxeM241-L._AC_SX466_.jpg', '7'),
		('18', 'https://m.media-amazon.com/images/I/81EnrP3R6NL._AC_SY355_.jpg', '7'),
		('19', 'https://m.media-amazon.com/images/I/71HMzcoGwhL._AC_SX466_.jpg', '7'),
		('20', 'https://m.media-amazon.com/images/I/71pfKOm47CL._AC_SY355_.jpg', '8'),
		('21', 'hhttps://m.media-amazon.com/images/I/71br-g7EBlL._AC_SY355_.jpg', '8'),
		('22', 'https://m.media-amazon.com/images/I/81Kuw8RJMjL._AC_SY355_.jpgs', '8'),
		('23', 'https://m.media-amazon.com/images/I/61gNYrrSdAL._AC_SX425_.jpg', '9'),
		('24', 'https://m.media-amazon.com/images/I/61VhGWpvvBL._AC_SX425_.jpg', '9'),
        ('25', 'https://m.media-amazon.com/images/I/61UHl6erLbL._AC_SX425_.jpg', '9'),
        ('26', 'https://m.media-amazon.com/images/I/71yMl-EvDAL._AC_SX466_.jpg', '10'),
        ('27', 'https://m.media-amazon.com/images/I/71aGCjhschL._AC_SL1500_.jpg', '10'),
        ('28', 'https://m.media-amazon.com/images/I/71+urGWfDvL._AC_SL1100_.jpg', '10'),
        ('29', 'https://m.media-amazon.com/images/I/71myq+ovoKL._AC_SL1500_.jpg', '11'),
        ('30', 'https://m.media-amazon.com/images/I/71JxltsKddL._AC_SL1500_.jpg', '11'),
        ('31', 'https://m.media-amazon.com/images/I/71W79s8gX-L._AC_SL1500_.jpg', '11'),
        ('32', 'https://m.media-amazon.com/images/I/71Ff1TswKSL._AC_SL1500_.jpg', '12'),
        ('33', 'https://m.media-amazon.com/images/I/61QQghZIg6L._AC_SL1500_.jpg', '12'),
        ('34', 'https://m.media-amazon.com/images/I/71ifd2iunCL._AC_SL1500_.jpg', '12'),
        ('35', 'https://m.media-amazon.com/images/I/81PRCI-bINL._AC_SL1500_.jpg', '13'),
        ('36', 'https://m.media-amazon.com/images/I/81q5QjZ3tvL._AC_SL1500_.jpg', '13'),
        ('37', 'https://m.media-amazon.com/images/I/81VEuhrytZL._AC_SL1500_.jpg', '13'),
        ('38', 'https://m.media-amazon.com/images/I/71OI3C3SaQL._AC_SL1500_.jpg', '14'),
        ('39', 'https://m.media-amazon.com/images/I/6178sGpfCVL._AC_SL1500_.jpg', '14'),
        ('40', 'https://m.media-amazon.com/images/I/713Tf2t0koL._AC_SL1450_.jpg', '14'),
        ('41', 'https://m.media-amazon.com/images/I/61rX2tjY5NL._AC_SL1500_.jpg', '15'),
        ('42', 'https://m.media-amazon.com/images/I/61btzhIVoYL._AC_SL1500_.jpg', '15'),
        ('43', 'https://m.media-amazon.com/images/I/61mV3VHqf0L._AC_SL1500_.jpg', '15'),
        ('44', 'https://m.media-amazon.com/images/I/71M7wgsXBWL._AC_SL1500_.jpg', '16'),
        ('45', 'https://m.media-amazon.com/images/I/71HZqChkcZL._AC_SL1500_.jpg', '16'),
        ('46', 'https://m.media-amazon.com/images/I/61MVqYnMwaL._AC_SL1500_.jpg', '16');
        
INSERT INTO Users(UserID, FirstName, LastName, PhoneNum, Email, AddressLineOne, City, State, ZipCode)
VALUES 
		('1', 'fName', 'lName', '5124857777', 'test@email', 'Line 1 Address', 'tCity', 'CA', '94000');
        
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
