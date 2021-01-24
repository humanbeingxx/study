package local.interview_internal_reference.byhunter;

import com.google.common.base.Preconditions;

public class BinarySearch {

    public static int search(int[] data, int target) {
        Preconditions.checkArgument(data != null && data.length > 0);
        int l = 0, h = data.length - 1, mid;
        while (l <= h) {
            mid = (l + h) / 2;
            if (data[mid] > target) {
                h = mid - 1;
            } else if (data[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -(l + 1);
    }

    public static int searchFloor(int[] data, int target) {
        Preconditions.checkArgument(data != null && data.length > 0);
        if (data[0] > target) {
            return -1;
        }
        int l = 0, h = data.length - 1, mid;
        while (l <= h) {
            mid = (l + h) / 2;
            if (data[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return (h == data.length - 1 || data[h + 1] > target) ? h : h + 1;
    }

    public static int searchCeil(int[] data, int target) {
        Preconditions.checkArgument(data != null && data.length > 0);
        if (data[data.length - 1] < target) {
            return -1;
        }
        int l = 0, h = data.length - 1, mid;
        while (l <= h) {
            mid = (l + h) / 2;
            if (data[mid] <= target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return (l == 0 || data[l - 1] < target) ? l : l - 1;
    }
}
