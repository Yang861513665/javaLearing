package cn.yxj.scheduler;

public class Task {
   private String id;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}
   public void run(String id){
	     System.out.println("执行  run 方法......"+ id);
   }
}
