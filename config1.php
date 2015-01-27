<?php
//echo "<h1> HOLA </h1>";
/* Online */


// Conexion
//define("el_servidor","ONLINE");

$Basedatos = "GeoWall";
$link = @mysql_connect("localhost", "root","prostituta1.");	
mysql_select_db ($Basedatos,$link);

//Para obtener los datos
$sql= "select nick,puntuacionmax from datosusuario order by puntuacionmax  DESC ";





$res=mysql_query($sql);
while($row=mysql_fetch_assoc($res)){
       $result_array[] = array(
          'nick' => $row['nick'],
          'puntuacionmax' => $row['puntuacionmax'],
       );
    }         
   echo json_encode($result_array);

/*        $output[]=$row;	
        $output=$row;
}
 
print(json_encode($output));
*/
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
