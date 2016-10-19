package com.NIO;

import javax.imageio.stream.FileCacheImageInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created with IDEA
 * User: sunsy3
 * Time: 2016/10/13
 * Commit:
 */
public class NioDemo {

    /**
     * Channel 的实现
     * FileChannel 从文件中读写数据
     * DatagramChannel 能通过UDP读写网络中的数据
     * SocketChannel 能通过TCP读写网络中的数据
     * ServerSocketChannel 可以监听新进来的TCP连接，像Web服务器那样。对每一个新进来的连接都会创建一个SocketChannel
     *
     * Buffer 的实现
     * ByteBuffer
     * CharBuffer
     * DoubleBuffer
     * FloatBuffer
     * IntBuffer
     * LongBuffer
     * ShortBuffer
     *
     * NIO可让您只使用一个（或几个）单线程管理多个通道（网络连接或文件），
     * 但付出的代价是解析数据可能会比从一个阻塞流中读取数据更复杂如果需要
     * 管理同时打开的成千上万个连接，这些连接每次只是发送少量的数据，例如
     * 聊天服务器，实现NIO的服务器可能是一个优势。同样，如果你需要维持许多
     * 打开的连接到其他计算机上，如P2P网络中，使用一个单独的线程来管理你
     * 所有出站连接，可能是一个优势。
     *
     * 如果你有少量的连接使用非常高的带宽，一次发送大量的数据，也许典型的IO服务器实现可能非常契合。
     */

    public static void main(String[] args){

    }

    /**
     * Buffer的基本用法
     * 使用Buffer读写数据一般遵循以下四个步骤：
     * 写入数据到Buffer
     * 调用flip()方法
     * 从Buffer中读取数据
     * 调用clear()方法或者compact()方法
     *
     * 当向buffer写入数据时，buffer会记录下写了多少数据。一旦要读取数据，
     * 需要通过flip()方法将Buffer从写模式切换到读模式。在读模式下，可以读取之前写入到buffer的所有数据。
     * 一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入。
     * 有两种方式能清空缓冲区：调用clear()或compact()方法。clear()方法会清空整个缓冲区。
     * compact()方法只会清除已经读过的数据。任何未读的数据都被移到缓冲区的起始处，
     * 新写入的数据将放到缓冲区未读数据的后面。
     */

    // 下面是一个使用FileChannel读取数据到Buffer中的示例：
    public void FileChannelReadBuffer() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel(); //通道
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            System.out.println("read:" + bytesRead);
            buf.flip();
            while(buf.hasRemaining()){
                System.out.println((char)buf.get());
            }
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }



}
