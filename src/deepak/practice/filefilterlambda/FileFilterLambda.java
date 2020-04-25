package deepak.practice.filefilterlambda;

import java.io.File;
import java.io.FileFilter;

public class FileFilterLambda {

	public static void main(String[] args) {
		FileFilter filterLambda = (File file) -> file.getAbsolutePath().endsWith(".java");

		File file = new File("E:\\deepak\\eclipse-workspace\\Java8Practice\\src\\deepak\\practice\\filefilterlambda");

		File[] fileArr = file.listFiles(filterLambda);

		for (int i = 0; i < fileArr.length; i++) {
			System.out.println(fileArr[i]);
		}
	}

}
