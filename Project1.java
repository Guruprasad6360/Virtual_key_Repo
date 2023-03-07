package File_Project;

import java.util.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.*;
import java.util.*;

public class Project1 {
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome!");
		System.out.println("My Name is Guruprasad I am Intern at Teksystems Global Services Limited.");
		System.out.println("Building protoype for Locker System Privated Limited!");
		System.out.println();
		boolean exit=false;
		System.out.println();
		while(!exit) {
		System.out.println();
		System.out.println("MAIN MENU");
		System.out.println("Press 1 To view The list of File");
		System.out.println("Press 2 To Insert the File");
		System.out.println("Press 3 To Delete the File");
		System.out.println("Press 4 To Search specfic File");
		System.out.println("Enter 5 Inorder to exit");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		switch (n) {
		case 1:
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the Folder path");
			String folderPath = scanner.nextLine();
			File folder = new File(folderPath);
			if (!folder.exists() || !folder.isDirectory()) {
				System.out.println("invalid folder path");
				return;
			}
			System.out.println("sort bu (name/size/date):::");
			String sortBy = scanner.nextLine();
			Comparator<File> comparator = null;
			if (sortBy.equals("name")) {
				comparator = Comparator.comparing(File::getName);
			} else if (sortBy.equals("size")) {
				comparator = Comparator.comparingLong(File::length);
			} else if (sortBy.equals("date")) {
				comparator = Comparator.comparingLong(File::lastModified);
			} else {
				System.out.println("Invalid sorting operation");
				return;
			}
			File[] files = folder.listFiles();
			Arrays.sort(files, comparator);
			for (File file : files) {
				System.out.println(file.getName());
			}
			break;

		case 2:
			Scanner s1 = new Scanner(System.in);
			System.out.println("Enter the filename");
			String filename = s1.nextLine();
			System.out.println("Enter the directory path");
			String dirpath = s1.nextLine();
			File directory = new File(dirpath);
			File file = new File(directory, filename);
			try {
				if (file.createNewFile()) {
					System.out.println("File Created Successfully:");
				} else {
					System.out.println("File already exist..");
				}
			} catch (Exception e) {
				System.out.println("An Error Occured..while creating the file");
				e.printStackTrace();
			}
			break;
		case 3:
			Scanner s3 = new Scanner(System.in);
			System.out.println("Enter the filename to delete");
			String filename1 = s3.nextLine();
			System.out.println("Enter the directory path to delete");
			String dirpath3 = s3.nextLine();
			File filetodelete = new File(dirpath3, filename1);
			if (filetodelete.delete()) {
				System.out.println("File deleted");
			} else {
				System.out.println("Failed to delete");
			}
			break;

		case 4:
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the directory path");
			String DirPath = null;
			try {
				DirPath = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Enter file name");
			String fileName = null;
			try {
				DirPath = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			File dir = new File(DirPath);
			File[] files1 = dir.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.equals(fileName);
				}
			});
			if(files1!=null && files1.length>0) {
				System.out.println("File Found" + files1[0].getAbsolutePath());
			}else {
				System.out.println("File Not Found");
			}break;
		case 5: System.out.println("out of Application! landed into mars..");
		        exit=true; break;
		default:
			System.out.println("invaild operatoin");
		}

	}
}
}