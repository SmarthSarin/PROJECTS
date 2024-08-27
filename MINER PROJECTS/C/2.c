// #include <stdio.h>

// // Function prototype
// int compute(int yr, int d1, int d2);

// int main() {
//     int year, w, s;

//     // Prompt the user for input
//     printf("Enter a year: ");
//     scanf("%d", &year);

//     w = year;
//     s = year + 1;

//     int result = compute(year, w, s);

//     printf("Total days in year %d: %d\n", year, result);

//     return 0;
// }

// int compute(int yr, int d1, int d2) {
//     if (yr % 4 == 0 && (yr % 100 != 0 || yr % 400 == 0))
//         return d1 + d2 + 1; // Leap year
//     else
//         return d1 + d2; // Non-leap year
// }

#include <stdio.h>

int main() {
    // Initialize variables
    int n1, n2, c, x, y;
    n1 = 5;
    n2 = n1; // Corrected from nl to n1
    c = n1 + n2;
    x = 20 / 4 * 2 + 5;

    printf("The value of n1: %d\n", n1); // Corrected the printf statements
    printf("The value of n2: %d\n", n2);
    printf("The value of c: %d\n", c);
    printf("The value of x: %d\n", x);

    return 0;
}
