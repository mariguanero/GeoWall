<?php

//conectamos con la base de Datos
$Basedatos = "GeoWall";
$link = @mysql_connect("localhost", "root","prostituta1.");	
mysql_select_db ($Basedatos,$link);

//definimos las variables a utilizar
$nick=$_GET['nick'];
$puntuacion=$_GET['puntuacion'];
$email=$_GET['email'];
$password=$_GET['password'];
$horactual= date('Y-m-d'); 

//comprovamos que el registro este y lo tratamos en caso de que este
$sql= "select * from datosusuario where nick=".$nick;
echo $sql. "<br/>" ;
$res=mysql_query($sql);
$row=mysql_fetch_array($result);
echo $row['nick'] . "<br/>";
echo $nick;
//strcmp($var1, $var2) !== 0
if(strcmp($row['nick'],$nick) !== 0){
	//Comporbamos que haya cambiado algo
	if($row['puntuacionmax']!==$puntuacion || strcmp($row['email'],$email) !== 0 || strcmp($row['password'],$password) !== 0 || $row['ultimafecha']!== $horactual){
		//Como ha cambiado algo se lo actualizamos con los nuevos datos
		$sql= "UPDATE datosusuario SET puntuacionmax=".$puntuacion.", email='".$email."', password='".$password."', ultimafecha=".$horactual." where nick='".$nick."'";
	echo  "<br/>".$sql;
	$res=mysql_query($sql);	
	}
	
}else{
	//Insertamos al usuario
	$sql= "INSERT INTO datosusuario (nick,puntuacionmax,email,password,ultimafecha) values ('".$nick."','".$puntuacion."','".$email."','".$password."','".$horactual."')";
	echo  "<br/>".$sql;
	$res=mysql_query($sql);

}

mysql_close();








/*
$datos;
echo $sql;

$res=mysql_query($sql);
$n=mysql_num_rows($res);
echo "tras la consulta";
if($n>0){
echo "Entra en el if";
	while($row=mysql_fetch_array($res)){
		
		$datos.=$row;
		
	


	}
}

*/echo $output;/*
return $datos;
*/
?>
