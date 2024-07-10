class Solution {
    public int hIndex(int[] citations) {
        int numPapers = citations.length;
        int[] citationCounts = new int[numPapers + 1];

        for (int citation : citations) {
            if (citation >= numPapers) {
                citationCounts[numPapers]++;
            } else {
                citationCounts[citation]++;
            }
        }

        int cumulativePapers = 0;
        for (int hIndex = numPapers; hIndex >= 0; hIndex--) {
            cumulativePapers += citationCounts[hIndex];
            if (cumulativePapers >= hIndex) {
                return hIndex;
            }
        }

        return 0;
    }
}