package com;

import java.sql.*;

public class Payment {

	// DB Connection
	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/payment", "root", "");

			// For testing
			
			
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.print("DB not connected");
		}

		return con;
	}

	// Insert
	public String insertPayment(String Benefactor, String Payer, String Amount, String Account_No,String Bank) {

		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database";
			}

			// create a prepared statement
			String query = " insert into payment(`Payment_ID`,`Benefactor`,`Payer`,`Amount`,`Account_No`,`Bank`)"
					+ " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, Benefactor);
			preparedStmt.setString(3, Payer);
			preparedStmt.setDouble(4, Double.parseDouble(Amount));
			preparedStmt.setInt(5, Integer.parseInt(Account_No));
			preparedStmt.setString(6, Bank);
		

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Insertion successful";

		} catch (Exception e) {
			output = "Insertion Unsuccess";
			System.err.println(e.getMessage());
		}
		return output;
	}

	
	// Read
	public String readPayment() {

		String output = "";
		
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed
			output = "<table border=\"4\"><tr><th>Benefactor</th>" + "<th>Payer</th><th>Amount</th>"
					+ "<th>Account_No</th>" + "<th>Bank</th></tr>";

			String query = "select * from payment";

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {

				String Payment_ID  = Integer.toString(rs.getInt("Payment_ID"));
				String Benefactor = rs.getString("Benefactor");
				String Payer = rs.getString("Payer");
				String Amount = Double.toString(rs.getDouble("Amount"));
				String Account_No = Integer.toString(rs.getInt("Account_No"));
				String Bank = rs.getString("Bank");
			
				

				// Add into the html table
				output += "<tr><td>" + Benefactor + "</td>";
				output += "<td>" + Payer + "</td>";
				output += "<td>" + Amount + "</td>";
				output += "<td>" + Account_No + "</td>";
				output += "<td>" + Bank + "</td>";

			}

			con.close();

			// Complete the html table
			output += "</table>";

		} catch (Exception e) {
			output = "Error while reading.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	
	// Update
	public String updatePayment(String Payment_ID ,String Benefactor, String Payer, String Amount, String Account_No,String Bank) {

		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE payment SET Benefactor=?,Payer=?,Amount=?,Account_No=?,Bank=? WHERE Payment_ID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, Benefactor);
			preparedStmt.setString(2, Payer);
			preparedStmt.setDouble(3, Double.parseDouble(Amount));
			preparedStmt.setInt(4, Integer.parseInt(Account_No));
			preparedStmt.setString(5, Bank);
			preparedStmt.setInt(6, Integer.parseInt(Payment_ID));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Successfully Updated";

		} catch (Exception e) {
			output = "Updating unsuccesful .";
			System.err.println(e.getMessage());
		}
		return output;
	}

	
	// Delete
	public String deletePayment(String Payment_ID) {
		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from payemnt where Payment_ID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(Payment_ID));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";

		} catch (Exception e) {
			output = "Error while deleting the Product Details.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
