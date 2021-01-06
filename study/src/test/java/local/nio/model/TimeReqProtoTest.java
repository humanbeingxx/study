package local.nio.model;

import com.google.protobuf.InvalidProtocolBufferException;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-06-18
 **/
public class TimeReqProtoTest {

    @Test
    public void test() throws InvalidProtocolBufferException {
        TimeReqProto.TimeReq.Builder builder = TimeReqProto.TimeReq.newBuilder();
        builder.setName("TestName");
        TimeReqProto.TimeReq req = builder.build();
        byte[] bytes = req.toByteArray();
        TimeReqProto.TimeReq parse = TimeReqProto.TimeReq.parseFrom(bytes);
        System.out.println(parse.getName());
    }
}