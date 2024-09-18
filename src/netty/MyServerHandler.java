package tcpserver.src.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@ChannelHandler.Sharable
public class MyServerHandler extends SimpleChannelInboundHandler {

    private MyCallBack writer;

    public MyServerHandler(MyCallBack write){
        this.writer = write;
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    //종료 이벤트
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        if(writer != null){
            writer.afterClose(ctx);
        }
        super.channelUnregistered(ctx);
    }

    //요청에 따른 읽기, 쓰기 이벤트 분기(인터페이스가 구현되어있지 않으면 에코)

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
//        String str = o.toString();


        ByteBuf inBuffer = (ByteBuf) o;
        byte[] received = new byte[inBuffer.readableBytes()];
        inBuffer.readBytes(received);
//        bytes = SerializationUtils.serialize((Serializable) inBuffer);
//        byte[] received = inBuffer.array();
//        String received = new String(ByteBufUtil.getBytes(inBuffer));
//        bytes = SerializationUtils.serialize(received);
//        String received = String.valueOf((StandardCharsets.UTF_8).decode(inBuffer.nioBuffer()));

        if(writer == null){
            System.out.println("Server received : " + received);
            channelHandlerContext.write(Unpooled.copiedBuffer(("echo : "+ received).getBytes()));
        } else {
            writer.read(received);
        }
    }
}
