package local.logger;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;

import java.io.File;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/19 下午7:01
 **/
public class ListenFileStatusWithApacheListener extends FileAlterationListenerAdaptor {
    @Override
    public void onFileCreate(File file) {
        System.out.println(file.getName() + "created !!!");
        super.onFileCreate(file);
    }

    @Override
    public void onFileChange(File file) {
        System.out.println(file.getName() + "changed !!!");
        super.onFileChange(file);
    }

    @Override
    public void onFileDelete(File file) {
        System.out.println(file.getName() + "deleted !!!");
        super.onFileDelete(file);
    }
}
