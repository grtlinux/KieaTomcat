package org.tain.sec04.exam01_file;

import java.io.File;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "FileExample")
public class FileExample {

	public FileExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		File dir = new File("/Users/kangmac/STS_GIT");
		File file1 = new File("/Users/kangmac/_file1.txt");
		File file2 = new File("/Users/kangmac/_file2.txt");
		File file3 = new File(new URI("file:///Users/kangmac/_file3.txt"));
		
		if (dir.exists() == false) {  dir.mkdirs();  }
		if (file1.exists() == false) {  file1.createNewFile();  }
		if (file2.exists() == false) {  file2.createNewFile();  }
		if (file3.exists() == false) {  file3.createNewFile();  }

		//File temp = new File("/tmp");
		File temp = new File("/Users/kangmac/STS_GIT");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd   a   HH:mm");
		File[] contents = temp.listFiles();
		System.out.println("날짜              시간         형태       크기    이름");
		System.out.println("-------------------------------------------------------------------");
		for (File file : contents) {
			System.out.print(sdf.format(new Date(file.lastModified())));
			if (file.isDirectory()) {
				System.out.print("\t<DIR>\t\t\t" + file.getName());
			} else {
				System.out.print("\t\t\t" + file.length() + "\t" + file.getName());
			}
 			System.out.println();
		}
	}
}
