
import java.io.File;
import java.io.FileOutputStream;
public class ClientJavaCode{
/****** START SET/GET METHOD, DO NOT MODIFY *****/
	protected String fileName = "";
	protected byte[] fileContent = null;
	protected String fileSaveLocation = "";
	public String getfileName() {
		return fileName;
	}
	public void setfileName(String val) {
		fileName = val;
	}
	public byte[] getfileContent() {
		return fileContent;
	}
	public void setfileContent(byte[] val) {
		fileContent = val;
	}
	public String getfileSaveLocation() {
		return fileSaveLocation;
	}
	public void setfileSaveLocation(String val) {
		fileSaveLocation = val;
	}
/****** END SET/GET METHOD, DO NOT MODIFY *****/
	public ClientJavaCode() {
	}
	public void invoke() throws Exception {
/* Available Variables: DO NOT MODIFY
	In  : String fileName
	In  : byte[] fileContent
	In  : String fileSaveLocation
* Available Variables: DO NOT MODIFY *****/
      byte[] data = fileContent;
      File file = new File(fileSaveLocation+""+fileName);
      FileOutputStream fs = new FileOutputStream(file);
      fs.write(data, 0, data.length);
      fs.flush();
      fs.close();
}
}
