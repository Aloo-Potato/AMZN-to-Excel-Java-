import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Data;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;

public class GoogleAuthentication {
	
//    private static HttpTransport transport;
//    private static JacksonFactory jsonFactory;
//    private static FileDataStoreFactory dataStoreFactory;
//    private static List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS);
//
//	
//	public static Credential authorize() throws IOException 
//	{
//	    // Load client secrets.
//	    File cfile = new File("C:\\Users\\email\\eclipse-workspace\\AMZNtoHH\\credentials.json");
//	    cfile.createNewFile();
//	    GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory, new InputStreamReader(new FileInputStream(cfile)));
//
//	    // Build flow and trigger user authorization request.
//	    GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(transport, jsonFactory, clientSecrets, scopes).setDataStoreFactory(dataStoreFactory).setAccessType("offline").build();
//	    Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
//	    return credential;
//	}
//
//	public static Sheets getSheetsService() throws IOException 
//	{
//	    Credential credential = authorize();
//	    return new Sheets.Builder(transport, jsonFactory, credential).setApplicationName("INSERT_YOUR_APPLICATION_NAME").build();
//	}
//
//	public void write(List<Data> myData) {
//
//	    try {
//	        String id = "INSERT_SHEET_ID";
//	        String writeRange = "INSERT_SHEET_NAME!A3:E";
//
//	        List<List<Object>> writeData = new ArrayList<List<Object>>();
//	        for (Data someData: myData) 
//	        {
//	            List<Object> dataRow = new ArrayList<Object>();
//	            dataRow.add(someData.data1);
//	            writeData.add(dataRow);
//	        }
//
//	        ValueRange vr = new ValueRange().setValues(writeData).setMajorDimension("ROWS");
//	        service.spreadsheets().values().update(id, writeRange, vr).setValueInputOption("RAW").execute();
//	    } catch (Exception e) {
//	        // handle exception
//	    }
//	}
//	
//
//    public SheetsIntegration() {
//        try {
//            transport = GoogleNetHttpTransport.newTrustedTransport();
//            dataStoreFactory = new FileDataStoreFactory(DATA_STORE_DIR);
//            jsonFactory = JacksonFactory.getDefaultInstance();
//
//            service = getSheetsService();
//        } catch (Exception e) {
//            // handle exception
//        }
//    }

}
