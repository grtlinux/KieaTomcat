package org.tain.sec02.exam04_watchservice;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

//@Component
public class WatchServiceExample {

	public WatchServiceExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		WatchService watchService = FileSystems.getDefault().newWatchService();
		Path directory = Paths.get("/Users/kangmac/_subdir");
		directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
				StandardWatchEventKinds.ENTRY_DELETE,
				StandardWatchEventKinds.ENTRY_MODIFY);
		
		while (true) {
			WatchKey watchKey = watchService.take();
			List<WatchEvent<?>> list = watchKey.pollEvents();
			for (WatchEvent<?> watchEvent : list) {
				// 이벤트 종류 얻기
				Kind<?> kind = watchEvent.kind();
				// 감지된 Path 얻기
				Path path = (Path) watchEvent.context();
				// 이벤트 종류별로 처리
				if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
					System.out.println("ENTRY_CREATE: " + path.getFileName());
				} else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
					System.out.println("ENTRY_DELETE: " + path.getFileName());
				} else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
					System.out.println("ENTRY_MODIFY: " + path.getFileName());
				} else if (kind == StandardWatchEventKinds.OVERFLOW) {
					;
				}
			}
			boolean valid = watchKey.reset();
			if (!valid) {
				break;
			}
			System.out.println(".");
		}
	}
}
