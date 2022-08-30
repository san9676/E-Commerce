import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;

import com.gnostice.pdfone.PdfDocument;


public class Read_PDF_From_URL {

  public static void main(String[] args) throws IOException {
  
  new Read_PDF_From_URL().invoke();
  
	}
	public void invoke() throws IOException{
    URL url1 =
      new URL("https://zwayamfilestorageaccount.blob.core.windows.net/bgv/O-12864_3799_14977_1655466621251Final_OfferToSend.pdf?sv=2020-10-02&st=2022-06-28T05%3A57%3A55Z&se=2022-10-26T06%3A31%3A15Z&sr=b&sp=r&sig=AhYEI3%2BSkaA%2Fi%2FgFnfZIQ%2FgCgGKPtUYfnv13VWk2%2F1g%3D");

    byte[] ba1 = new byte[1024];
    int baLength;
    FileOutputStream fos1 = new FileOutputStream("download.pdf");

    try {
      // Contacting the URL
      System.out.print("Connecting to " + url1.toString() + " ... ");
      URLConnection urlConn = url1.openConnection();

      // Checking whether the URL contains a PDF
      if (!urlConn.getContentType().equalsIgnoreCase("application/pdf")) {
          System.out.println("FAILED.\n[Sorry. This is not a PDF.]");
      } else {
        try {

          // Read the PDF from the URL and save to a local file
          InputStream is1 = url1.openStream();
          while ((baLength = is1.read(ba1)) != -1) {
              fos1.write(ba1, 0, baLength);
          }
          fos1.flush();
          fos1.close();
          is1.close();

          // Load the PDF document and display its page count
          System.out.print("DONE.\nProcessing the PDF ... ");
          PdfDocument doc = new PdfDocument();
          try {
            doc.load("download.pdf");
            System.out.println("DONE.\nNumber of pages in the PDF is " +
                               doc.getPageCount());
            doc.close();
          } catch (Exception e) {
            System.out.println("FAILED.\n[" + e.getMessage() + "]");
          }

        } catch (ConnectException ce) {
          System.out.println("FAILED.\n[" + ce.getMessage() + "]\n");
        }
      }

    } catch (NullPointerException npe) {
      System.out.println("FAILED.\n[" + npe.getMessage() + "]\n");
    }
	}
  
}