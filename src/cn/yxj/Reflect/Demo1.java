package cn.yxj.Reflect;

public class Demo1 {
     private String username;
	private void show1(){
		  System.out.println("show1------");
	  }
	 public Integer show2(Integer  i){
		//  System.out.println("show2----"+i);
		  return i;
	  }
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
