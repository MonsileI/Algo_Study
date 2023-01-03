package December_fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;


public class ApiTest {
	
	static String nextUrl = "alpha";
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			if(flag) break;
			String nickname = br.readLine();
			String yourAnswer = br.readLine();
			//정답 제출을 위한 map
			Map<String, String> resultMap = new HashMap();
			resultMap.put("nickname", nickname);
			resultMap.put("yourAnswer", yourAnswer);
			ObjectMapper mapper = new ObjectMapper();
	
			try {
				String json = mapper.writeValueAsString(resultMap);
			    String msgMap = "";
			    //JSON 송출
			    msgMap = sendREST("http://13.125.222.176/quiz/"+nextUrl, json);	
				
			    System.out.println(msgMap);
	
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		
	}

	 public static String sendREST(String sendUrl, String json) throws IllegalStateException {
	        String inputLine = null;
	        StringBuffer outResult = new StringBuffer();
	        
	        try {
	            System.out.println("REST API Start");
	            URL url = new URL(sendUrl);
	            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	            conn.setDoOutput(true);
	            conn.setRequestMethod("POST");  //제출 방식은 무조건 POST
	            conn.setRequestProperty("Content-Type", "application/json"); //json방식
	            conn.setRequestProperty("Accept-Charset", "UTF-8"); //인코딩
	            conn.setConnectTimeout(10000); //커넥션 타임아웃 걸기
	            conn.setReadTimeout(10000); //read 타임아웃 걸기
	           
	            
	            OutputStream os = conn.getOutputStream();
	            os.write(json.getBytes("UTF-8"));
	            os.flush();
	            
	            // 리턴된 결과 읽기
	            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	            while ((inputLine = in.readLine()) != null) {
	                outResult.append(inputLine);
	            }
	            
	            conn.disconnect();
	            System.out.println("REST API End");
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
	        //200요청이 아닌 경우, 통신 종료
	        if(!outResult.toString().split(":")[1].replaceAll("[^0-9]", "").equals("200")) {
	        	flag = true;
	        	return outResult.toString();
	        }
	        //다음 url 넣기
	        nextUrl = outResult.toString().split(":")[4].replaceAll("\"", "").replaceAll("}", "");
	        return outResult.toString();
	    }
	
}

