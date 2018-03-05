package cn.yxj.thread;

/**
 *   线程死锁程序Demo
 * 
 * */
public class DeadThreadDemo {
	public static void main(String[] args) {
		final Object lockA = new Object();
		final Object lockB = new Object();
		new Thread(new Runnable() {
			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				synchronized (lockA) {
					System.out.println(name + " got lockA,  want LockB");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					synchronized (lockB) {
						System.out.println(name + " got lockB");
					}
				}
			}
		}, "线程-A").start();

		new Thread(new Runnable() {
			@Override
			public void run() {

				String name = Thread.currentThread().getName();
				synchronized (lockB) {
					System.out.println(name + " got lockB, want LockA");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (lockA) {
						System.out.println(name + " got lockA");
					}
				}

			}
		}, "线程-B").start();
	}
}
