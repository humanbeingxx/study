package local.interview_internal_reference.didi;

public class FindNumOverQuarter {

    public int[] find(int[] nums) {
        int num1 = 0, num2 = 0, num3 = 0;
        int count1 = 0, count2 = 0, count3 = 0;
        for (int num : nums) {
            if (count1 == 0 && num != num2 && num != num3) {
                count1++;
                num1 = num;
            } else if (count1 != 0 && num == num1) {
                count1++;
            } else if (count1 != 0 && num != num2 && num != num3) {
                count1--;
            }

            if (count2 == 0 && num != num1 && num != num3) {
                count2++;
                num2 = num;
            } else if (count2 != 0 && num == num2) {
                count2++;
            } else if (count2 != 0 && num != num1 && num != num3) {
                count2--;
            }

            if (count3 == 0 && num != num2 && num != num1) {
                count3++;
                num3 = num;
            } else if (count3 != 0 && num == num3) {
                count3++;
            } else if (count3 != 0 && num != num2 && num != num1) {
                count3--;
            }

        }
        return new int[]{num1, num2, num3};
    }
}
