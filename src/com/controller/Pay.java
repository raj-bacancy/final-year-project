package com.controller;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Pay
 */
@WebServlet("/Pay")
public class Pay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse responses) throws ServletException, IOException {
		
	}
	
	
	
	private void pay(String token) throws Exception {
		String SecretKey="sk_test_51IKcX5JvMhB28Qnk9fMHc1ws88pz34plPnwmGccDPSu9hvo7BHzCeTPaPDUdBWWQY9nwdSJiIh42JzeZLGcnkyeH00RLKjqlup";
		String url1 = "https://api.stripe.com/v1/charges";
		
		URL url = new URL(url1);
		URLConnection con = url.openConnection();
		HttpURLConnection http = (HttpURLConnection)con;
		http.setRequestMethod("POST"); // PUT is another valid option
		http.setDoOutput(true);
		http.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
		http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		http.setRequestProperty("Authorization","Bearer "+SecretKey);
		Map<String,String> arguments = new HashMap<>();
		arguments.put("amount", "700");
		arguments.put("currency", "inr");
		arguments.put("description", "Payment From HDMS");
		arguments.put("source", token);
		StringJoiner sj = new StringJoiner("&");
		for(Map.Entry<String,String> entry : arguments.entrySet())
		    sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" 
		         + URLEncoder.encode(entry.getValue(), "UTF-8"));
		byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
		int length = out.length;
		
		http.setFixedLengthStreamingMode(length);
		http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		http.connect();
		try(OutputStream os = http.getOutputStream()) {
		    os.write(out);
		}catch(Exception e){
			System.out.println("ERROR!!!"+e.getMessage());
		}
		BufferedReader in = new BufferedReader(
                new InputStreamReader(
                		http.getInputStream()));
    String inputLine;
    while ((inputLine = in.readLine()) != null){ 
      System.out.println(inputLine);
      
    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String CardNumber=request.getParameter("cardnumber");
        String mon=request.getParameter("expmonth");
        String year=request.getParameter("expyear");
        String CVC=request.getParameter("cvc");
        String amount=request.getParameter("amount");
        System.out.println("cardnumber = "+CardNumber);
        System.out.println("mon = "+mon);
        System.out.println("year = "+year);
        System.out.println("amount = "+amount);
        System.out.println("CVC = "+CVC);
		/*String SecretKey="sk_test_51IKcX5JvMhB28Qnk9fMHc1ws88pz34plPnwmGccDPSu9hvo7BHzCeTPaPDUdBWWQY9nwdSJiIh42JzeZLGcnkyeH00RLKjqlup";
        String CardNumber="4242424242424242";
        String mon="2";
        String year="2023";
        String CVC="123";
		String url1 = "https://api.stripe.com/v1/tokens";
		URL url = new URL(url1);
		URLConnection con = url.openConnection();
		HttpURLConnection http = (HttpURLConnection)con;
		http.setRequestMethod("POST"); // PUT is another valid option
		http.setDoOutput(true);
		http.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
		http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		http.setRequestProperty("Authorization","Bearer "+SecretKey);
		Map<String,String> arguments = new HashMap<>();
		arguments.put("card[number]", CardNumber);
		arguments.put("card[exp_month]", mon);
		arguments.put("card[exp_year]", year);
		arguments.put("card[cvc]", CVC);
		StringJoiner sj = new StringJoiner("&");
		for(Map.Entry<String,String> entry : arguments.entrySet())
		    sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" 
		         + URLEncoder.encode(entry.getValue(), "UTF-8"));
		byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
		int length = out.length;
		
		http.setFixedLengthStreamingMode(length);
		http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		http.connect();
		try(OutputStream os = http.getOutputStream()) {
		    os.write(out);
		}catch(Exception e){
			System.out.println("ERROR!!!"+e.getMessage());
		}
		BufferedReader in = new BufferedReader(
                new InputStreamReader(
                		http.getInputStream()));
    String inputLine;
    String Token = null;
    int i=1;
    while ((inputLine = in.readLine()) != null){ 
      System.out.println(inputLine);
      if(i==2){
    	 Token=inputLine.substring(9,(inputLine.length()-2));
    	 break;
      }
      i++;
    }
    in.close();
    System.out.println("Token  = = = "+Token);
    if(Token!=null){
    	try {
			pay(Token);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }*/
	}

}
