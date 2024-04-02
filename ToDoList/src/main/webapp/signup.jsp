<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>todolist</title>
<style>
body{
font-family:cursive;
background-image: url("https://t3.ftcdn.net/jpg/03/02/04/06/360_F_302040655_IEH9RyDlu7LL8YCLjgL1IskhrpOlmlSv.jpg");
display: flex;
height: 100vh;
width: 100%;
justify-content: center;
align-items: center;
}
table{ 
padding:30px;
line-height:50px;
background-color:rgba(255,255,255,0.5); 
text-align: center;
border-radius: 15px;
box-shadow: 15px 15px 30px white;
font-size: large;
}
input{
padding: 10px;
border-radius: 10px;
border:none;
}


</style> 
</head>
<body>
<form action="saveuser" method="post" enctype="multipart/form-data">
<table >
		<tr >
			<td>ID:</td>
			<td><input type="text" name="id" ></td>
		</tr>
		<tr>
			<td>NAME:</td>
			<td><input type="text" name="name" ></td>
		</tr>
		<tr>
			<td>EMAIL:</td>
			<td><input type="email" name="email" ></td>
		</tr>
		<tr>
			<td>CONTACT:</td>
			<td><input type="text" name="contact" ></td>
		</tr>
		<tr>
			<td>PASSWORD:</td>
			<td><input type="password" name="password" ></td>
		</tr>
		<tr>
			<td>IMAGE:</td>
			<td><input type="file" name="image" ></td>
		</tr>
		<tr><td colspan="2"><input type="submit"></td></tr>
		
	</table>
</form>
</body>
</html>