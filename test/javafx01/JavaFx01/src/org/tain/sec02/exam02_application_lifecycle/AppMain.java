package org.tain.sec02.exam02_application_lifecycle;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppMain extends Application {

	public AppMain() {
		System.out.println(Thread.currentThread().getName() + ": AppMain()");
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + ": main()");
		launch(args);
	}
	
	@Override
	public void init() throws Exception {
		System.out.println(Thread.currentThread().getName() + ": init()");
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(Thread.currentThread().getName() + ": start()");
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		System.out.println(Thread.currentThread().getName() + ": stop()");
	}
}
