import matplotlib.pyplot as plt
import numpy as np


array_of_timeResults = [];
# Open the file in read mode
with open("results_per_timeComplexity.txt", "r") as file:
    # Loop through each line in the file
    for line in file:
        # Remove any leading/trailing whitespace characters (like newlines)
        line = line.strip()
        array_of_timeResults.append(line);
        # Print or process the line
        



# Example execution times for each function (replace these with actual data from your experiment)
# Assume these are times in nanoseconds for three different array sizes: 10, 40, 100
on_time = [float(array_of_timeResults[0]), float(array_of_timeResults[3]), float(array_of_timeResults[6])]  # O(n)
on2_time = [float(array_of_timeResults[1]), float(array_of_timeResults[4]), float(array_of_timeResults[7])]  # O(n^2)
on3_time = [float(array_of_timeResults[2]), float(array_of_timeResults[5]), float(array_of_timeResults[8])]  # O(n^3)

# X-axis labels (representing the array sizes)
array_sizes = [10, 40, 100]

# Plotting
plt.figure(figsize=(8, 6))

# Plot each time complexity
plt.plot(array_sizes, on_time, label='O(n)', marker='o', color='blue')  # O(n) curve
plt.plot(array_sizes, on2_time, label='O(n²)', marker='o', color='green')  # O(n²) curve
plt.plot(array_sizes, on3_time, label='O(n³)', marker='o', color='red')  # O(n³) curve

# Adding titles and labels
plt.title('Execution time for different time complexity functions', fontsize=16)
plt.xlabel('number of elements in the array looped through (n)', fontsize=14)
plt.ylabel('Execution time (nanosecondes)', fontsize=14)

# Adding a legend
plt.legend()

# Display the plot
plt.tight_layout()
plt.show()
