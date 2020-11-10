package local.nio.heartbeat;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;

public abstract class HeartBeatHandler extends SimpleChannelInboundHandler<ByteBuf> {

    protected final static byte PING_TYPE = 1;
    protected final static byte PONG_TYPE = 2;
    protected final static byte BIZ_TYPE = 3;

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte type = msg.getByte(0);
        if (type == PING_TYPE) {
            sendPongMsg(ctx);
        } else if (type == PONG_TYPE) {
            System.out.println("get pong msg from " + ctx.channel().remoteAddress());
        } else {
            handleBizData(ctx, msg);
        }
    }

    protected void sendPongMsg(ChannelHandlerContext ctx) {
        System.out.println("server received a ping from " + ctx.channel().remoteAddress());
        ByteBuf bytebuf = ctx.channel().alloc().buffer(1);
        bytebuf.writeByte(PONG_TYPE);
        bytebuf.retain();
        ctx.writeAndFlush(bytebuf);
        System.out.println("send pong msg to " + ctx.channel().remoteAddress());
    }


    protected abstract void handleBizData(ChannelHandlerContext ctx, ByteBuf msg);

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            switch (e.state()) {
                case READER_IDLE:
                    handleReadIdle(ctx);
                    break;
                case WRITER_IDLE:
                    handleWriteIdle(ctx);
                    break;
                case ALL_IDLE:
                    handleAllIdle(ctx);
                    break;
                default:
                    System.out.println("should never happened");
            }
        }
    }

    protected void handleReadIdle(ChannelHandlerContext ctx) {

    }

    protected void handleWriteIdle(ChannelHandlerContext ctx) {

    }

    protected void handleAllIdle(ChannelHandlerContext ctx) {

    }
}
