package cn.yxj.Enum;

public class TestEnum {
    private Color color;
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public TestEnum(Color color){
    	this.color =color;
    }
	public static void main(String[] args) {
		  TestEnum testEnum = new TestEnum(Color.YELLOW);
		switch(testEnum.getColor()){
		case BLUE:
			System.out.println("BLUE...");  break;
		case YELLOW:
			System.out.println("yellow...");  break;
		case RED:
			System.out.println("RED...");  break;
		default:
			System.out.println("error color");
			break;
		}
	Color color = 	Color.BLUE;
	System.out.println(color.toString().toLowerCase().equals("blue"));
	}
}
