import java.net.*;
import java.io.*;
public class ReadPdf {
    public static void main(String[] args) throws Exception {
	 new ReadPdf().invoke();
	
	}
		public void invoke() throws IOException{
		byte[] ba1 = new byte[1024];
		int baLength;
		FileOutputStream fos1 = new FileOutputStream("O-12864_3799_14977_1655466621251Final_OfferToSend.pdf");

        URL url = new URL("https://zwayamfilestorageaccount.blob.core.windows.net/bgv/O-12864_3799_14977_1655466621251Final_OfferToSend.pdf?sv=2020-10-02&st=2022-06-28T05%3A57%3A55Z&se=2022-10-26T06%3A31%3A15Z&sr=b&sp=r&sig=AhYEI3%2BSkaA%2Fi%2FgFnfZIQ%2FgCgGKPtUYfnv13VWk2%2F1g%3D");
        BufferedReader re = new BufferedReader(
        new InputStreamReader(url.openStream()));
		
		 while ((baLength = re.read()) != -1) {
              fos1.write(ba1, 0, baLength);
          }
          fos1.flush();
          fos1.close();
		  re.close();

    }
	
}