package odev3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
	
	public static String ogrenciKayit() {
		Scanner myFuncScanner = new Scanner(System.in);
		System.out.println("Lütfen kaydedilecek öğrencinin ismini ve soyadını giriniz :");
		String fullName = myFuncScanner.nextLine();
		System.out.println("Lütfen öğrencinin numarasını giriniz : ");
		int no = myFuncScanner.nextInt();
		System.out.println("Lütfen öğrencinin doğum yılını giriniz : ");
		int birthYear = myFuncScanner.nextInt();
		System.out.println("Lütfen öğrencinin not ortalamasını giriniz : ");
		float notOrt = myFuncScanner.nextInt();
		return fullName + ", " + no + ", " + birthYear + ", " + notOrt + ".\n";
	}
	
	public static void addStudent(String myString, File file) {
		try {
			FileWriter myFileWriter = new FileWriter(file, true);
			myFileWriter.write(myString);
			myFileWriter.close();
		} catch (Exception e) {
			System.out.println("Dosyaya data yazılıyorken bir hata oluştu.");
			e.printStackTrace();
		}
	}
	
	public static String findStudent(File file) {
		Scanner myFuncScanner = new Scanner(System.in);
		System.out.println("Lütfen öğrencinin isminin  ilk harfini giriniz : ");
		String firstChar = myFuncScanner.nextLine();
		String ogrenciler = new String() ;
		
		try {
			BufferedReader buffReader = new BufferedReader(new FileReader(file.getName()));
			String line;
			while((line = buffReader.readLine()) != null) {
				if(firstChar.charAt(0) == line.charAt(0))
					ogrenciler += line + "\n";
			}
		} catch (Exception e) {
			System.out.println("Öğrenci bulunurken bir hata oluştu.");
			e.printStackTrace();
		}
		
		return ogrenciler;
		
	}
	
	public static void updateNote(File file) {
		
		Scanner myFuncScanner = new Scanner(System.in);
		System.out.println("Lütfen notunu değiştirmek istediğiniz öğrencinin numarasını giriniz : ");
		String studentNo = myFuncScanner.nextLine();
		System.out.println("Lütfen öğrencinin yeni notunu giriniz : ");
		String note = myFuncScanner.nextLine();
		String updatedData = new String();
		String line = new String();
		
		try {
			BufferedReader myBufferedReader = new BufferedReader(new FileReader(file.getName()));
			while((line = myBufferedReader.readLine()) != null) {
				if (line.contains(studentNo)) {
					String[] stringArr = line.split(",");
					stringArr[3] = " " + note + ".";
					line = stringArr[0] + ", " + stringArr[1] + ", " + stringArr[2] + ", " + stringArr[3];
				}
				updatedData += line + "\n";
			}
			
		} catch (Exception e) {
			System.out.println("Öğrenci notu güncellenirken bir hata oluştu.");
			e.printStackTrace();
		}
		
		
		try {
			System.out.println(updatedData);
			FileWriter myFileWriter = new FileWriter(file);
			myFileWriter.write(updatedData);
			myFileWriter.close();
		} catch (Exception e) {
			System.out.println("Hata.");
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		File myFile = new File("ogrenciBilgi.txt");
		System.out.println(myFile.getName());
		
		try {
			if(myFile.createNewFile())
				System.out.println("Öğrenci data'ları için dosya oluşturuldu.");
			else {
				System.out.println("Öğrenci kayıtları için bir dosya zaten mevcut.");
			}
		} catch (Exception e) {
			System.out.println("Öğrenci data'ları için dosya oluşturuluyorken bir hata oluştu.");
			e.printStackTrace();
		}
		
		//Dosya daha önceden mevcutsa içindeki bilgileri temizliyor
		/*
		try {
			FileWriter myFileWriter = new FileWriter(myFile);
			myFileWriter.write("");
			myFileWriter.close();
		} catch (Exception e) {
			System.out.println("Dosyaya data yazılıyorken bir hata meydana geldi.");
			e.printStackTrace();
		}*/
		updateNote(myFile);
		System.out.println(findStudent(myFile));
	}

}


/*

1.	işlem: Yeni öğrenci kaydetme. Yeni kayıt kullanıcıdan alınarak, 
	her bir öğrenci bir satıra gelecek şekilde ve öğrenci bilgilerinin arasında virgül olacak şekilde aşağıdaki formatta dosyaya kaydedilecektir. 
	Bu bilgiler sırasıyla öğrencinin adı soyadı, numarası, doğum yılı ve not ortalaması şeklindedir.

Örnek: Mehmet Yılmaz, 1306210029, 2004, 78. 

2.	işlem: Öğrencileri listeleme. Kullanıcıdan bu işlemi seçtiği takdirde bir harf girmesi istenecek. 
	Örneğin; kullanıcı ‘M’ harfini girip enter’a bastı. 
	Bu durumda ismi ‘M’ ile başlayan tüm öğrencilerin tüm bilgileri ekrana yazdırılacak.

3.	işlem: Not Güncelleme. 
	Kullanıcı notunu güncellemek istediği öğrencinin numarasını ve yeni notunu girecek ve dosyadaki ilgili öğrencinin notu güncellenecek. 


*/