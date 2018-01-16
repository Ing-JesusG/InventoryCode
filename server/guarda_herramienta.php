<?php
$db_name="u735139149_incod";
$mysql_username = "u735139149_incod";
$mysql_password = "gordochuy";
$server_name="mysql.hostinger.mx";
$conn = mysqli_connect($server_name,$mysql_username,$mysql_password,$db_name);

$nombre = $_POST["nombre"];
$marca = $_POST["marca"];
$cantidad = $_POST["cantidad"];

$valida = "insert into herramientas (nombre,marca,cantidad) values ('$nombre','$marca','$cantidad')";
$resultado = mysqli_query($conn,$valida);

if($resultado == true)
{
  echo "1";
}
else {
  echo "2";
}

mysqli_close($conn);
?>
