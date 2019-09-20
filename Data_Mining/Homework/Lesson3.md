# Lesson 3

1. In real-world data, tuples with *missing values* for some attributes are a common occurrence. Describe various methods for handling this problem.
    > There are 6 ways to handle it. They are:
    > 1. Just ignore these incomplete tuples.
    > 2. Fill in the missing value manually.
    > 3. Use a global constant to fill in the missing value.
    > 4. Use a measure of central tendency for the attribute (e.g., the *mean* or *median*) to fill in the missing value.
    > 5. Use the attribute *mean* or *median* for all samples belonging to the same class as the given tuple.
    > 6. Use the most probable value to fill in the missing value.

2. *Exercise 2.2* gave the folowing data (in increasing order) for the attribute *age*: `13, 15, 16, 16, 19, 20, 20, 21, 22, 22, 25, 25, 25, 25, 30, 33, 33, 35, 35, 35, 35, 36, 40, 45, 46, 52, 70`.
    1. Use *smoothing by bin means* to smooth these data, using a bin depth of 3. Illustrate your steps. Comment on the effect of this technique of the given data.
        > 1. Divide the given dataset into 9 buckets with 3 elements per bucket.
        > 2. Calculate the *mean* of each bucket.
        > 3. Replace every element by the *mean* value in each bucket.
        >
        > | Bucket | Data_1 | Data_2 | Data_3 | Mean |
        > | :----- | -----: | -----: | -----: | ---: |
        > | 1      |     13 |     15 |     16 | 14.7 |
        > | 2      |     16 |     19 |     20 | 18.3 |
        > | 3      |     20 |     21 |     22 | 21.0 |
        > | 4      |     22 |     25 |     25 | 24.0 |
        > | 5      |     25 |     25 |     30 | 26.7 |
        > | 6      |     33 |     33 |     35 | 33.7 |
        > | 7      |     35 |     35 |     35 | 35.0 |
        > | 8      |     36 |     40 |     45 | 40.3 |
        > | 9      |     46 |     52 |     70 | 56.0 |
    
    2. How might you determine *outliers* in the data?
        > 1. Using *clustering*. Intuitively, values that fall outside of the set of clusters may be considered outliers.
        > 2. Using *maximum and minimum observations*. In the previous chapters, we find out the *5 Number Summary* of the dataset. If a value is smaller than *minimum observation* or larger than *maximum observation*, it may be considered outliers.
    
    3. What other methods are there for data smoothing?
        > There are bining, regression and clustering.
    
3. Discussing issues to consider during *data integration*.
    > There are issues to consider such as *Entity Identification Problem*, *Redundancy*, *Tuple Dulplication* and *Data Value Conflict*.
