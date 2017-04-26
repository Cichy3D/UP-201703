package pl.expose.up201703.wiki;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Wiki extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String, String> pagesMap = new TreeMap<>();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		String contextPath = request.getContextPath();
		boolean doList = !request.getParameterMap().containsKey("page");
		String page = request.getParameter("page");
		boolean doEdit = request.getParameterMap().containsKey("edit");
		
		
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("    <meta charset='utf-8'>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("   <a href='"+contextPath+"/'>Home</a><br/>");
		
		if(doList){
			//nie podano strony
			out.println("<ul>");
			pagesMap.keySet().forEach(p -> out.println("   <li><a href='"+contextPath+"/?page="+p+"'>"+p+"</a></li>"));
			out.println("</ul>");
		} else {
			//podano stronê
			if(doEdit){
				// tryb edycji
				out.println("    <FORM action='"+contextPath+"/' method='POST'>");
				out.println("            <INPUT type='hidden' name='page' value='"+page+"'/>");
				if(pagesMap.containsKey(page)){
					out.println("            <textarea rows='20' cols='80' name='content'>"+pagesMap.get(page)+"</textarea>");
				} else {
					out.println("            <textarea rows='20' cols='80' name='content' placeholder='put content here'></textarea>");
				}
				out.println("            <br/><INPUT type='submit' />");
				out.println("    </FORM>");
			} else {
				// tryb odczytu
				if(pagesMap.containsKey(page)){
					// jest ju¿ strona
					String tresc = pagesMap.get(page);
					String[] linie = tresc.split("\n");
					for (String linia : linie) {
						linia = linia.replaceAll("\\[\\[([a-zA-Z0-9_]+)\\]\\]", "<a href='"+contextPath+"/?page=$1'>$1</a>");
						out.println("   "+linia+"<br/>");
					}
					out.println("   <a href='"+contextPath+"/?page="+page+"&edit'>Edit</a>");
				} else {
					response.sendRedirect(contextPath+"/?page="+page+"&edit");
				}
			}
		}
		
		out.println("</BODY>");
		out.println("</HTML>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page    = request.getParameter("page");
		String content = request.getParameter("content");
		pagesMap.put(page, content);
		response.sendRedirect(request.getContextPath()+"/?page="+page);
	}

}
