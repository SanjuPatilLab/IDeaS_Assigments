package com.qa.PageObject;

import java.io.File;

public class Utils {

	public static String home = System.getProperty("user.home");;

	public static Boolean fileDownloaded(String fileName,long timeWait) throws InterruptedException {


		String file_name = fileName;
		Boolean fileresult = false;
		String file_with_location = home + "\\Downloads\\" + file_name;
		System.out.println("File Download location ===========================" + home + "\\Downloads\\" + file_name);
		File file = new File(file_with_location);
		for (int i = 0; i < 3; i++) {
			if (file.exists()) {
				fileresult = true;
				break;
			} else {
				Thread.sleep(timeWait);
			}


		}
		return fileresult;
	}

	public static void deleteFileExists(String fileName) {


		String file_name = fileName;
		String file_with_location = home + "\\Downloads\\" + file_name;
		System.out.println("Delete Existing File ===========================" + home + "\\Downloads\\" + file_name);

		File file = new File(file_with_location);
		if(file.exists()) {

			file.delete();

		}


	}


}
