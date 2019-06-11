package text_converter;

import java.io.*;

public class HtmlTextConverter
{
    private String fileName;

    public HtmlTextConverter(String fullFilenameWithPath)
    {
        this.fileName = fullFilenameWithPath;
    }

    public void convertToHtml(String htmlFile) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(htmlFile));
	    BufferedReader reader = new BufferedReader(new FileReader(fileName));
	    
	    String line = reader.readLine();
		writer.write("<body>");
	    while (line != null)
	    {
			String output = line;
			output = output.replace("&", "&amp;");
			output = output.replace("<", "&lt;");
			output = output.replace(">", "&gt;");
			writer.write(output);
			writer.write("<br />");
	        line = reader.readLine();
	    }
		writer.write("</body>");
		writer.close();
    }

	public String getFilename() {
		return this.fileName;
	}

	public static void main(String[] args) {
		try {
			HtmlTextConverter htmlTextConverter = new HtmlTextConverter("res/example.txt");
			htmlTextConverter.convertToHtml("res/example.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
