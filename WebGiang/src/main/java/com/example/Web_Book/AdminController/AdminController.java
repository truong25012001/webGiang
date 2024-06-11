package com.example.Web_Book.AdminController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.Web_Book.DAO.DAO;
import com.example.Web_Book.entity.Account;
import com.example.Web_Book.entity.Book;
import com.example.Web_Book.entity.Category;
import com.example.Web_Book.entity.OderLine;
import com.example.Web_Book.entity.Order;

@Controller
public class AdminController {

	@GetMapping(value = "/addBook")
	public String addBook(Model model) {
		DAO dao = new DAO();
		ArrayList<Category> listC = new ArrayList<>();
		listC = dao.getAllCategory(0);
		model.addAttribute("listC", listC);

		Book book = new Book();
		model.addAttribute("book", book);
		model.addAttribute("checkMethod", -1);

		return "/admin/formBook";
	}

	@GetMapping(value = "/ordered")
	public String addOrdered(HttpServletRequest request, Model model, HttpSession session) {
		DAO dao = new DAO();
		String oid = request.getParameter("oid");
		try {
			int o_id = Integer.parseInt(oid);
			dao.changeStatusOrderByIDForAdmin(o_id);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "redirect:/orderPending";
	}

	@GetMapping(value = "/orderPending")
	public String admin(HttpSession session, Model model, HttpServletRequest request) {
		DAO dao = new DAO();
		ArrayList<Order> list1 = new ArrayList<>();
		list1 = dao.getAllOrderStatusByAdmin(0);
		int page, numpage = 8;
		int num = (list1.size() % numpage == 0) ? list1.size() / numpage : list1.size() / numpage + 1;
		if (num == 0) {
			num = 1;
		}
		String str = request.getParameter("page");
		if (str == null) {
			page = 1;
		} else {
			page = Integer.parseInt(str);
		}
		if (page > num) {
			page = num;
		}
		int start, end;
		start = (page - 1) * numpage;
		end = Math.min(page * numpage, list1.size());
		ArrayList<Order> list = dao.getListOrderByPage(list1, start, end);
		ArrayList<Integer> numlist = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			numlist.add(i + 1);
		}
		model.addAttribute("listO", list);
		model.addAttribute("page", page);
		model.addAttribute("numlist", numlist);

		return "/admin/orderPending";
	}

	@GetMapping(value = "/admin")
	public String admin(HttpSession session, Model model, HttpServletRequest request,
			@CookieValue(value = "c_user", defaultValue = "") String user,
			@CookieValue(value = "c_pass", defaultValue = "") String pass,
			@CookieValue(value = "c_rm", defaultValue = "0") String rm) {
		DAO dao = new DAO();
		ArrayList<Book> list1 = new ArrayList<>();
		list1 = dao.getAllBookForAdmin();
		ArrayList<Order> listO = new ArrayList<>();
		listO = dao.getAllOrderStatusByAdmin(0);
		session.setAttribute("quantity", listO.size());

		Account ac = (Account) session.getAttribute("accountAdmin");
		int page = 1, numpage = 8;
		if (ac == null) {
			numpage = 11;
		}
		int num = (list1.size() % numpage == 0) ? list1.size() / numpage : list1.size() / numpage + 1;
		String str = null;
		Integer indexDeleteBook = (Integer) session.getAttribute("bookIndex");
		Integer indexAddBook = (Integer) session.getAttribute("indexAddBook");
		if (indexDeleteBook != null) {
			page = (indexDeleteBook % numpage == 0) ? indexDeleteBook / numpage : indexDeleteBook / numpage + 1;
			session.removeAttribute("bookIndex");
		} else if (indexAddBook != null) {
			page = (indexAddBook % numpage == 0) ? indexAddBook / numpage : indexAddBook / numpage + 1;
			session.removeAttribute("indexAddBook");
		} else {
			str = request.getParameter("page");
			if (str == null) {
				page = 1;
			} else {
				page = Integer.parseInt(str);
			}
		}
		if (page > num) {
			page = num;
		}
		int start, end;
		start = (page - 1) * numpage;
		end = Math.min(page * numpage, list1.size());
		ArrayList<Book> list = dao.getListByPage(list1, start, end);
		ArrayList<Integer> numlist = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			numlist.add(i + 1);
		}
		model.addAttribute("listS", list);
		model.addAttribute("page", page);
		model.addAttribute("numlist", numlist);
		model.addAttribute("username", user);
		model.addAttribute("password", pass);
		model.addAttribute("rm", Integer.parseInt(rm));

