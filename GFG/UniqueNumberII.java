package GFG;

import java.util.HashMap;
import java.util.Map;

public class UniqueNumberII {
    public int[] singleNum(int[] arr) {
        // Code here
        int ln = arr.length;

        int res[] = new int[2];
        int c = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res[c++] = entry.getKey();
            }
        }

        if (res[0] > res[1]) {
            int temp = res[1];
            res[1] = res[0];
            res[0] = temp;
        }

        return res;
    }
}
