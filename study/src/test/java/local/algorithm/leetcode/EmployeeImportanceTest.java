package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/17 22:34
 */
public class EmployeeImportanceTest {

    @Test
    public void testGetImportance1() {
        List<EmployeeImportance.Employee> employeeList = Lists.newArrayList();
        employeeList.add(new EmployeeImportance.Employee(1, 5, Lists.newArrayList(2, 3)));
        employeeList.add(new EmployeeImportance.Employee(2, 3, Lists.newArrayList()));
        employeeList.add(new EmployeeImportance.Employee(3, 3, Lists.newArrayList()));

        int result = new EmployeeImportance().getImportance(employeeList, 1);
        Assert.assertEquals(result, 11);
    }

    @Test
    public void testGetImportance2() {
        List<EmployeeImportance.Employee> employeeList = Lists.newArrayList();
        employeeList.add(new EmployeeImportance.Employee(1, 5, Lists.newArrayList(2, 3)));
        employeeList.add(new EmployeeImportance.Employee(2, 3, Lists.newArrayList()));
        employeeList.add(new EmployeeImportance.Employee(3, 3, Lists.newArrayList()));

        int result = new EmployeeImportance().getImportance(employeeList, 10);
        Assert.assertEquals(result, 0);
    }
}