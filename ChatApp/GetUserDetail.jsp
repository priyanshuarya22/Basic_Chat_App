<%@page import="java.sql.*" %>
<%
try {
	String data = "";
	String uid = request.getParameter("uid");
	Class.forName("com.mysql.cj.jdbc.Driver");
	String query = "select name from users where uid = ?";
	Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/chat?user=root&password=admin");
	PreparedStatement st = cn.prepareStatement(query);
	st.setString(1, uid);
	ResultSet rs = st.executeQuery();
	while(rs.next()) {
		data += rs.getString(1);
	}
	out.println(data);
	cn.close();
}
catch(Exception e) {
	out.println(e.getMessage());
}
%>