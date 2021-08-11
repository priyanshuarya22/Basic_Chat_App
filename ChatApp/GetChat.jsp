<%@page import="java.sql.*" %>
<%
try {
	String data = "";
	String sid = request.getParameter("sid");
	String rid = request.getParameter("rid");
	Class.forName("com.mysql.cj.jdbc.Driver");
	String query = "select message, seen from chat where sid in (?, ?) and rid in (?, ?)";
	Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/chat?user=root&password=admin");
	PreparedStatement st = cn.prepareStatement(query);
	st.setString(1, sid);
	st.setString(2, rid);
	st.setString(3, sid);
	st.setString(4, rid);
	ResultSet rs = st.executeQuery();
	while(rs.next()) {
		data += rs.getString(1) + ":" + rs.getString(2) + ";";
	}
	String query1 = "update chat set seen = 1 where sid = ? and rid = ?";
	PreparedStatement st1 = cn.prepareStatement(query1);
	st1.setString(1, rid);
	st1.setString(2, sid);
	st1.executeUpdate();
	out.println(data);
	cn.close();
}
catch(Exception e) {
	out.println(e.getMessage());
}
%>