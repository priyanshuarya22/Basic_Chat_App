<%@page import="java.sql.*" %>
<%
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	String uid = request.getParameter("uid");
	String status = request.getParameter("status");
	String query = "update status set status = ? where uid = ?";
	Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/chat?user=root&password=admin");
	PreparedStatement st = cn.prepareStatement(query);
	st.setInt(1, Integer.parseInt(status));
	st.setString(2, uid);
	st.executeUpdate();
	cn.close();
}
catch(Exception e) {
	out.println(e.getMessage());
}
%>