import matplotlib.pyplot as plt

# Data: Input sizes and sorting times (in nanoseconds)
input_sizes = [5,10, 15]
collections_sort_times = [ 157900, 161600,154300 ]
bubble_sort_times = [470800, 502400, 507100]

# Plotting the data
plt.figure(figsize=(10, 6))
plt.plot(input_sizes, collections_sort_times, label="Collections.sort (TimSort)", marker='o', linestyle='--', color='blue')
plt.plot(input_sizes, bubble_sort_times, label="Bubble Sort", marker='o', linestyle='-', color='red')

# Adding labels and title
plt.xlabel("Input Size (number of students)", fontsize=12)
plt.ylabel("Time Taken (nanoseconds)", fontsize=12)
plt.title("Performance Comparison: Collections.sort vs Bubble Sort", fontsize=14)
plt.yscale('log')  # Use logarithmic scale for better visualization

# Adding legend and grid
plt.legend(fontsize=12)
plt.grid(True, which='both', linestyle='--', linewidth=0.5)

# Show the graph
plt.show()
