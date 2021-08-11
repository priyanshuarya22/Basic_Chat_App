<%@page import="java.sql.*" %>
<%
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	String uid = request.getParameter("uid");
	String name = request.getParameter("name");
	String pno = request.getParameter("pno");
	String email = request.getParameter("email");
	String age = request.getParameter("age");
	String password = request.getParameter("password");
	String query = "insert into users values(?, ?, ?, ?, ?, ?)";
	Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/chat?user=root&password=admin");
	PreparedStatement st = cn.prepareStatement(query);
	st.setString(1, uid);
	st.setString(2, name);
	st.setString(3, pno);
	st.setString(4, email);
	st.setInt(5, Integer.parseInt(age));
	st.setString(6, password);
	st.executeUpdate();
	String query1 = "insert into status values(?, 0)";
	PreparedStatement st1 = cn.prepareStatement(query1);
	st1.setString(1, uid);
	st1.executeUpdate();
	cn.close();
	out.println("Data Saved");
}
catch(Exception e) {
	out.println(e.getMessage());
}
%>