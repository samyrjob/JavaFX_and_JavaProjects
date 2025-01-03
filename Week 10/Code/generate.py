import random;

# Regenerating the full dataset including the original 200 items and the additional 50 items

# Categories and proportions for the initial 200 items
categories = {
    "FoodWaste": ["banana peels", "vegetable scraps", "egg shells", "leftover pasta", "bread crusts"],
    "Plastic": ["water bottles", "grocery bags", "plastic cups", "straws", "packaging film"],
    "Paper": ["newspapers", "magazines", "notebooks", "tissue boxes", "envelopes"],
    "Glass": ["wine bottles", "broken glasses", "jar lids", "light bulbs", "mirrors"],
    "Other": ["aluminium foil", "clothing", "ceramic plates", "bubble wrap", "chip bags"]
}

# Generating 200 items
waste_data = []
for category, items in categories.items():
    proportion = 0.2  # 20% for each category
    count = int(200 * proportion)
    waste_data.extend([f"{random.choice(items)}, {category}" for _ in range(count)])

# Adding the 50 additional items with trick items for the 'Other' bin
additional_items = [
    "coffee cups, Other", "plastic straws, Other", "ceramic plates, Other", "polystyrene foam, Other", 
    "chip bags, Other", "mirrors, Other", "broken toys, Other", "glossy magazines, Other",
    "wax paper, Other", "bubble wrap, Other", "pizza boxes, FoodWaste", "rotten fruits, FoodWaste",
    "cracked egg shells, FoodWaste", "cooking oil residue, FoodWaste", "spoiled bread, FoodWaste",
    "milk cartons, Paper", "envelopes with plastic windows, Paper", "cardboard boxes, Paper", 
    "torn notebooks, Paper", "unused receipts, Paper", "detergent bottles, Plastic", 
    "toothpaste tubes, Plastic", "empty shampoo bottles, Plastic", "damaged buckets, Plastic", 
    "food wrappers, Plastic", "decorative glass, Other", "photo frames, Other", 
    "disposable plates, Other", "plastic utensils, Other", "glittered greeting cards, Other", 
    "dried leaves, FoodWaste", "banana peels, FoodWaste", "vegetable peels, FoodWaste", 
    "tea bags, FoodWaste", "leftover rice, FoodWaste", "newspapers, Paper", 
    "gift wraps, Paper", "used napkins, Paper", "junk mail, Paper", "poster board, Paper", 
    "plastic containers, Plastic", "bubble tea straws, Plastic", "disposable razors, Plastic", 
    "strawberry boxes, Plastic", "toy packaging, Plastic", "light bulbs, Other", 
    "paint cans, Other", "broken chargers, Other", "used diapers, Other", "toilet seat covers, Other"
]

# Combine the original and additional items
waste_data.extend(additional_items)

# Save to a text file
file_path = "expanded_waste_data.txt"
with open(file_path, 'w') as file:
    file.write('\n'.join(waste_data))

file_path
