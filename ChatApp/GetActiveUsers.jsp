<%@page import="java.sql.*" %>
<%
try {
	String data = "";
	Class.forName("com.mysql.cj.jdbc.Driver");
	String query = "select name, uid from users where uid in (select uid from status where status = 1)";
	Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/chat?user=root&password=admin");
	PreparedStatement st = cn.prepareStatement(query);
	ResultSet rs = st.executeQuery();
	while(rs.next()) {
		data += rs.getString(1) + ":" + rs.getString(2) + ";";
	}
	out.println(data);
	cn.close();
}
catch(Exception e) {
	out.println(e.getMessage());
}
%>