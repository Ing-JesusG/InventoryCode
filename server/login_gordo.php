<?php
$db_name="u735139149_incod";
$mysql_username = "u735139149_incod";
$mysql_password = "gordochuy";
$server_name="mysql.hostinger.mx";
$conn = mysqli_connect($server_name,$mysql_username,$mysql_password,$db_name);

$valida = "insert into usuarios (nombre,contrasena) values (hola,hola)";
$resultado = mysqli_query($conn,$valida);
$validacion = mysqli_num_rows($resultado);
if($validacion == 1)
{
  echo "1";
}
else {
  echo "2";
}

mysqli_close($conn);
?>
