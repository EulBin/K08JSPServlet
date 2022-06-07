package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//서블릿 생성을 위해 첫번째로 HttpServlet을 상속시킨다.
public class DirectServletPrint extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//서블릿에서 직접 HTML태그를 출력하기위해 문서의 컨텐츠 타입을 설정한다.
		resp.setContentType("text/html;charset=UTF-8");
		//직접 출력을 위해 PrintWriter객체를 생성한다.
		PrintWriter writer = resp.getWriter();
		//출력할 내용을 기술한다.
		writer.println("<html>");
		writer.println("<head><title>DirectServletPrint</title></head>");
		writer.println("<body>");
		writer.println("<h2>서블릿에서 직접 출력합니다.</h2>");
		writer.println("<p>jsp로 포워드 하지 않습니다</p>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
	}
}
