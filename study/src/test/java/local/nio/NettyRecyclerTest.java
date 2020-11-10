package local.nio;

import io.netty.util.Recycler;
import lombok.Getter;
import lombok.Setter;
import org.testng.annotations.Test;

public class NettyRecyclerTest {

    static class MyObject {

        @Getter
        @Setter
        private String val;
        private final Recycler.Handle<MyObject> handle;

        public MyObject(Recycler.Handle<MyObject> handle) {
            this.handle = handle;
        }

        public void recycle() {
            val = null;
            handle.recycle(this);
        }
    }

    @Test
    public void test() throws InterruptedException {
        Recycler<MyObject> recycler = new Recycler<MyObject>() {
            @Override
            protected MyObject newObject(Handle<MyObject> handle) {
                return new MyObject(handle);
            }
        };

        MyObject myObject = recycler.get();
//        new Thread(myObject::recycle).start();
//        new Thread(myObject::recycle).start();
        myObject.recycle();
        myObject.recycle();
//        Thread.sleep(100);
        MyObject myObject2 = recycler.get();
        MyObject myObject3 = recycler.get();
        MyObject myObject4 = recycler.get();
        System.out.println(myObject == myObject2);
        System.out.println(myObject == myObject3);
        System.out.println(myObject == myObject4);
    }
}
