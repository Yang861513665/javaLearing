package cn.yxj.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import cn.yxj.domain.Person;

@SuppressWarnings(value = { "all" })
public class objectStreamDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
//		writeObj();
		readObj();
	}

	private static void readObj() throws IOException, ClassNotFoundException {
		
	FileInputStream fis=new FileInputStream("f:\\javaTempFiles\\person.object");
	ObjectInputStream ois=new ObjectInputStream(fis);
	System.out.println(ois.readObject());
	}

	private static void writeObj() throws FileNotFoundException, IOException {
		Person p=new Person("杨希军",20);
	
		 FileOutputStream fos=new  FileOutputStream("f:\\javaTempFiles\\person.object");

		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(p);
        oos.close();
        fos.close();
	}

}
