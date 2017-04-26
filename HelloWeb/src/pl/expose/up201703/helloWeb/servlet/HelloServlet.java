package pl.expose.up201703.helloWeb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		System.out.println("Wyœwietlam Stronê");
		
		System.out.println("QueryString: "+request.getQueryString());
//		Enumeration<String> attrs = request.getParameterNames();
//		System.out.println("Atrybuty");
//		while(attrs.hasMoreElements()) {
//			String name = attrs.nextElement();
//			String value = "" + request.getParameter(name);
//			System.out.println("Nazwa:" + name + ", wartoœæ: "+value);
//		}
		request.getParameterMap()
			.forEach( (k,v)->System.out.println("Nazwa:" + k + ", wartoœæ: "+Arrays.asList(v)) );
		
		String addr = request.getRemoteHost();
		System.out.println(addr);
		
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		if(cookies!=null && cookies.length>0
				&& "user".equals(cookies[0].getName()) && "id_sessji".equals(cookies[0].getValue())){
			out.println("Witaj ponownie!");
		}
		
		if("192.168.5.204".equals(addr)){
			out.println("Buuu");
		} else {
			out.println("Czas Serwera: "+df.format(new Date()));
		}
		
		Cookie cookie = new Cookie("user", "id_sessji");
		cookie.setMaxAge(60);
		response.addCookie(cookie);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		System.out.println("Wywo³ano POST");
		while(request.getReader().ready()){
			System.out.println(request.getReader().readLine());
		}
		
		doGet(request, response);
	}

}
