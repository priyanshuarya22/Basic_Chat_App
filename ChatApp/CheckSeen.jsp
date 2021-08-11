<%@page import="java.sql.*" %>
<%
try {
	String data = "";
	String sid = request.getParameter("sid");
	String rid = request.getParameter("rid");
	Class.forName("com.mysql.cj.jdbc.Driver");
	String query = "select seen from chat where sid = ? and rid = ?";
	Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/chat?user=root&password=admin");
	PreparedStatement st = cn.prepareStatement(query);
	st.setString(1, rid);
	st.setString(2, sid);
	ResultSet rs = st.executeQuery();
	while(rs.next()) {
		data += rs.getString(1) + ";";
	}
	out.println(data);
	cn.close();
}
catch(Exception e) {
	out.println(e.getMessage());
}
%>