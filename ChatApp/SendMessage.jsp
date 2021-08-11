<%@page import="java.sql.*" %>
<%
try {
	String data = "";
	String sid = request.getParameter("sid");
	String rid = request.getParameter("rid");
	String message = request.getParameter("message");
	Class.forName("com.mysql.cj.jdbc.Driver");
	String query = "insert into chat values(?, ?, ?, 0)";
	Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/chat?user=root&password=admin");
	PreparedStatement st = cn.prepareStatement(query);
	st.setString(1, sid);
	st.setString(2, rid);
	st.setString(3, message);
	st.executeUpdate();
	cn.close();
}
catch(Exception e) {
	out.println(e.getMessage());
}
%>