		return "/admin/ManageBook";
	}

	@GetMapping(value = "/deleteBookByAdmin")
	public String deleteBook(HttpServletRequest request, Model model, HttpSession session) {
		String id = request.getParameter("bid");
		String index = request.getParameter("stt");
		DAO dao = new DAO();
		int stt = 0;
		try {
			int bid = Integer.parseInt(id);
			stt = Integer.parseInt(index);
			dao.deleteBookById(bid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		session.setAttribute("bookIndex", stt);
		return "redirect:/admin";
	}

	@GetMapping(value = "/deleteOrderbyAdmin")
	public String deleteOrder(HttpServletRequest request, Model model, HttpSession session) {
		DAO dao = new DAO();
		String oid = request.getParameter("oid");
		try {
			int o_id = Integer.parseInt(oid);
			dao.detleteOrderLineByOid(o_id);
			dao.detleteOrderHistory(o_id);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "redirect:/orderPending";
	}

	@GetMapping(value = "/viewBook")
	public String editBook(Model model, HttpServletRequest request) {
		DAO dao = new DAO();
		String id = request.getParameter("bid");
		String c_id = request.getParameter("cid");
		int cid = 0;
		try {
			int bid = Integer.parseInt(id);
			cid = Integer.parseInt(c_id);
			Book book = dao.getBookById(bid);
			model.addAttribute("book", book);
		} catch (Exception e) {
			// TODO: handle exception
		}
		ArrayList<Category> listC = new ArrayList<>();
		listC = dao.getAllCategoryExcpet(cid);
		model.addAttribute("listC", listC);
		model.addAttribute("checkMethod", 1);

		return "/admin/formBook";
	}

	@GetMapping(value = "/findBook")
	public String findBook(HttpServletRequest request, Model model, HttpSession session) {
		String word = request.getParameter("keyword");
		DAO dao = new DAO();
		ArrayList<Book> list1 = new ArrayList<>();
		if (word != null) {
			session.setAttribute("keyWord", word);
		}
		list1 = dao.getAllBookForAdminBySearch((String) session.getAttribute("keyWord"));
		int page, numpage = 8;
		int num = (list1.size() % numpage == 0) ? list1.size() / numpage : list1.size() / numpage + 1;
		if (num == 0) {
			num = 1;
		}
		String str = request.getParameter("page");
		if (str == null) {
			page = 1;
		} else {
			page = Integer.parseInt(str);
		}
		if (page > num) {
			page = num;
		}
		int start, end;
		start = (page - 1) * numpage;
		end = Math.min(page * numpage, list1.size());
		ArrayList<Book> list = dao.getListByPage(list1, start, end);
		ArrayList<Integer> numlist = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			numlist.add(i + 1);
		}
		model.addAttribute("listS", list);
		model.addAttribute("page", page);
		model.addAttribute("numlist", numlist);
		return "/admin/searchBook";
	}

	@GetMapping(value = "/findOrderPending")
	public String findOrder(HttpServletRequest request, Model model, HttpSession session) {
		String word = request.getParameter("keyWordOrderPending");
		DAO dao = new DAO();
		if (word != null) {
			session.setAttribute("keyWordOrderPending", word);
		}
		ArrayList<Order> list1 = dao.getAllOrderBySearch(0, (String) session.getAttribute("keyWordOrderPending"));
		int page, numpage = 8;
		int num = (list1.size() % numpage == 0) ? list1.size() / numpage : list1.size() / numpage + 1;
		if (num == 0) {
			num = 1;
		}
		String str = request.getParameter("page");
		if (str == null) {
			page = 1;
		} else {
			page = Integer.parseInt(str);
		}
		if (page > num) {
			page = num;
		}
		int start, end;
		start = (page - 1) * numpage;
		end = Math.min(page * numpage, list1.size());
		ArrayList<Order> list = dao.getListOrderByPage(list1, start, end);
		ArrayList<Integer> numlist = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			numlist.add(i + 1);
		}
		model.addAttribute("listO", list);
		model.addAttribute("page", page);
		model.addAttribute("numlist", numlist);
		return "/admin/searchOrderPending";
	}

	@GetMapping(value = "/findOrdered")
	public String findOrdered(HttpServletRequest request, Model model, HttpSession session) {
		String word = request.getParameter("keyWordOrdered");
		DAO dao = new DAO();
		if (word != null) {
			session.setAttribute("keyWordOrdered", word);
		}
		ArrayList<Order> list1 = dao.getAllOrderBySearch(1, (String) session.getAttribute("keyWordOrdered"));
		int page, numpage = 8;
		int num = (list1.size() % numpage == 0) ? list1.size() / numpage : list1.size() / numpage + 1;
		if (num == 0) {
			num = 1;
		}
		String str = request.getParameter("page");
		if (str == null) {
			page = 1;
		} else {
			page = Integer.parseInt(str);
		}
		if (page > num) {
			page = num;
		}
		int start, end;
		start = (page - 1) * numpage;
		end = Math.min(page * numpage, list1.size());
		ArrayList<Order> list = dao.getListOrderByPage(list1, start, end);
		ArrayList<Integer> numlist = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			numlist.add(i + 1);
		}
		model.addAttribute("listO", list);
		model.addAttribute("page", page);
		model.addAttribute("numlist", numlist);
		return "/admin/searchOrdered";
	}

	@PostMapping(value = "/loginAdmin")
	public String loginAdmin(HttpServletRequest req, HttpServletResponse res, Model model, HttpSession session) {
		String name = req.getParameter("user");
		String pass = req.getParameter("pass");
		String remember = req.getParameter("remember");

		// Tạo cookies
		Cookie cook_user = new Cookie("c_user", name);
		Cookie cook_pass = new Cookie("c_pass", pass);
		Cookie cook_remember = new Cookie("c_rm", remember);
		if (remember != null) {
			cook_user.setMaxAge(60 * 60 * 24 * 7);
			cook_pass.setMaxAge(60 * 60 * 24 * 7);
			cook_remember.setMaxAge(60 * 60 * 24 * 7);
		} else {
			cook_user.setMaxAge(0);
			cook_pass.setMaxAge(0);
			cook_remember.setMaxAge(0);
		}
		res.addCookie(cook_user);
		res.addCookie(cook_pass);
		res.addCookie(cook_remember);

		// Khởi tạo session Account
		DAO dao = new DAO();
		Account ac = dao.getAccount(name, pass);
		if (ac == null || ac.getDuty() != 1) {
			session.setAttribute("messAdmin", "Sai tài khoản hoặc mật khẩu");
		} else {
			session.setAttribute("accountAdmin", ac);
			session.removeAttribute("messAdmin");
		}
		session.removeAttribute("checkLoginAdmin");
		return "redirect:/admin";
	}

	@GetMapping(value = "/logoutAdmin")
	public String logout(HttpSession session) {
		session.removeAttribute("accountAdmin");
		session.removeAttribute("mess");

		return "redirect:/admin";
	}

	@GetMapping(value = "/noLoginAdmin")
	public String noLogin(HttpServletRequest request, Model model, HttpSession session) {
		session.setAttribute("checkLoginAdmin", 1);
		session.removeAttribute("messAdmin");
		return "redirect:/admin";
	}

	@GetMapping(value = "/orderPendingDetail")
	public String orderDetail(HttpServletRequest request, Model model, HttpSession session) {
		DAO dao = new DAO();
		String id = request.getParameter("oid");
		ArrayList<OderLine> listO = new ArrayList<>();
		try {
			int oid = Integer.parseInt(id);
			listO = dao.getAllOrderLineByOid(oid);

		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("listO", listO);
		return "/admin/OrderDetailPending";
	}

	@GetMapping(value = "/orderedDetail")
	public String orderedDetail(HttpServletRequest request, Model model, HttpSession session) {
		DAO dao = new DAO();
		String id = request.getParameter("oid");
		ArrayList<OderLine> listO = new ArrayList<>();
		try {
			int oid = Integer.parseInt(id);
			listO = dao.getAllOrderLineByOid(oid);

		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("listO", listO);
		return "/admin/OrderedDetail";
	}

	@GetMapping(value = "/orderedList")
	public String orderedList(HttpSession session, Model model, HttpServletRequest request) {
		DAO dao = new DAO();
		ArrayList<Order> list1 = new ArrayList<>();
		list1 = dao.getAllOrderStatusByAdmin(1);
		int page, numpage = 8;
		int num = (list1.size() % numpage == 0) ? list1.size() / numpage : list1.size() / numpage + 1;
		if (num == 0) {
			num = 1;
		}
		String str = request.getParameter("page");
		if (str == null) {
			page = 1;
		} else {
			page = Integer.parseInt(str);
		}
		if (page > num) {
			page = num;
		}
		int start, end;
		start = (page - 1) * numpage;
		end = Math.min(page * numpage, list1.size());
		ArrayList<Order> list = dao.getListOrderByPage(list1, start, end);
		ArrayList<Integer> numlist = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			numlist.add(i + 1);
		}
		model.addAttribute("listO", list);
		model.addAttribute("page", page);
		model.addAttribute("numlist", numlist);

		return "/admin/orderedlist";
	}

	@PostMapping(value = "/saveBook/{id}")
	public String saveBook(@ModelAttribute("book") Book book, Model model,
			@RequestParam("photo") MultipartFile multipartFile, HttpSession session) throws IOException {
		DAO dao = new DAO();
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		if (!fileName.equals("")) {
			String uploadDir = "uploads/";
			dao.saveFile(uploadDir, fileName, multipartFile);
			book.setImage(fileName);
		}
		if (dao.checkBookExists(book.getTitle(), book.getAuthor()) == 1) {
			ArrayList<Category> listC = new ArrayList<>();
			listC = dao.getAllCategoryExcpet(book.getCid());
			model.addAttribute("listC", listC);
			model.addAttribute("checkC", 1);
			model.addAttribute("book", book);
			model.addAttribute("checkBook", "Sách đã tồn tại");
			model.addAttribute("checkMethod", -1);
			return "/admin/formBook";
		}
		dao.insertBook(book);
		ArrayList<Book> list = new ArrayList<>();
		list = dao.getAllBook();
		session.setAttribute("indexAddBook", list.size());

		return "redirect:/admin";
	}

	@PutMapping(value = "/saveBook/{id}")
	public String upDateBook(@ModelAttribute("book") Book book, Model model, @PathVariable int id,
			@RequestParam("photo") MultipartFile multipartFile, HttpSession session) throws IOException {
		DAO dao = new DAO();
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		if (!fileName.equals("")) {
			String uploadDir = "uploads/";
			dao.saveFile(uploadDir, fileName, multipartFile);
			book.setImage(fileName);
		}

		if (dao.checkBookExistsforEdit(book.getTitle(), book.getAuthor(), book.getId()) == 1) {
			ArrayList<Category> listC = new ArrayList<>();
			listC = dao.getAllCategoryExcpet(book.getCid());
			model.addAttribute("listC", listC);
			model.addAttribute("checkC", 1);
			model.addAttribute("book", book);
			model.addAttribute("checkBook", "Sách đã tồn tại");
			model.addAttribute("checkMethod", 1);
			model.addAttribute("checkEdit", 1);
			return "/admin/formBook";
		}
		dao.updateBook(book, book.getId());
		int count = dao.getQuantityBookAtUnderById(id);
		session.setAttribute("indexAddBook", count);

		return "redirect:/admin";
	}
}
