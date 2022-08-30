import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.io.File;


public class ReadURL{
	protected String output="";
	protected String inputUrl="";
	protected String filePath="";
	
	public String getInputUrl() {
		return inputUrl;
	}

	public void setInputUrl(String inputUrl) {
		this.inputUrl = inputUrl;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}
	
	public void getData() throws IOException {
		 
System.out.println("opening connection");
URL url = new URL(inputUrl);
InputStream in = url.openStream();
String filename= new File(url.getPath()).getName();
String FullName=filePath+filename;
FileOutputStream fos = new FileOutputStream(new File(FullName));

System.out.println("reading from resource and writing to file...");
int length = -1;
byte[] buffer = new byte[1024];// buffer for portion of data from connection
while ((length = in.read(buffer)) > -1) {
    fos.write(buffer, 0, length);
    
}




//String newFileName = "test.pdf";

byte[] input_file = Files.readAllBytes(Paths.get(FullName));

byte[] encodedBytes = Base64.getEncoder().encode(input_file);
String encodedString =  new String(encodedBytes);
//byte[] decodedBytes = Base64.getDecoder().decode(encodedString.getBytes());

//FileOutputStream fos1 = new FileOutputStream(filePath+newFileName);
//fos.write(decodedBytes);
output=encodedString;
//fos1.flush();
//fos1.close();
fos.close();
in.close();
System.out.println("File downloaded");
		
	}
	
	
}

