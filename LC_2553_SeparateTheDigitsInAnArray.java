
class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> resultList = new ArrayList<>();

        for (int number : nums) {
            List<Integer> digits = new ArrayList<>();

            while (number > 0) {
                digits.add(number % 10);
                number /= 10;
            }

            Collections.reverse(digits);
            resultList.addAll(digits);
        }

        int[] result = new int[resultList.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
