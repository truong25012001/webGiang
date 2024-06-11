package com.example.Web_Book.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.User;
import org.springframework.web.multipart.MultipartFile;

import com.example.Web_Book.entity.Account;
import com.example.Web_Book.entity.Book;
import com.example.Web_Book.entity.Category;
import com.example.Web_Book.entity.OrderLine;
import com.example.Web_Book.entity.Order;
import com.example.Web_Book.entity.Review;

public class DAO {
	public static void main(String[] args) {
		DAO dao = new DAO();
		dao.deleteBookById(116);
	}
	Connection conn = null;
	PreparedStatement ps = null;

	ResultSet rs = null;

	public void changeStatusOrderByID(int code) {
		String query = "update Order set status = -1 where id = ?";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, code);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public void changeStatusOrderByIDForAdmin(int code) {
		String query = "update [Order] set status = 1 where id = ?";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, code);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public int checkBookExists(String title, String author) {
		String query = "select * from Book where Book.title = ? and Book.author = ?";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, author);
			rs = ps.executeQuery();
			while (rs.next()) {
				return 1;
			}
		} catch (Exception e) {
		}
		return -1;
	}

	public int checkBookExistsforEdit(String title, String author, int bid) {
		String query = "select * from Book where Book.title = ? and Book.author = ? and Book.id != ?";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, author);
			ps.setInt(3, bid);
			rs = ps.executeQuery();
			while (rs.next()) {
				return 1;
			}
		} catch (Exception e) {
		}
		return -1;
	}

	public void deleteBookById(int bid) {
		String query = "delete Book where Book.id = ?";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, bid);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public void detleteOrderHistory(int code) {
		String query = "delete [Order]  where id = ?";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, code);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public void detleteOrderLineByOid(int oid) {
		String query = "delete [OrderLine] where OrderLine.oid = ?";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, oid);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public void detleteOrderLineByOidAndBid(int oid, int bid) {
		String query = "delete OrderLine where OrderLine.oid = ? and OrderLine.bid = ?";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, oid);
			ps.setInt(2, bid);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	// Get Account
	public Account getAccount(String user, String pass) {
		String query = "select*from [User] where [username] = ? and password = ?";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			if (rs.next()) {
				Account ac = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				return ac;
			}
		} catch (Exception e) {
		}
		return null;
	}

	public int getAccountByEmail(String mail) {
		String query = "select*from [User] where [email] = ?";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, mail);
			rs = ps.executeQuery();
			if (rs.next()) {
				return 1;
			}
		} catch (Exception e) {
		}
		return -1;
	}

	public int getAccountByUserName(String user) {
		String query = "select*from [User] where [username] = ?";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			rs = ps.executeQuery();
			if (rs.next()) {
				return 1;
			}
		} catch (Exception e) {
		}
		return -1;
	}

	public ArrayList<Book> getAllBook() {
		ArrayList<Book> list = new ArrayList<>();
		String query = "select * from Book";
		try {
			conn = new SQLConnection().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public ArrayList<Book> getAllBookByCid(int cid) {
		ArrayList<Book> list = new ArrayList<>();
		String query = "select * from Book where cid=?";
		try {
			conn = new SQLConnection().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public ArrayList<Book> getAllBookForAdmin() {
		ArrayList<Book> list = new ArrayList<>();
		String query = "select Book.id,Book.title,Book.author,Book.day,Book.page,Book.cid,Category.name,Book.sold \r\n"
				+ "from Book inner join Category on Book.cid = Category.id";
		try {
			conn = new SQLConnection().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			int stt = 1;
			while (rs.next()) {
				list.add(new Book(stt, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7), rs.getInt(8)));
				stt++;
			}
		} catch (Exception e) {
		}
		return list;
	}

	public ArrayList<Book> getAllBookForAdminBySearch(String str) {
		ArrayList<Book> list = new ArrayList<>();
		String query = "select Book.id,Book.title,Book.author,Book.day,Book.page,Book.cid,Category.name,Book.sold \r\n"
				+ "from Book inner join Category on Book.cid = Category.id and Book.title like ?";
		try {
			conn = new SQLConnection().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + str + "%");
			rs = ps.executeQuery();
			int stt = 1;
			while (rs.next()) {
				list.add(new Book(stt, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7), rs.getInt(8)));
				stt++;
			}
		} catch (Exception e) {
		}
		return list;
	}

	public ArrayList<Category> getAllCategory(int k) {
		ArrayList<Category> list = new ArrayList<>();
		String query = "select * from Category where Category.id != ?";
		try {
			conn = new SQLConnection().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, k);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Category(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public ArrayList<Category> getAllCategoryExcpet(int k) {
		DAO dao = new DAO();
		ArrayList<Category> list = new ArrayList<>();
		Category c = dao.getCategoryByCid(k);
		list.add(c);

		String query = "select * from Category where Category.id != ?";
		try {
			conn = new SQLConnection().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, k);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Category(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public ArrayList<Order> getAllOrderBySearch(int status, String username) {
		ArrayList<Order> list = new ArrayList<>();
		String query = "select Order.id,[User].username,Order.date,Order.quantity,Order.totalMoney,Order.status\r\n"
				+ "from Order inner join [User] on Order.uid = [User].id and Order.status = ? and [User].username like ?";
		try {
			conn = new SQLConnection().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, status);
			ps.setString(2, "%" + username + "%");
			rs = ps.executeQuery();
			int stt = 1;
			while (rs.next()) {
				list.add(new Order(stt, rs.getInt(1), rs.getString(2), String.valueOf(rs.getDate(3)), rs.getInt(4),
						rs.getInt(5), rs.getInt(6)));
				stt++;
			}
		} catch (Exception e) {
		}
		return list;
	}

	public ArrayList<Order> getAllOrderDeletedByUid(int uid) {
		ArrayList<Order> list = new ArrayList<>();
		String query = "select Order.id,Order.quantity,Order.date,Order.totalMoney,Order.status\r\n"
				+ "from Order where Order.uid = ? and Order.status = -1";
		try {
			conn = new SQLConnection().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Order(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public ArrayList<OrderLine> getAllOrderLineByOid(int oid) {
		ArrayList<OrderLine> list = new ArrayList<>();
		String query = "select [Order].id,Book.id, Book.image,Book.title,Book.author,Category.name,Book.price ,OrderLine.quantity,OrderLine.totalMoney\r\n"
				+ "from Book inner join Category on Book.cid = Category.id inner join\r\n"
				+ "OrderLine on Book.id = OrderLine.bid inner join [Order] on OrderLine.oid = [Order].id and oid = ?";
		try {
			conn = new SQLConnection().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, oid);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new OrderLine(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public ArrayList<Order> getAllOrderStatus0ByUid(int uid) {
		ArrayList<Order> list = new ArrayList<>();
		String query = "select id,quantity,date,totalMoney,status\r\n"
				+ "from [dbo].[Order] where uid = ? and status = 0";
		try {
			conn = new SQLConnection().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Order(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public ArrayList<Order> getAllOrderStatus1ByUid(int uid) {
		ArrayList<Order> list = new ArrayList<>();
		String query = "select [dbo].[Order].id,[dbo].[Order].quantity,[dbo].[Order].date,[dbo].[Order].totalMoney,[dbo].[Order].status\r\n"
				+ "from [dbo].[Order] where [dbo].[Order].uid = ? and [dbo].[Order].status = 1";
		try {
			conn = new SQLConnection().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Order(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public ArrayList<Order> getAllOrderStatusByAdmin(int status) {
		ArrayList<Order> list = new ArrayList<>();
		String query = "select [dbo].[Order].id,[User].username,[dbo].[Order].date,[dbo].[Order].quantity,[dbo].[Order].totalMoney,[dbo].[Order].status\r\n"
				+ "from [dbo].[Order] inner join [User] on [dbo].[Order].uid = [User].id and [dbo].[Order].status = ?";
		try {
			conn = new SQLConnection().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, status);
			rs = ps.executeQuery();
			int stt = 1;
			while (rs.next()) {
				list.add(new Order(stt, rs.getInt(1), rs.getString(2), String.valueOf(rs.getDate(3)), rs.getInt(4),
						rs.getInt(5), rs.getInt(6)));
				stt++;
			}
		} catch (Exception e) {
		}
		return list;
	}

	public Book getBookById(int id) {
		String query = "select Book.id,Book.title,Book.author,[description],[day],\r\n"
				+ "[page],[name],[image],Book.quantity,Book.sold,Book.price\r\n"
				+ "from Book inner join Category on Book.cid = Category.id and Book.id = ?";
		try {
			conn = new SQLConnection().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
				return book;
			}
		} catch (Exception e) {
		}
		return null;
	}

	public ArrayList<Book> getBookBySearch(String str) {
		ArrayList<Book> list = new ArrayList<>();
		String query = "select*from Book where title like ?";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + str + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
				list.add(book);
			}
		} catch (Exception e) {
		}
		return list;
	}

	public Category getCategoryByCid(int cid) {
		String query = "select * from Category where Category.id = ?";
		try {
			conn = new SQLConnection().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Category(rs.getInt(1), rs.getString(2));
			}
		} catch (Exception e) {
		}
		return null;
	}

	public int getLastOrderId() {
		String query = "select top(1)Order.id from Order order by Order.id desc";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	// Phân trang sách
	public ArrayList<Book> getListByPage(ArrayList<Book> list, int start, int end) {
		ArrayList<Book> arr = new ArrayList<>();
		for (int i = start; i < end; i++) {
			arr.add(list.get(i));
		}
		return arr;
	}

	public ArrayList<Order> getListOrderByPage(ArrayList<Order> list, int start, int end) {
		ArrayList<Order> arr = new ArrayList<>();
		for (int i = start; i < end; i++) {
			arr.add(list.get(i));
		}
		return arr;
	}

	// Phan trang Review
	public ArrayList<Review> getListReviewByPage(ArrayList<Review> list, int start, int end) {
		ArrayList<Review> arr = new ArrayList<>();
		for (int i = start; i < end; i++) {
			arr.add(list.get(i));
		}
		return arr;
	}

	public int getQuantityBookAtUnderById(int id) {
		String query = "select count(*) from Book where Book.id <= ?";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	public ArrayList<Review> getReviewById(int id) {
		ArrayList<Review> list = new ArrayList<>();
		String query = "select username,content,rating,[day] \r\n"
				+ "from Review inner join [User] on Review.uid = [User].id and bid = ? ";
		try {
			conn = new SQLConnection().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Review(rs.getString(1), rs.getString(2), rs.getInt(3), String.valueOf(rs.getDate(4))));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public ArrayList<Book> getTopSell() {
		ArrayList<Book> list = new ArrayList<>();
		String query = "SELECT top 18*FROM Book ORDER BY Book.sold DESC";
		try {
			conn = new SQLConnection().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public void insertAccount(String user, String pass, String email) {
		String query = "insert into [User] values(?,?,?,?)";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.setString(3, email);
			ps.setInt(4, 2);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public void insertBook(Book b) {
		String query = "insert into Book values(?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getDescription());
			ps.setDate(4, b.getDay());
			ps.setInt(5, b.getPage());
			ps.setInt(6, b.getCid());
			ps.setString(7, b.getImage());
			ps.setInt(8, 20);
			ps.setInt(9, 0);
			ps.setInt(10, b.getPrice());
			rs = ps.executeQuery();
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public int insertOrder(Order o) {
		String query = "insert into [dbo].[Order](uid, quantity, totalmoney, status, name, phone, address, date) values(?,?,?,?,?,?,?,?)";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, o.getUid());
			ps.setInt(2, o.getQuantity());
			ps.setDouble(3, o.getTotalMoney());
			ps.setInt(4, o.getStatus());
			ps.setString(5, o.getName());
			ps.setString(6, o.getPhone());
			ps.setString(7, o.getAddress());
			ps.setString(8, o.getDay());

			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;

	}

	public void insertOrderLine(OrderLine o) {
		String query = "insert into [dbo].[OrderLine] values(?,?,?,?)";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, o.getOid());
			ps.setInt(2, o.getBid());
			ps.setDouble(3, o.getQuantity());
			ps.setDouble(4, o.getTotalMoney());
			rs = ps.executeQuery();
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public void insertReview(Review rv) {
		String query = "insert into Review values(?,?,?,?,?)";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, rv.getUid());
			ps.setInt(2, rv.getBid());
			ps.setString(3, rv.getContent());
			ps.setInt(4, rv.getRating());
			ps.setString(5, rv.getDay());
			rs = ps.executeQuery();
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public void restoreOrderByID(int code) {
		String query = "update Order set status = 0 where id = ?";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, code);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public void saveFile(String upLoadDir, String fileName, MultipartFile multipartFile) throws IOException {
		Path path = Paths.get(upLoadDir);
		if (!Files.exists(path)) {
			Files.createDirectories(path);
		}
		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path filePath = path.resolve(fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			// TODO: handle exception
			throw new IOException("khong tim thay file");
		}
	}

	public void updateBook(Book b, int bid) {
		if (b.getImage() == null) {
			String query = "update Book set title = ?,author = ?,[description] = ?,\r\n"
					+ "[day] = ?,[page] = ?,cid = ?,price = ? where Book.id = ?";

			try {
				conn = new SQLConnection().getConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1, b.getTitle());
				ps.setString(2, b.getAuthor());
				ps.setString(3, b.getDescription());
				ps.setDate(4, b.getDay());
				ps.setInt(5, b.getPage());
				ps.setInt(6, b.getCid());
				ps.setInt(7, b.getPrice());
				ps.setInt(8, bid);
				rs = ps.executeQuery();
				ps.executeUpdate();
			} catch (Exception e) {
			}
		} else {
			String query = "update Book set title = ?,author = ?,[description] = ?,\r\n"
					+ "[day] = ?,[page] = ?,cid = ?,[image] = ? where Book.id = ?";
			try {
				conn = new SQLConnection().getConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1, b.getTitle());
				ps.setString(2, b.getAuthor());
				ps.setString(3, b.getDescription());
				ps.setDate(4, b.getDay());
				ps.setInt(5, b.getPage());
				ps.setInt(6, b.getCid());
				ps.setString(7, b.getImage());
				ps.setInt(8, bid);
				rs = ps.executeQuery();
				ps.executeUpdate();
			} catch (Exception e) {
			}
		}
	}

	public void updateBookSold(int bid, int quantity) {
		String query = "update Book set Book.sold = Book.sold + ?,Book.quantity = Book.quantity - ?\r\n"
				+ "where Book.id = ?";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, quantity);
			ps.setInt(2, quantity);
			ps.setInt(3, bid);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public void updateBookSoldforDeleteOrder(int bid, int quantity) {
		String query = "update Book set Book.sold = Book.sold - ?,Book.quantity = Book.quantity + ?\r\n"
				+ "where Book.id = ?";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, quantity);
			ps.setInt(2, quantity);
			ps.setInt(3, bid);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public void updateOrder(int sl, int money, int oid) {
		String query = "update Order set quantity = quantity - ?,totalMoney = totalMoney-? where Order.id = ?";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, sl);
			ps.setInt(2, money);
			ps.setInt(3, oid);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public Map<Integer, Double> thongKeDoanhThuTheoNam(int nam) {
		String query = "SELECT MONTH(o.date), SUM(o.totalmoney) FROM [dbo].[Order] AS O \n" +
				"WHERE YEAR(o.date) = ?\n" +
				"GROUP BY MONTH(o.date) ORDER BY MONTH(o.date) ASC";
		Map<Integer, Double> map = new HashMap<>();
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, nam);
			rs = ps.executeQuery();
			while (rs.next()) {
				map.put(rs.getInt(1), rs.getDouble(2));
			}
		} catch (Exception e) {
		}
		return map;
	}

	public List<Integer> getAllYearByOrder() {
		String query = "SELECT YEAR(o.date) FROM [dbo].[Order] AS O \n" +
				"GROUP BY YEAR(o.date)\n" +
				"ORDER BY YEAR(o.date) DESC";
		List<Integer> list = new ArrayList<>();
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getInt(1));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public Integer countCategory() {
		String query = "SELECT COUNT(*) FROM [dbo].[Category]";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	public Integer countBook() {
		String query = "SELECT COUNT(*) FROM [dbo].[Book]";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	public Integer countOrder() {
		String query = "SELECT COUNT(*) FROM [dbo].[Order] WHERE status = 1";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	public Integer countCustomer() {
		String query = "SELECT COUNT(*) FROM [dbo].[User] WHERE duty = 2";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	public Double revenue() {
		String query = "SELECT SUM(totalmoney) FROM [dbo].[Order] WHERE status = 1";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getDouble(1);
			}
		} catch (Exception e) {
		}
		return 0.0;
	}

	public ArrayList<Account> getAllUserForAdmin() {
		ArrayList<Account> list = new ArrayList<>();
		String query = "SELECT username, email, duty FROM [dbo].[User] WHERE duty = 2";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Account account = new Account();
				account.setUsername(rs.getString(1));
				account.setEmail(rs.getString(2));
				account.setDuty(rs.getInt(3));
				list.add(account);
			}
		} catch (Exception e) {
		}
		return list;

	}

	public ArrayList<Account> getListByPage2(ArrayList<Account> list, int start, int end) {
		ArrayList<Account> arr = new ArrayList<>();
		for (int i = start; i < end; i++) {
			arr.add(list.get(i));
		}
		return arr;
	}

	public void deleteUser(String username) {
		String query = "UPDATE [dbo].[User] SET duty = 0 WHERE username = ?";
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}
}
