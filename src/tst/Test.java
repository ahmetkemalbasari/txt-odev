package tst;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Test {
	
	
	public static void main(String[] args) {
		
		System.out.println("Test çalıştırıldı.");
		File myFile = new File("dosya.txt");
		System.out.println(myFile.getAbsolutePath());
		String[] dividedStrings = null;
		//dosya oluşturma
		try {
			
			if(myFile.createNewFile())
				System.out.println("Dosya oluşturuldu : " + myFile.getName());
			else {
				System.out.println("Dosya zaten mevcut.");
			}
		} catch (Exception e) {
			System.out.println("Dosya oluşturma işleminde bir hata oluştu!");
			e.printStackTrace();
		}
		//dosya yazmak için hazırlık
		try {
			String fullTextString = new String();
			BufferedReader buffReader = new BufferedReader(new FileReader(myFile.getName()));
			String line;
			while((line = buffReader.readLine()) != null) {
					fullTextString += line;
			}
			dividedStrings = fullTextString.split(",");
		} catch (Exception e) {
			System.out.println("Öğremci bulunurken bir haya meydana geldi.");
			e.printStackTrace();
		}
		
		System.out.println(dividedStrings[4]);
	}
	
}
