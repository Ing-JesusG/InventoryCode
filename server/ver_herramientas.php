<?php
$db_name="u735139149_think";
$mysql_username = "u735139149_think";
$mysql_password = "nixlargon421994";
$server_name="mysql.hostinger.mx";


$sql= "SELECT * from herramientas";

$conn = mysqli_connect($server_name,$mysql_username,$mysql_password,$db_name);
//$result contiene la row
$result = mysqli_query($conn,$sql);
$response = array();
while($row = mysqli_fetch_array($result))
{
    // 0 es titulo, 3 es dueño, 2 es id, 1 es pensamiento, 4 fecha, 5 categoria
    array_push($response, array("Nombre"=>$row[2],"id"=>$row[3]));
}

echo json_encode(array("server_response"=>$response));

mysqli_close($conn);

?>
