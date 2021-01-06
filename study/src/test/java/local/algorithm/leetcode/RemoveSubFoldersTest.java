package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/8 20:08
 */
public class RemoveSubFoldersTest {

    @Test
    public void testRemoveSubFolders1() {
        List<String> result = new RemoveSubFolders().removeSubFolders(new String[]{"/a/b/c", "/a/b/d", "/a/b/ca"});
        assertEquals(result, Lists.newArrayList("/a/b/c", "/a/b/d", "/a/b/ca").stream().sorted().collect(Collectors.toList()));
    }

    @Test
    public void testRemoveSubFolders2() {
        List<String> result = new RemoveSubFolders().removeSubFolders(new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"});
        assertEquals(result, Lists.newArrayList("/a", "/c/d", "/c/f").stream().sorted().collect(Collectors.toList()));
    }

    @Test
    public void testRemoveSubFolders3() {
        List<String> result = new RemoveSubFolders().removeSubFolders(new String[]{"/a", "/a/b/c", "/a/b/d"});
        assertEquals(result, Lists.newArrayList("/a").stream().sorted().collect(Collectors.toList()));
    }
}