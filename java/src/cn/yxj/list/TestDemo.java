package cn.yxj.list;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestDemo {
public static void main(String[] args) {
//	 ExecutorService executorservice =Executors.newCachedThreadPool();
	ThreadPoolExecutor  executorservice =  new ThreadPoolExecutor(5, 10, 1, TimeUnit.MINUTES , new ArrayBlockingQueue<Runnable>(10));
	BlockingQueue<Integer>  queue= new ArrayBlockingQueue<Integer>(200);
	for(int i=0;i<200;i++){
		queue.add(i);
	}
	for(int i=0;i<3;i++){
		Future<String>  result=executorservice.submit(new BlockingQueueDemo(queue));
		try{
			System.out.println(result.get());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	executorservice.shutdown();
}}
