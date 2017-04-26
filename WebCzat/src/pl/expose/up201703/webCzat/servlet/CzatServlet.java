package pl.expose.up201703.webCzat.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.expose.up201703.webCzat.model.ChatMessage;

@WebServlet({ "/CzatServlet", "/" })
public class CzatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final LinkedList<ChatMessage> messageList = new LinkedList<>();   
    private static final DateFormat df = new SimpleDateFormat("HH:mm:ss");
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		System.out.println("Wywo³anie GET");
		String name = (String) request.getSession().getAttribute("userName");
		
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("    <meta charset='utf-8'>");
		out.println("</HEAD>");
		
		out.println("<BODY>");
		out.println("    <P>");
		out.println("        <FORM action='"+request.getContextPath()+"/' method='POST'>");
		if(name!=null && !"".equals(name)){
			out.println("            <INPUT type='text' name='userName' value='"+name+"'/>");
		} else {
			out.println("            <INPUT type='text' name='userName' placeholder='user name here'/>");
		}
		out.println("            <INPUT type='text' name='message' placeholder='message here' autofocus/>");
		out.println("            <INPUT type='submit' />");
		out.println("        </FORM>");
		out.println("    </P>");
		
		out.println("    <P>");
		out.println("       <TABLE>");
		out.println("          <THEAD><TR><TD>Time</TD><TD>User</TD><TD>Message</TD></TR></THEAD>");
		out.println("          <TBODY>");
		
		messageList.forEach(m ->
			out.println("<TR><TD>"
					+df.format(m.getDate())+"</TD><TD>"
					+m.getUserName()+"</TD><TD>"
					+m.getMessage()+"</TD></TR>")
		);
		
		out.println("          </TBODY>");
		out.println("       </TABLE>");
		out.println("    </P>");
		
		out.println("</BODY>");
		out.println("</HTML>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		System.out.println("Wywo³anie POST");
		System.out.println("path: "+request.getContextPath());
		String name = request.getParameter("userName");
		String message = request.getParameter("message");
		System.out.println(name+": "+message);
		request.getSession().setAttribute("userName", name);
		
		ChatMessage chatMessage = new ChatMessage(name, message);
		messageList.addFirst(chatMessage);
		
		response.sendRedirect(request.getContextPath()+"/");
	}

}
