
    /* Intuition (Keep this in mind)

“Fix one position at a time, try all possible characters, and backtrack to explore other choices.”

Breakdown:
We treat the string like positions to fill
At each position (index):
Try all possible characters (swap)
Move to next position (index + 1)
Undo change (backtrack) to try next option
🧩 Key Concepts Used
1. Swapping
Helps place a new character at current position
2. Recursion
Moves to next index → solves smaller problem
3. Backtracking
Undo swap to restore original state
🎯 Mental Model
index = 0 → choose 1st character
index = 1 → choose 2nd character
index = 2 → choose 3rd character
index = n → permutation ready
🔁 Pattern Template
for (int i = index; i < n; i++) {
    swap(index, i);
    recurse(index + 1);
    backtrack (undo swap);
}
TC: o(n! * n)
SC: o(n! * m)
*/

    class Solution {
    public boolean checkInclusion(String s1, String s2) {
        return generatePerm(s1.toCharArray(), 0, s2);
    }

    private boolean generatePerm(char[] arr, int index, String s2) {
        // Base case: one permutation ready
        if (index == arr.length) {
            String perm = new String(arr);
            return s2.contains(perm);
        }

        for (int i = index; i < arr.length; i++) {
            // Swap
            swap(arr, i, index);

            // Recurse → if found, stop early
            if (generatePerm(arr, index + 1, s2)) {
                return true;
            }

            // Backtrack (undo swap)
            swap(arr, i, index);
        }

        return false;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}