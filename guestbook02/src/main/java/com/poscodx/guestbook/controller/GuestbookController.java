package com.poscodx.guestbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.guestbook.dao.GuestBookDao;
import com.poscodx.guestbook.vo.GuestBookVo;

public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("a"); // action 제어

		if ("add".equals(action)) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String contents = request.getParameter("message");

			GuestBookVo vo = new GuestBookVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setContents(contents);

			new GuestBookDao().insert(vo);

			response.sendRedirect("/guestbook02/gb");

		} else if ("deleteForm".equals(action)) {
			Long no = (Long) request.getAttribute("no");
			
			request.setAttribute("no", no);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			rd.forward(request, response);
		} else if ("delete".equals(action)) {
			request.setCharacterEncoding("utf-8");

			Long no = Long.parseLong(request.getParameter("no"));
			String password = request.getParameter("password");

			new GuestBookDao().deleteByNo(no, password);

			response.sendRedirect("/guestbook02/gb");
		} else {
			List<GuestBookVo> list = new GuestBookDao().findAll();

			request.setAttribute("list", list);

			for (GuestBookVo vo : list) {
				System.out.println(vo);
			}

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp"); // dispatcher요청 후 어디로 보내는지.
			rd.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
