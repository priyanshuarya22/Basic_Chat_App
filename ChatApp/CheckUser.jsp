<%@page import="java.sql.*" %>
<%
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	String uid = request.getParameter("uid");
	String password = request.getParameter("password");
	String query = "select password from users where uid = ?";
	Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/chat?user=root&password=admin");
	PreparedStatement st = cn.prepareStatement(query);
	st.setString(1, uid);
	ResultSet rs = st.executeQuery();
	if(rs.next()) {
		if(rs.getString(1).equals(password)) {
			out.println("Passed");
		}
		else {
			out.println("Password is wrong");
		}
	}
	else {
		out.println("User does not exist");
	}
	cn.close();
}
catch(Exception e) {
	out.println(e.getMessage());
}
%>