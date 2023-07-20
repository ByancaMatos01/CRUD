import java.sql.*;
import java.util.*;
public class My_crud {
		

			public static void main(String[] args) {
			String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
			String DB_URL="jdbc:mysql://localhost:3306/people_db";
			String USER="root";
			String PASS="";
			
		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt= conn.createStatement();
			String query="Create Table if not Exists users (Id INT NOT NULL AUTO_INCREMENT,  name VARCHAR(255), email VARCHAR(255), PRIMARY KEY (id))";
			
			stmt.execute(query);
	
			Scanner scan= new Scanner(System.in);
			
			System.out.println("1. adicionar user ");
			System.out.println("2. Verificar user");
			System.out.println("3. update user");
			System.out.println("4. detetar user");
			System.out.println("Ecolha uma opcao");
			String choice= scan.nextLine();
			
			 switch (choice) {
			case "1":
				System.out.println( "Enter user name: ");
				String name=scan.nextLine();
				
				System.out.println( "Enter user email: ");
				String email=scan.nextLine();

				query= "INSERT INTO users (name, email) VALUES ('"+name+"','"+email+"')";
				stmt.executeUpdate(query);
				break;
			case "2":
				//read user 
				System.out.println("enter user id: ");
				int id= scan.nextInt();
				
				 query= "SELECT * FROM users WHERE id = "+ id;
				 ResultSet rs= stmt.executeQuery(query);
				 if(rs.next()) {
					 System.out.println("ID:"+rs.getInt("id"));
					 System.out.println("Name:"+rs.getString("name"));
					 System.out.println("Email:"+rs.getString("email"));
					 
		
					 
				 }else {
					 System.out.println("User not found!");
				 }
				break;
			case "3":
				System.out.println("Enter user id: ");
				id= scan.nextInt();
				
				System.out.println( "Enter new  user name: ");
				name=scan.nextLine();
				
				scan.nextLine();
				
				System.out.println( "Enter new  user email: ");
				email=scan.nextLine();
				
				query= "UPDATE users SET name = '"+name+"', email = '"+email+"' WHERE id= " + id;
				
				int result= stmt.executeUpdate(query);
				
				if(result> 0) {
					System.out.println("user updated successfully" );
				}else {
					System.out.println("User not found !");
				}
				
				
				break;
				
			case "4":
				System.out.println("Enter user id: ");
				id= scan.nextInt();
				
				query= " DELETE FROM users WHERE id = " + id;
				
				 result= stmt.executeUpdate(query);
				
				if(result> 0) {
					System.out.println("user deleted successfully" );
				}else {
					System.out.println("User not found !");
				}
				
				
				
				break;
				
			}
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Erro:"+e.getMessage());
		}
			}

		
}



