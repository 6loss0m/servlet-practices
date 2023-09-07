package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");	//	header 시작
		PrintWriter pw = response.getWriter();	// body 시작
		/*
		 * ServletContext = Application
		 * SErvletPath = classpath 
		 * getWriter는 빈 개행'\n'을 보내고 printWriter 제공.
		 * 그 이후로 보내는 것들은 content로 인식
		 * -> 위의 코드 순서 바꾸면 한글 깨짐.
		 * servlet 코드 수정 이후 eclipse가 알아서 Hot Swap 해줌. web.xml은 안함.
		 */
		String name = request.getParameter("name");
		pw.print("Hello "+name);	// 알아서 html로 보내짐
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
