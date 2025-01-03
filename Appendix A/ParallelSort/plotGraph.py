import matplotlib.pyplot as plt
import numpy as np

# Example data
array_sizes = [40, 75, 100, 250, 500, 1000, 2000]  # Number of elements in an array (input sizes)
sequential_sort_times = [14120600,  19328600, 23922000,  13098900, 22113400, 16337200, 24052200]  # Example times for sequential sorting (in nanoseconds)
parallel_sort_times = [1195200, 1507900, 1767800, 1138300,  1919500, 1727700, 1551300]  # Example times for parallel sorting (in nanoseconds)

# Plotting the graph
plt.figure(figsize=(10, 6))  # Set the figure size

# Plot Bubble Sort and Collections.sort
plt.plot(array_sizes, sequential_sort_times, label='Sequential Sort (non threading approach)', color='red', marker='o')
plt.plot(array_sizes, parallel_sort_times, label='Parallel Sorting (threaded approach)', color='blue', marker='o')

# Set labels and title
plt.xlabel('Array size (nb of integers in an array))')
plt.ylabel('Time Taken (Nanoseconds)')
plt.title('Comparison between parallel sorting by chucks and Arrays.sort method')

# No logarithmic scale, using linear scale by default

# Display the legend
plt.legend()

# Show the plot
plt.show()

