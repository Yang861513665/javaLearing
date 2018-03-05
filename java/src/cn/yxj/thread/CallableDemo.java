package cn.yxj.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo  implements Callable<Object>{

	@Override
	public Object call() throws Exception {
		Thread.sleep(1000);
		return Thread.currentThread().getName();
	}
    public static void main(String[] args) {
    	 FutureTask<Object> result = new FutureTask<>(new CallableDemo());
//    	 FutureTask<Object> result2 = new FutureTask<>(new CallableDemo());
             new Thread(result).start();
//             new Thread(result2).start();
             try {
				System.out.println(result.get());
			} catch (Exception e) {
				e.printStackTrace();
	}}
}
