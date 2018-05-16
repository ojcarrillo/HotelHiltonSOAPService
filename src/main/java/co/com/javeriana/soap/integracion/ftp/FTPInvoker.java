package co.com.javeriana.soap.integracion.ftp;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FTPInvoker {

	static String server = "localhost";
	static Integer port = 3021;
	static String user = "touresbalon";
	static String pass = "verysecretpwd";

	public static boolean uploadFile(File file, String filenameServer) {
		boolean success = false;
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.connect(server, port);
			ftpClient.login(user, pass);
			ftpClient.enterLocalPassiveMode();
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

			InputStream inputStream = new FileInputStream(file);
			System.out.println("Start uploading first file");
			success = ftpClient.storeFile(filenameServer, inputStream);
			inputStream.close();
			if (success) {
				System.out.println("The first file is uploaded successfully.");
			}
		} catch (IOException ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return success;
	}

	public static File downloadFile(String filenameServer, String filenameLocal) {
		boolean success = false;
		FTPClient ftpClient = new FTPClient();
		File file = new File(filenameLocal);
		try {

			int retry = 0;
			do {
				ftpClient.connect(server, port);
				ftpClient.login(user, pass);
				ftpClient.enterLocalPassiveMode();
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				ftpClient.setBufferSize(1024 * 1024);

				OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(file));
				success = ftpClient.retrieveFile(filenameServer, outputStream1);
				outputStream1.flush();
				outputStream1.close();
				if (file.length() == 0L) {
					retry++;
					ftpClient.logout();
					ftpClient.disconnect();
					Thread.sleep(1000);
				} else {
					retry = 6;
				}
			} while (retry < 5);
			if (retry == 5) {
				throw new Exception("NUMERO DE INTENTOS FALLIDOS SUPERADOS");
			}
			if (success) {
				System.out.println("File #1 has been downloaded successfully.");
			}
		} catch (IOException ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return file;
	}

	public static File createFile(String filename, String ext, String datos) {
		try {
			File queryFile = File.createTempFile(filename, ext);
			Charset charset = Charset.forName("UTF8");
			Files.write(Paths.get(queryFile.getAbsolutePath()), datos.getBytes(), StandardOpenOption.APPEND);
			return queryFile;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getStringFromFile(File file) {
		String texto = "";
		if (file != null) {
			try {
				BufferedReader readFile = new BufferedReader(new FileReader(file));
				texto = readFile.readLine();
				readFile.close();
				Files.deleteIfExists(file.toPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return texto;
	}
}
