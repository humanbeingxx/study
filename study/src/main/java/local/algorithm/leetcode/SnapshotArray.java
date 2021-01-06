package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SnapshotArray {

    private int snapshotId;

    private List<TreeMap<Integer, Integer>> setRecord;

    public SnapshotArray(int length) {
        snapshotId = 0;
        setRecord = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            setRecord.add(null);
        }
    }

    public void set(int index, int val) {
        if (setRecord.get(index) == null) {
            setRecord.set(index, new TreeMap<>());
        }
        setRecord.get(index).put(snapshotId, val);
    }

    public int snap() {
        return snapshotId++;
    }

    public int get(int index, int snap_id) {
        if (setRecord.get(index) == null) {
            return 0;
        }
        Map.Entry<Integer, Integer> floorEntry = setRecord.get(index).floorEntry(snap_id);
        return floorEntry == null ? 0 : floorEntry.getValue();
    }

}
