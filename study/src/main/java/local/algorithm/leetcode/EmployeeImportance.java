package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/17 22:29
 */
public class EmployeeImportance {

    public static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }

    }

    public int getImportance(List<Employee> employees, int id) {
        if (employees.size() == 0) {
            return 0;
        }
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }
        return rec(id, employeeMap);
    }

    int rec(int id, Map<Integer, Employee> employeeMap) {
        if (!employeeMap.containsKey(id)) {
            return 0;
        }
        int sum = employeeMap.get(id).importance;
        for (Integer subordinate : employeeMap.get(id).subordinates) {
            sum += rec(subordinate, employeeMap);
        }
        return sum;
    }
}
