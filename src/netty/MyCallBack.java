package tcpserver.src.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public interface MyCallBack {

    public void read(byte[] read);  //데이터를 수신하면 동작시킬 메소드

    public byte[] write(byte[] msg);  //사용자가 데이터를 조립할 메소드(msg는 받은 메시지)

    public void afterClose(ChannelHandlerContext ctx);  //종료시 동작시킬

    public void stop();
}
