package com.aarthi.aarthihotel.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.aarthi.aarthihotel.dao.DAOFactory;
import com.aarthi.aarthihotel.dao.OrderItemDAO;
import com.aarthi.aarthihotel.dto.Item;
import com.aarthi.aarthihotel.exception.DbException;
import com.aarthi.aarthihotel.model.Order;
import com.aarthi.aarthihotel.model.OrderItem;
import com.aarthi.aarthihotel.service.DiscountService;
import com.aarthi.aarthihotel.service.OrderService;




@Service
@WebServlet("/ItemLists")
public class ItemLists extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ses = request.getSession(false);
		int orderId = 0;
		OrderService order = new OrderService();
		// OrderItemDAO b=DAOFactory.getOrderItemDAO();
		Order x = new Order();
		// OrderItems ab=new OrderItems();
		LocalDateTime orderTime = LocalDateTime.now();
		x.setOrderedDate(orderTime);
		request.setAttribute("orderdate", orderTime);
		// ab.orderedDate=orderTime;
		LocalDateTime approxDeliveryTime = orderTime.plusHours(1);
		x.setApproxDeliveryTime(approxDeliveryTime);
		// x.statusInfo="ordered";
		// ab.approxDeliveryTime=approxDeliveryTime;
		request.setAttribute("approxdate", approxDeliveryTime);
		Integer id = (Integer) ses.getAttribute("UserId");
		// System.out.print(id);
		x.setUserId(id);
		// ab.userId=id;
		request.setAttribute("uid", id);
		// request.setAttribute("status",x.statusInfo);
		request.setAttribute("date", orderTime);
		request.setAttribute("approx", approxDeliveryTime);
		try {
			orderId = order.insertOrders(x);
			request.setAttribute("order", orderId);
			// System.out.println(orderId);

		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * UsersDAO obj=DAOFactory.getUsersDAO(); HttpSession
		 * session=request.getSession(false); String
		 * name=(String)session.getAttribute("name"); Long
		 * phoneno=(Long)session.getAttribute("phoneno"); int usersid=0,orderId1=0; try
		 * { usersid = obj.getUserId(name,phoneno); orderId1=obj.getOrderId(usersid); }
		 * catch (DbException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		//OrdersDAO order = DAOFactory.getOrdersDAO();
		OrderItemDAO ob = DAOFactory.getOrderItemDAO();
		DiscountService dob = new DiscountService();
		List<String> item = new ArrayList<String>();
		// List<Integer> amount=new ArrayList<Integer>();
		// List<ItemList> list=new ArrayList<ItemList>();
		String[] items = request.getParameterValues("itemId");
		System.out.println("Items:" + items);
		// Integer TotalAmount=0;
		//DiscountDAOImpl b = new DiscountDAOImpl();
		DiscountService b = new DiscountService();

		// request.setAttribute("item",items);
		// RequestDispatcher dispatch=request.getRequestDispatcher("OrderItem");
		// dispatch.forward(request, response);
		// ob.insertorderitems(a);
		// int itemid=0;

		for (String itemId : items) {

			// List<OrderItemDetails> list1=new ArrayList<OrderItemDetails>();
			String qty = request.getParameter("qty_" + itemId);
			Integer quantity = Integer.parseInt(qty);
			if (quantity > 0) {
				// quans.add(quantity);

				String price = request.getParameter("price_" + itemId);
				Integer total = Integer.parseInt(price) * quantity;

				try {

					OrderItem list = new OrderItem();
					Integer orderid = (Integer) request.getAttribute("order");
					list.setOrderId(orderid);
					System.out.println(list.getOrderId());
					list.setItemId(Integer.parseInt(itemId));
					System.out.println(list.getItemId());

					list.setQuantity(quantity);
					System.out.println(list.getQuantity());
					list.setTotalAmounts(total);
					// list.status="ordered";
					System.out.println(list.getTotalAmount());
					LocalDateTime orderTimes = LocalDateTime.now();
					list.setOrderDate(orderTimes);
					//ob.insertorderitems(list);
					ob.save(list);
					// item.addAll(b.getItemName(Integer.parseInt(itemId)));
					//String name = b.getItemName(Integer.parseInt(itemId));
					String name = b.getItemName(Integer.parseInt(itemId));
					item.add(name);
					// System.out.println(name);

					// request.setAttribute("finallist",list1);
					// a.status="ordered";

				} catch (DbException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// RequestDispatcher dm = request.getRequestDispatcher("ordersitems.jsp");
				// dm.forward(request, response);
			}

		}

		// RequestDispatcher dm = request.getRequestDispatcher("ordersitems.jsp");
		// dm.forward(request, response);
		try {
			List<Item> list1 = new ArrayList<Item>();
			list1 = b.getItemList(orderId);
			request.setAttribute("finallist", list1);

			int amount = order.calculateTotalAmts(orderId);
			order.updateTotalAmts(orderId);
			int disamt = dob.calculateDiscountAmt(orderId);
			dob.updateDiscountAmt(orderId);
			request.setAttribute("amt", amount);
			request.setAttribute("discountamt", disamt);
			request.setAttribute("itemNames", item);
			/*
			 * RequestDispatcher d = request.getRequestDispatcher("orders.jsp?orderId=" +
			 * orderId); d.forward(request, response);
			 */
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher d = request.getRequestDispatcher("orders.jsp?orderId=" + orderId);
		d.forward(request, response);
		/*
		 * RequestDispatcher d = request.getRequestDispatcher("ViewDetails.jsp");
		 * d.forward(request, response);
		 */
	}

}
