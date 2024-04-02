package Dao;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import Dto.user;

public class Dao {
		public static Connection getConnection() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/todo_list","root","root");
			return con;
		}
		public static int Saveuser(user u) throws ClassNotFoundException, SQLException {
			Connection con=getConnection();
			PreparedStatement pst=con.prepareStatement("insert into user values(?,?,?,?,?,?)");
			pst.setInt(1, u.getUserid());
			pst.setString(2,u.getUsername());
			pst.setString(3, u.getUseremail());
			pst.setLong(4, u.getUsercontact());
			pst.setString(5,u.getUserpassword());
			
			Blob imageblob= new SerialBlob(u.getUserimage());
			pst.setBlob(6, imageblob);
			
			int res=pst.executeUpdate();
			return res;
		}
		
		public static user findByEmail(String email) throws ClassNotFoundException, SQLException {
			Connection con=getConnection();
			
			PreparedStatement pst=con.prepareStatement("select * from user where useremail=?");
			pst.setString(1, email);
			
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()) {
				user u=new user();
				u.setUserid(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setUseremail(rs.getString(3));
				u.setUsercontact(rs.getLong(4));
				
				//convert blob image to byte[]
				Blob blobimage=rs.getBlob(5);
				byte[]image=blobimage.getBytes(1,(int)blobimage.length());
				u.setUserimage(image);
				
				u.setUserpassword(rs.getString(6));
				return u;
			}
			else {
				return null;
			}
		
		}
}
